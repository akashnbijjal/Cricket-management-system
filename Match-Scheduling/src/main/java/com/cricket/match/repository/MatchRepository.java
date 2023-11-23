package com.cricket.match.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cricket.match.model.Match;

public interface MatchRepository extends MongoRepository<Match, Long> {

	List<Match> findByTeam1ContainingIgnoreCaseOrTeam2ContainingIgnoreCase(String team1,String team2);
	
	List<Match> findByTournamentContainingIgnoreCase(String tournament);

}
