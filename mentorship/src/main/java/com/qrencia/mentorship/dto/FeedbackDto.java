package com.qrencia.mentorship.dto;

public class FeedbackDto {
	private String comment;

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public FeedbackDto(String comment) {
		super();
		this.comment = comment;
	}

	public FeedbackDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
