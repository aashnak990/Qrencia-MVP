package com.qrencia.dashboard.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.qrencia.dashboard.dto.CandidateDashboardDto;
import com.qrencia.dashboard.dto.CompetitionDto;
import com.qrencia.dashboard.dto.FeedbackDto;
import com.qrencia.dashboard.dto.TrainingCourseDto;



@RestController
public class DashboardController {
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@GetMapping("/api/allUpcomingCompetitions")
    public Collection<CompetitionDto> fetchUpcomingCompetitions(){

		return webClientBuilder.build()
		.get()
		.uri("http://QRENCIA-COMPETITIONS/competitions/upcomingCompetitions")
		.retrieve()
		.bodyToMono(new ParameterizedTypeReference<Collection<CompetitionDto>>() {})
		.block();
	}
	
	@GetMapping("/api/allUpcomingTrainingCourses")
    public Collection<TrainingCourseDto> fetchUpcomingTrainingCourses(){

		return webClientBuilder.build()
		.get()
		.uri("http://QRENCIA-MENTORSHIP/trainingCourses/upcomingTrainingCourses")
		.retrieve()
		.bodyToMono(new ParameterizedTypeReference<Collection<TrainingCourseDto>>() {})
		.block();
	}

	@GetMapping("/api/candidateDashboard/{userId}")
    public CandidateDashboardDto fetchStudentDetailUsingMicroservice(@PathVariable("userId") int userId){
		
		int countOfCompetitionsCandidateParticipatedIn = webClientBuilder.build()
				.get()
				.uri("http://QRENCIA-COMPETITIONS/countOfCompetitionsCandidateParticipatedIn/" + userId)
				.retrieve()
				.bodyToMono(Integer.class)
				.block();
		
		int countOfTrainingsCandidateParticipatedIn = webClientBuilder.build()
				.get()
				.uri("http://QRENCIA-MENTORSHIP/countOfTrainingCandidateParticipated/" + userId)
				.retrieve()
				.bodyToMono(Integer.class)
				.block();
		
		int countOfCompetitionsCandidateScoredMoreThan60Percent = webClientBuilder.build()
				.get()
				.uri("http://QRENCIA-COMPETITIONS/countOfCompetitionsCandidateScoredMoreThan60Percent/" + userId)
				.retrieve()
				.bodyToMono(Integer.class)
				.block();
		
		int countOfOngoingTrainingsOfCandidate = webClientBuilder.build()
				.get()
				.uri("http://QRENCIA-MENTORSHIP/countOfOngoingTraining/" + userId)
				.retrieve()
				.bodyToMono(Integer.class)
				.block();

		return new CandidateDashboardDto(countOfCompetitionsCandidateParticipatedIn,countOfTrainingsCandidateParticipatedIn,countOfCompetitionsCandidateScoredMoreThan60Percent,countOfOngoingTrainingsOfCandidate);		 
	 }
	
	@PostMapping("/api/registerFeedback/{userId}/{workId}")
    public Integer registerFeedback(@PathVariable("userId") int userId,@PathVariable("workId") int workId,@RequestBody FeedbackDto feedbackDto){
		
	
		Integer feedbackSubmission = webClientBuilder.build()
				.post()
				.uri("http://QRENCIA-MENTORSHIP/submitFeedback/" + userId + "/" + workId)
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.bodyValue(feedbackDto)
				.retrieve()
				.bodyToMono(Integer.class)
				.onErrorReturn(-25)
				.block();
		
		return feedbackSubmission;
	}
}

