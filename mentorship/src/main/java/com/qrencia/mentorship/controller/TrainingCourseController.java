package com.qrencia.mentorship.controller;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qrencia.mentorship.dto.FeedbackDto;
import com.qrencia.mentorship.dto.TrainingCourseDto;
import com.qrencia.mentorship.service.TrainingCourseService;

@RestController
public class TrainingCourseController {
	private static final Logger LOGGER = LoggerFactory.getLogger(TrainingCourseController.class);
	
	@Autowired
	private TrainingCourseService trainingCourseService;
	
	/**
     * @author Aashna Kapoor
     * @since 17-01-2023
     * @return Collection of {@link TrainingCourseDto} if success; else returns null;
     */
     @GetMapping("trainingCourses/upcomingTrainingCourses")
     public Collection<TrainingCourseDto> fetchUpcomingTrainingCourses(){
    	 LOGGER.debug("Request received in controller to fetch the list of upcoming training courses");
 		 return trainingCourseService.fetchUpcomingTrainingCourses();
     }
     
     /**
  	 * @author Aashna Kapoor
  	 * @since 18-01-2023
  	 * Method to fetch the total number of training candidate has gone through
  	 * @return total number of training candidate has gone through if successful , else 0 in case of exception
  	 */
      
  	@GetMapping("/countOfTrainingCandidateParticipated/{userId}")
  	public int countOfTrainingCandidateParticipated(@PathVariable("userId") int userId) {
  		LOGGER.debug("Request received in controller to fetch total number of training candidate has gone through");
  		return trainingCourseService.countOfTrainingCandidateParticipated(userId);
  	}
  	
  	/**
  	 * @author Aashna Kapoor
  	 * @since 18-01-2023
  	 * Method to fetch the total number of ongoing trainings
  	 * @return total number of ongoing trainings if successful , else 0 in case of exception
  	 */
      
  	@GetMapping("/countOfOngoingTraining/{userId}")
  	public int countOfOngoingTraining(@PathVariable("userId") int userId) {
  		LOGGER.debug("Request received in controller to fetch total number of ongoing training");
  		return trainingCourseService.countOfOngoingTraining(userId);
  	}
  	
  	/**
  	 * @author Aashna Kapoor
  	 * @since 18-01-2023
  	 * Method to register feedback
  	 */
	@PostMapping(value= "/submitFeedback/{userId}/{workId}",consumes=MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<Integer> submitFeedback(@RequestBody FeedbackDto feedbackDto ,@PathVariable("userId") int userId,@PathVariable("workId") int workId)
	{
		LOGGER.debug("Request received in controller to submit the feedback");
		return trainingCourseService.submitFeedback(feedbackDto, userId,workId);
	}
}
