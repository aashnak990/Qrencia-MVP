package com.qrencia.competitions.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.qrencia.competitions.common.AbstractTransactionalDao;
import com.qrencia.competitions.config.CompetitionConfig;
import com.qrencia.competitions.dto.CompetitionDto;

@Repository
public class CompetitionDao extends AbstractTransactionalDao{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CompetitionDao.class);
	private static CompetitionDetailsMapper competitionDetailsMapper = new CompetitionDetailsMapper();
	
	@Autowired
	private CompetitionConfig competitionConfig;
	
	/**
     * @author Aashna Kapoor
     * @since 17-01-2023
     * @return Collection of {@link CompetitionDto} if success; else returns null;
     */
	public Collection<CompetitionDto> fetchUpcomingCompetitions()
	{
		LOGGER.debug("Request received in dao to fetch the list of upcoming competitions");
		try 
		{
			LOGGER.debug("In try block to execute the query and fetch the result");
			return getJdbcTemplate().query(competitionConfig.getFetchUpcomingCompetitionsDetails(), competitionDetailsMapper);
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
	 private static class CompetitionDetailsMapper implements RowMapper<CompetitionDto>
	 {
		 @Override
		 public CompetitionDto mapRow(ResultSet rs, int rowNum) throws SQLException
		 {
			 int id = rs.getInt("id");
			 String name = rs.getString("name");
			 String mode = rs.getString("mode");
			 Date startDate = rs.getDate("start_date");
			 Date endDate = rs.getDate("end_date");
			 String activeFlag = rs.getString("active_flg");
			 
			 return new CompetitionDto(id,name,mode,startDate,endDate,activeFlag);
		 }
	 }
	 
	 /**
	 	 * @author Aashna Kapoor
	 	 * @since 18-01-2023
	 	 * Method to fetch the total number of competitions candidate participated in
	 	 * @return CompetitionsCandidateParticipatedInDto
	 	 */
		
		public int countOfCompetitionsCandidateParticipatedIn(int userId) {
			LOGGER.debug("Request received in dao method to fetch total number of competitions candidate participated in with candidate id - {}",userId);
			HashMap<String,Object> params = new HashMap<>(1);
			params.put("candidateId", userId);
			
			try 
			{
				LOGGER.debug("In try block to fetch total number of competitions candidate participated in");
				return getJdbcTemplate().queryForObject(competitionConfig.getTotalCompetitionsCandidateParticipatedIn(),params ,Integer.class);
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
	 	 * Method to fetch the total number of competitions in which candidate scored more than 60%
	 	 * @return total number of competitions in which candidate scored more than 60% if successful , else 0 in case of exception
	 	 */
		public int countOfCompetitionsCandidateScoresMoreThan60Percent(int userId) {
			LOGGER.debug("Request received in dao method to fetch total number of competitions in which candidate scored more than 60% with candidate id - {}",userId);
			HashMap<String,Object> params = new HashMap<>(1);
			params.put("candidateId", userId);
			
			try 
			{
				LOGGER.debug("In try block to fetch total number of competitions in which candidate scored more than 60%");
				return getJdbcTemplate().queryForObject(competitionConfig.getTotalCompetitionsCandidateScoredMoreThan60Percent(),params ,Integer.class);
			}
			catch (Exception e) 
			{
				LOGGER.error("An exception occurred while fetching the result - ",e);
				return 0;
			}
		}
}
