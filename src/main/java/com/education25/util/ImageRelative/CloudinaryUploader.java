package com.education25.util.ImageRelative;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import java.io.InputStream;
import java.util.Map;

public class CloudinaryUploader {

    private static final Cloudinary CLOUDINARY_INSTANCE;

    static {
    	
        CLOUDINARY_INSTANCE = new Cloudinary(
                ObjectUtils.asMap(
                        "cloud_name", System.getenv("CLOUD_NAME"),
                        "api_key", System.getenv("CLOUD_API_KEY"),
                        "api_secret", System.getenv("CLOUD_API_SECRET")
                )
        );
    }

    // ================= UPLOAD =================
    public static String upload(InputStream inputStream, String dir) {

        if (inputStream == null) {
            throw new IllegalArgumentException("Image cannot be empty.");
        }

        try {

            Map<?, ?> result = CLOUDINARY_INSTANCE.uploader().upload(inputStream.readAllBytes(), ObjectUtils.asMap(
                            "folder", dir));

            return result.get("secure_url").toString();

        } catch (Exception e) {
        	e.printStackTrace();
            throw new RuntimeException("Failed to upload image to Cloudinary.", e);
        }
    }

 // ================= DELETE USING IMAGE URL =================
    public static boolean deleteByUrl(String imageUrl) {

        if (imageUrl == null || imageUrl.trim().isEmpty()) {
            throw new IllegalArgumentException("Image URL cannot be null or empty.");
        }

        try {

            // Extract public_id from secure_url
            String publicId = extractPublicId(imageUrl);

            Map<?, ?> result = CLOUDINARY_INSTANCE
                    .uploader()
                    .destroy(publicId, ObjectUtils.emptyMap());

            String status = result.get("result").toString();

            return "ok".equals(status);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to delete image from Cloudinary.", e);
        }
    }
    private static String extractPublicId(String imageUrl) {

        try {
            // Remove version part (v123456/)
            String[] parts = imageUrl.split("/upload/");
            String pathPart = parts[1];

            // Remove version number
            pathPart = pathPart.replaceFirst("v[0-9]+/", "");

            // Remove file extension
            int dotIndex = pathPart.lastIndexOf(".");
            return pathPart.substring(0, dotIndex);

        } catch (Exception e) {
            throw new RuntimeException("Invalid Cloudinary URL format.");
        }
    }
}