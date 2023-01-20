package com.qrencia.dashboard.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CompetitionDto {	
	private int id;
	private String name;
	private String mode;
	
	@JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate startDate;
	
	@JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate endDate;
	
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
	
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public String getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}
	
	public CompetitionDto(int id, String name, String mode, LocalDate startDate, LocalDate endDate, String activeFlag) {
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
