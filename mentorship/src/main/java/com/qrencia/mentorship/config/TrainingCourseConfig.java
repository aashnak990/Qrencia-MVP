package com.qrencia.mentorship.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:sql/manageTrainingCourse.yml")
@ConfigurationProperties(prefix = "manage-training-course")

public class TrainingCourseConfig {

	@Value("${fetchUpcomingTrainingCourseDetails}")
	private String fetchUpcomingTrainingCourseDetails;
	
	@Value("${totalTrainingsCandidateParticipatedIn}")
	private String totalTrainingsCandidateParticipatedIn;
	
	@Value("${totalOngoingTrainings}")
	private String totalOngoingTrainings;
	
	@Value("${submitFeedback}")
	private String submitFeedback;

	public String getFetchUpcomingTrainingCourseDetails() {
		return fetchUpcomingTrainingCourseDetails;
	}

	public void setFetchUpcomingTrainingCourseDetails(String fetchUpcomingTrainingCourseDetails) {
		this.fetchUpcomingTrainingCourseDetails = fetchUpcomingTrainingCourseDetails;
	}

	public String getTotalTrainingsCandidateParticipatedIn() {
		return totalTrainingsCandidateParticipatedIn;
	}

	public void setTotalTrainingsCandidateParticipatedIn(String totalTrainingsCandidateParticipatedIn) {
		this.totalTrainingsCandidateParticipatedIn = totalTrainingsCandidateParticipatedIn;
	}

	public String getTotalOngoingTrainings() {
		return totalOngoingTrainings;
	}

	public void setTotalOngoingTrainings(String totalOngoingTrainings) {
		this.totalOngoingTrainings = totalOngoingTrainings;
	}

	public String getSubmitFeedback() {
		return submitFeedback;
	}

	public void setSubmitFeedback(String submitFeedback) {
		this.submitFeedback = submitFeedback;
	}
	
	
	
}