package com.qrencia.mentorship.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.qrencia.mentorship.common.AbstractTransactionalDao;
import com.qrencia.mentorship.config.TrainingCourseConfig;
import com.qrencia.mentorship.dto.FeedbackDto;
import com.qrencia.mentorship.dto.TrainingCourseDto;

@Repository
public class TrainingCourseDao extends AbstractTransactionalDao{

	private static final Logger LOGGER = LoggerFactory.getLogger(TrainingCourseDao.class);
	private static TrainingCourseDetailsMapper trainingCourseDetailsMapper = new TrainingCourseDetailsMapper();
	
	@Autowired
	private TrainingCourseConfig trainingCourseConfig;
	
	/**
     * @author Aashna Kapoor
     * @since 17-01-2023
     * @return Collection of {@link TrainingCourseDto} if success; else returns null;
     */
	public Collection<TrainingCourseDto> fetchUpcomingTrainingCourses()
	{
		LOGGER.debug("Request received in dao to fetch the list of upcoming training course");
		try 
		{
			LOGGER.debug("In try block to execute the query and fetch the result");
			return getJdbcTemplate().query(trainingCourseConfig.getFetchUpcomingTrainingCourseDetails(), trainingCourseDetailsMapper);
		}
		catch (Exception e) 
		{
			LOGGER.error("An exception occurred while fetching the result - ",e);
			return null;
		}
	}
	
	/**
	  * 
	  * @author Aashna Kapoor
	  *
	  */
	 private static class TrainingCourseDetailsMapper implements RowMapper<TrainingCourseDto>
	 {
		 @Override
		 public TrainingCourseDto mapRow(ResultSet rs, int rowNum) throws SQLException
		 {
			 int id = rs.getInt("id");
			 String name = rs.getString("name");
			 String mode = rs.getString("mode");
			 Date startDate = rs.getDate("start_date");
			 Date endDate = rs.getDate("end_date");
			 String activeFlag = rs.getString("active_flg");
			 
			 return new TrainingCourseDto(id,name,mode,startDate,endDate,activeFlag);
		 }
	 }
	 
	 /**
	  	 * @author Aashna Kapoor
	  	 * @since 18-01-2023
	  	 * Method to fetch the total number of training candidate has gone through
	  	 * @return total number of training candidate has gone through if successful , else 0 in case of exception
	  	 */
		public int countOfTrainingCandidateParticipated(int userId) {
			LOGGER.debug("Request received in dao method to fetch total number of training candidate has gone through with candidate id - {}",userId);
			HashMap<String,Object> params = new HashMap<>(1);
			params.put("candidateId", userId);
			
			try 
			{
				LOGGER.debug("In try block to fetch total number of number of training candidate has gone through");
				return getJdbcTemplate().queryForObject(trainingCourseConfig.getTotalTrainingsCandidateParticipatedIn(),params ,Integer.class);
			}
			catch (Exception e) 
			{
				LOGGER.error("An exception occurred while fetching the result - ",e);
				return 0;
			}
		}
		
		/**
	  	 * @author Aashna Kapoor
	  	 * @since 18-01-2023
	  	 * Method to fetch the total number of ongoing trainings
	  	 * @return total number of ongoing trainings if successful , else 0 in case of exception
	  	 */
		public int countOfOngoingTraining(int userId) {
			LOGGER.debug("Request received in dao method to fetch total number of ongoing trainings with candidate id - {}",userId);
			HashMap<String,Object> params = new HashMap<>(1);
			params.put("candidateId", userId);
			
			try 
			{
				LOGGER.debug("In try block to fetch total number of ongoing trainings");
				return getJdbcTemplate().queryForObject(trainingCourseConfig.getTotalOngoingTrainings(),params ,Integer.class);
			}
			catch (Exception e) 
			{
				LOGGER.error("An exception occurred while fetching the result - ",e);
				return 0;
			}
		}
		
		/**
	  	 * @author Aashna Kapoor
	  	 * @since 18-01-2023
	  	 * Method to register feedback
	  	 */
		public int submitFeedback(FeedbackDto feedbackDto, int userId, int workId){
			LOGGER.debug("Request received in dao to sumit the feedback details");
			Map<String,Object>params = new HashMap<>(3);
			params.put("comment", feedbackDto.getComment());
			params.put("userId", userId);
			params.put("workId", workId);
			
			LOGGER.debug("Hashmap created and parameters inserted into hashmap");
			try 
			{
				LOGGER.debug("In try block to submit the feedback");
				return insert(trainingCourseConfig.getSubmitFeedback(), params, "id");
			}
			catch (Exception e) 
			{
				LOGGER.error("An exception occurred while submitting the feedback, Exception - {}",e);
				return 0;
			}
		}

}
