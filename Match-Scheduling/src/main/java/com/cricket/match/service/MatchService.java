package com.cricket.match.service;

import java.util.List;

import com.cricket.match.model.Match;

public interface MatchService {

	Match createMatch(Match match);
	
	List<Match> allmatches();
	
	List<Match> listmatchesbyteam(String team1,String team2);
	
	Match findbymatchid(long matchId);
	
	public List<Match> listmatchesbytournament(String tournament);
	
}
