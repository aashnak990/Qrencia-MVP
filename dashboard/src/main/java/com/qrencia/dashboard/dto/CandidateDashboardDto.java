package com.qrencia.dashboard.dto;

public class CandidateDashboardDto {
	private int competitionsCandidateParticipatedIn;
	private int trainingsCandidateGoneThrough;
	private int competitionsInWhichScoreIsGreaterThan60Percent;
	private int countOfOngoingTrainings;
	
	public int getCompetitionsCandidateParticipatedIn() {
		return competitionsCandidateParticipatedIn;
	}

	public void setCompetitionsCandidateParticipatedIn(int competitionsCandidateParticipatedIn) {
		this.competitionsCandidateParticipatedIn = competitionsCandidateParticipatedIn;
	}

	public int getTrainingsCandidateGoneThrough() {
		return trainingsCandidateGoneThrough;
	}

	public void setTrainingsCandidateGoneThrough(int trainingsCandidateGoneThrough) {
		this.trainingsCandidateGoneThrough = trainingsCandidateGoneThrough;
	}

	public int getCompetitionsInWhichScoreIsGreaterThan60Percent() {
		return competitionsInWhichScoreIsGreaterThan60Percent;
	}

	public void setCompetitionsInWhichScoreIsGreaterThan60Percent(int competitionsInWhichScoreIsGreaterThan60Percent) {
		this.competitionsInWhichScoreIsGreaterThan60Percent = competitionsInWhichScoreIsGreaterThan60Percent;
	}

	public int getCountOfOngoingTrainings() {
		return countOfOngoingTrainings;
	}

	public void setCountOfOngoingTrainings(int countOfOngoingTrainings) {
		this.countOfOngoingTrainings = countOfOngoingTrainings;
	}

	public CandidateDashboardDto(int countOfCompetitionsCandidateParticipatedIn, int trainingsCandidateGoneThrough,
			int competitionsInWhichScoreIsGreaterThan60Percent, int countOfOngoingTrainings) {
		super();
		this.competitionsCandidateParticipatedIn = countOfCompetitionsCandidateParticipatedIn;
		this.trainingsCandidateGoneThrough = trainingsCandidateGoneThrough;
		this.competitionsInWhichScoreIsGreaterThan60Percent = competitionsInWhichScoreIsGreaterThan60Percent;
		this.countOfOngoingTrainings = countOfOngoingTrainings;
	}

	public CandidateDashboardDto() {
		super();
		// TODO Auto-generated constructor stub
	}	
}
