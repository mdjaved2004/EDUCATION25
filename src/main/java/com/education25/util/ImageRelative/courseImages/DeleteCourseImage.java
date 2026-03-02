package com.education25.util.ImageRelative.courseImages;

import com.education25.util.ImageRelative.CloudinaryUploader;

public class DeleteCourseImage {
	public boolean deleteImage(String imageUrl) {

        if (imageUrl == null || imageUrl.trim().isEmpty()) {
            throw new IllegalArgumentException("Course name cannot be null or empty.");
        }
        try {
            return CloudinaryUploader.deleteByUrl(imageUrl);

        } catch (Exception e) {
            throw new RuntimeException("Course image delete failed.", e);
        }
    }
}
