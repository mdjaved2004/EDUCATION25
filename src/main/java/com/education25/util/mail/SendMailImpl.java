package com.education25.util.mail;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class SendMailImpl implements SendMail {

    @Override
    public boolean sendEmailWithAttachment(String to, String from, String subject, String messageText) {
        boolean result = false;
        System.out.println("=========================Task3");
        System.out.println("=========================to :"+to);
        System.out.println("=========================from :"+from);
        System.out.println("=========================subject :"+subject);
        System.out.println("=========================messageText :"+messageText);
        try {
            // 1. Render Dashboard se Variables uthayein
            String apiKey = System.getenv("SENDGRID_API_KEY");
            String verifiedSender = System.getenv("SENDER_EMAIL");
            if(apiKey!=null) {
            	 System.out.println("=========================Task3");
            }else if(verifiedSender!=null) {
            	 System.out.println("=========================Task4");
            }else {
            	
            	System.out.println("=========================Task5");
            }

            // 2. SendGrid API Endpoint
            URL url = new URL("https://api.sendgrid.com/v3/mail/send");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            System.out.println("=========================Task6");
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", "Bearer " + apiKey);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);
            System.out.println("=========================Task7");
            // 3. JSON Payload (Variables ka sahi use)
            // messageText ko clean karna zaroori hai taaki JSON break na ho
            String cleanMessage = messageText.replace("\"", "\\\"").replace("\n", "").replace("\r", "");
            System.out.println("=========================Task8");
            String jsonPayload = "{"
                    + "\"personalizations\":[{\"to\":[{\"email\":\"" + to + "\"}]}],"
                    + "\"from\":{\"email\":\"" + verifiedSender + "\"},"
                    + "\"subject\":\"" + subject + "\","
                    + "\"content\":[{\"type\":\"text/html\",\"value\":\"" + cleanMessage + "\"}]"
                    + "}";
            System.out.println("=========================jsonPayload :"+jsonPayload);
            // 4. Data Send Karein
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonPayload.getBytes(StandardCharsets.UTF_8);
                System.out.println("=========================Task10");
                os.write(input, 0, input.length);
            }

            // 5. Response Code Check Karein
            int responseCode = conn.getResponseCode();
            System.out.println("=========================Task11");
            System.out.println("SendGrid Response Code: " + responseCode);

            if (responseCode == 202 || responseCode == 200) {
            	 System.out.println("=========================task20 :");
                result = true;
            } else {
                // Logs mein error dekhne ke liye
                System.out.println("Error: Email send nahi hua. Response: " + responseCode);
            }

        } catch (Exception e) {
            System.err.println("Exception in SendMailImpl:");
            e.printStackTrace();
            result = false;
        }

        return result;
    }
}