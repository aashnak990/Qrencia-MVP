package com.qrencia.competitions.service;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qrencia.competitions.dao.CompetitionDao;
import com.qrencia.competitions.dto.CompetitionDto;

@Service
public class CompetitionService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CompetitionService.class);
	
	@Autowired
	private CompetitionDao competitionDao;
	
	/**
     * @author Aashna Kapoor
     * @since 17-01-2023
     * @return Collection of {@link CompetitionDto} if success; else returns null;
     */
	public Collection<CompetitionDto> fetchUpcomingCompetitions()
	{
		LOGGER.debug("Request received in service to fetch the list of upcoming competitions");
		return competitionDao.fetchUpcomingCompetitions();
	}
	
	/**
 	 * @author Aashna Kapoor
 	 * @since 18-01-2023
 	 * Method to fetch the total number of competitions candidate participated in
 	 * @return CompetitionsCandidateParticipatedInDto
 	 */
	public int countOfCompetitionsCandidateParticipatedIn(int userId) {
		LOGGER.debug("Request received in service to fetch total number of competitions candidate participated in");
        return competitionDao.countOfCompetitionsCandidateParticipatedIn(userId);
	}
	
	/**
 	 * @author Aashna Kapoor
 	 * @since 18-01-2023
 	 * Method to fetch the total number of competitions in which candidate scored more than 60%
 	 * @return total number of competitions in which candidate scored more than 60% if successful , else 0 in case of exception
 	 */
	public int countOfCompetitionsCandidateScoresMoreThan60Percent(int userId) {
		LOGGER.debug("Request received in service to fetch total number of competitions in which candidate scored more than 60%");
        return competitionDao.countOfCompetitionsCandidateScoresMoreThan60Percent(userId);
	}
}
