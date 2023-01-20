package com.qrencia.competitions.dto;

public class CountOfCompetitionsParticipationDto {
	private int competitionParticipationByCandidate;

	public int getCompetitionParticipationByCandidate() {
		return competitionParticipationByCandidate;
	}

	public void setCompetitionParticipationByCandidate(int competitionParticipationByCandidate) {
		this.competitionParticipationByCandidate = competitionParticipationByCandidate;
	}
	
	public CountOfCompetitionsParticipationDto(int competitionParticipationByCandidate) {
		super();
		this.competitionParticipationByCandidate = competitionParticipationByCandidate;
	}

	public CountOfCompetitionsParticipationDto() {
		super();
		// TODO Auto-generated constructor stub
	}
}
