package com.qrencia.competitions.controller;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.qrencia.competitions.dto.CompetitionDto;
import com.qrencia.competitions.service.CompetitionService;

@RestController
public class CompetitionController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CompetitionController.class);
	
	@Autowired
	private CompetitionService competitionService;
	
	/**
     * @author Aashna Kapoor
     * @since 17-01-2023
     * @return Collection of {@link CompetitionDto} if success; else returns null;
     */
     @GetMapping("competitions/upcomingCompetitions")
     public Collection<CompetitionDto> fetchUpcomingCompetitions(){
    	 LOGGER.debug("Request received in controller to fetch the list of upcoming competitions");
 		 return competitionService.fetchUpcomingCompetitions();
     }
     
     /**
 	 * @author Aashna Kapoor
 	 * @since 18-01-2023
 	 * Method to fetch the total number of competitions candidate participated in
 	 * @return total number of competitions candidate participated in if successful , else 0 in case of exception
 	 */
     
 	@GetMapping("/countOfCompetitionsCandidateParticipatedIn/{userId}")
 	public int countOfCompetitionsCandidateParticipatedIn(@PathVariable("userId") int userId) {
 		LOGGER.debug("Request received in controller to fetch total number of competitions candidate participated in");
 		return competitionService.countOfCompetitionsCandidateParticipatedIn(userId);
 	}
 	
 	/**
 	 * @author Aashna Kapoor
 	 * @since 18-01-2023
 	 * Method to fetch the total number of competitions in which candidate scored more than 60%
 	 * @return total number of competitions in which candidate scored more than 60% if successful , else 0 in case of exception
 	 */
     
 	@GetMapping("/countOfCompetitionsCandidateScoredMoreThan60Percent/{userId}")
 	public int countOfCompetitionsCandidateScoresMoreThan60Percent(@PathVariable("userId") int userId) {
 		LOGGER.debug("Request received in controller to fetch total number of competitions in which candidate scored more than 60%");
 		return competitionService.countOfCompetitionsCandidateScoresMoreThan60Percent(userId);
 	}
}
