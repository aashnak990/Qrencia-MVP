package com.qrencia.mentorship.service;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qrencia.mentorship.dao.TrainingCourseDao;
import com.qrencia.mentorship.dto.FeedbackDto;
import com.qrencia.mentorship.dto.TrainingCourseDto;

@Service
public class TrainingCourseService {
private static final Logger LOGGER = LoggerFactory.getLogger(TrainingCourseService.class);
	
	@Autowired
	private TrainingCourseDao trainingCourseDao;
	
	/**
     * @author Aashna Kapoor
     * @since 17-01-2023
     * @return Collection of {@link TrainingCourseDto} if success; else returns null;
     */
	public Collection<TrainingCourseDto> fetchUpcomingTrainingCourses()
	{
		LOGGER.debug("Request received in service to fetch the list of training courses");
		return trainingCourseDao.fetchUpcomingTrainingCourses();
	}
	
	/**
  	 * @author Aashna Kapoor
  	 * @since 18-01-2023
  	 * Method to fetch the total number of training candidate has gone through
  	 * @return total number of training candidate has gone through if successful , else 0 in case of exception
  	 */
	public int countOfTrainingCandidateParticipated(int userId) {
		LOGGER.debug("Request received in service to fetch total number of training candidate has gone through");
        return trainingCourseDao.countOfTrainingCandidateParticipated(userId);
	}
	
	/**
  	 * @author Aashna Kapoor
  	 * @since 18-01-2023
  	 * Method to fetch the total number of ongoing trainings
  	 * @return total number of ongoing trainings if successful , else 0 in case of exception
  	 */
	public int countOfOngoingTraining(int userId) {
		LOGGER.debug("Request received in service to fetch total number of ongoing trainings");
        return trainingCourseDao.countOfOngoingTraining(userId);
	}
	
	/**
  	 * @author Aashna Kapoor
  	 * @since 18-01-2023
  	 * Method to register feedback
  	 */
	public ResponseEntity<Integer> submitFeedback(FeedbackDto feedbackDto, int userId, int workId)
	{
		int feedbackSubmitted = trainingCourseDao.submitFeedback(feedbackDto,userId,workId);
		if(feedbackSubmitted==0)
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(-25);
		}
		else {
			return ResponseEntity.status(HttpStatus.CREATED).body(1);
		}
	}
}
