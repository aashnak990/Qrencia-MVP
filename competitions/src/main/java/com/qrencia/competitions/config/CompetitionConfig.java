package com.qrencia.competitions.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:sql/manageCompetitions.yml")
@ConfigurationProperties(prefix = "manage-competitions")

public class CompetitionConfig {

	@Value("${fetchUpcomingCompetitionsDetails}")
	private String fetchUpcomingCompetitionsDetails;
	
	@Value("${totalCompetitionsCandidateParticipatedIn}")
	private String totalCompetitionsCandidateParticipatedIn;
	
	@Value("${totalCompetitionsCandidateScoredMoreThan60Percent}")
	private String totalCompetitionsCandidateScoredMoreThan60Percent;

	public String getFetchUpcomingCompetitionsDetails() {
		return fetchUpcomingCompetitionsDetails;
	}

	public void setFetchUpcomingCompetitionsDetails(String fetchUpcomingCompetitionsDetails) {
		this.fetchUpcomingCompetitionsDetails = fetchUpcomingCompetitionsDetails;
	}

	public String getTotalCompetitionsCandidateParticipatedIn() {
		return totalCompetitionsCandidateParticipatedIn;
	}

	public void setTotalCompetitionsCandidateParticipatedIn(String totalCompetitionsCandidateParticipatedIn) {
		this.totalCompetitionsCandidateParticipatedIn = totalCompetitionsCandidateParticipatedIn;
	}

	public String getTotalCompetitionsCandidateScoredMoreThan60Percent() {
		return totalCompetitionsCandidateScoredMoreThan60Percent;
	}

	public void setTotalCompetitionsCandidateScoredMoreThan60Percent(
			String totalCompetitionsCandidateScoredMoreThan60Percent) {
		this.totalCompetitionsCandidateScoredMoreThan60Percent = totalCompetitionsCandidateScoredMoreThan60Percent;
	}
	
	
	
	
}
