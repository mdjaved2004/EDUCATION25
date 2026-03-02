package com.education25.model.userModel.coursesModel;

public class PaymentRequestModel {
	private int userId;
    private int amount;
    private int subCourseSortId;
    private String paymentId;
    private String orderId;
    private String signature;
	
    public PaymentRequestModel(int userId, int amount, int subCourseSortId, String paymentId, String orderId,
			String signature) {
		super();
		this.userId = userId;
		this.amount = amount;
		this.subCourseSortId = subCourseSortId;
		this.paymentId = paymentId;
		this.orderId = orderId;
		this.signature = signature;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getSubCourseSortId() {
		return subCourseSortId;
	}

	public void setSubCourseSortId(int subCourseSortId) {
		this.subCourseSortId = subCourseSortId;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	} 
}