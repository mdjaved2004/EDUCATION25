package com.education25.util.ImageRelative.paperImages;

import javax.servlet.http.Part;

import com.education25.util.ImageRelative.CloudinaryUploader;

public class UploadPaperImage {

    public String uploadPaperImage(Part inputImage) {
    		String dir="education25PaperImages";
    		if (inputImage == null || inputImage.getSize() == 0) {
            throw new IllegalArgumentException("Uploaded image is empty.");
        }
    		
        try {
            return CloudinaryUploader.upload(inputImage.getInputStream(), dir);

        } catch (Exception e) {
            throw new RuntimeException("Course image upload failed.", e);
        }
    }
}