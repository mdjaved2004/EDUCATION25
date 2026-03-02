package com.education25.model.adminModel.coursesControlModel;

import javax.servlet.http.Part;

public class SubCourseImageUpdateModel {
	private String course_name;
	private String sub_course_short_id;
	private String old_image_link;
	private Part image_input;
	private int adminId;
	
	public SubCourseImageUpdateModel(String course_name, String sub_course_short_id, String old_image_link,
			Part image_input, int adminId) {
		super();
		this.course_name = course_name;
		this.sub_course_short_id = sub_course_short_id;
		this.old_image_link = old_image_link;
		this.image_input = image_input;
		this.adminId = adminId;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public String getSub_course_short_id() {
		return sub_course_short_id;
	}

	public void setSub_course_short_id(String sub_course_short_id) {
		this.sub_course_short_id = sub_course_short_id;
	}

	public String getOld_image_link() {
		return old_image_link;
	}

	public void setOld_image_link(String old_image_link) {
		this.old_image_link = old_image_link;
	}

	public Part getImage_input() {
		return image_input;
	}

	public void setImage_input(Part image_input) {
		this.image_input = image_input;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
}