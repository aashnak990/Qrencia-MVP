package com.qrencia.competitions.dto;

import java.util.Date;

public class CompetitionDto {	
	private int id;
	private String name;
	private String mode;
	private Date startDate;
	private Date endDate;
	private String activeFlag;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}
	public CompetitionDto(int id, String name, String mode, Date startDate, Date endDate, String activeFlag) {
		super();
		this.id = id;
		this.name = name;
		this.mode = mode;
		this.startDate = startDate;
		this.endDate = endDate;
		this.activeFlag = activeFlag;
	}
	public CompetitionDto() {
		super();
		// TODO Auto-generated constructor stub
	}
}
