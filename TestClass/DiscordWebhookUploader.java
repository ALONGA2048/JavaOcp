import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class DiscordWebhookUploader {
    public static void main(String[] args) {
        String webhookUrl = "https://discord.com/api/webhooks/1343608019396726867/RpOzGiRU-YTgZvPkKb5_JUzR3UHFBh9IdbBj57Mj2dNzSSFN6gl-J_lK3hx2wnZ1uQSl"; 
        String filePath = "C:\\Users\\88690\\Desktop\\allData3.txt"; // 替換為你的檔案路徑

        try {
            File file = new File(filePath);
            uploadFileToDiscord(webhookUrl, file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void uploadFileToDiscord(String webhookUrl, File file) throws IOException {
        String boundary = "----WebKitFormBoundary" + System.currentTimeMillis();
        URL url = new URL(webhookUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);

        try (OutputStream outputStream = conn.getOutputStream();
             PrintWriter writer = new PrintWriter(new OutputStreamWriter(outputStream, "UTF-8"), true)) {

            // JSON Payload (Optional)
            String jsonPayload = "{\"content\": \"Here is your file!\"}";
            writer.append("--").append(boundary).append("\r\n");
            writer.append("Content-Disposition: form-data; name=\"payload_json\"").append("\r\n\r\n");
            writer.append(jsonPayload).append("\r\n");
            writer.flush();

            // File Upload
            writer.append("--").append(boundary).append("\r\n");
            writer.append("Content-Disposition: form-data; name=\"file\"; filename=\"").append(file.getName()).append("\"\r\n");
            writer.append("Content-Type: application/octet-stream\r\n\r\n");
            writer.flush();

            try (FileInputStream inputStream = new FileInputStream(file)) {
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                outputStream.flush();
            }

            writer.append("\r\n").append("--").append(boundary).append("--").append("\r\n");
            writer.flush();
        }

        int responseCode = conn.getResponseCode();
        System.out.println("Response Code: " + responseCode);

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}
