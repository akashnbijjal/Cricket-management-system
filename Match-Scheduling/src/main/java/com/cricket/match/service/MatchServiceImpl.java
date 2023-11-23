package com.cricket.match.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cricket.match.model.Match;
import com.cricket.match.repository.MatchRepository;

@Service
public class MatchServiceImpl implements MatchService {

	@Autowired
	private MatchRepository repository;

	@Override
	public Match createMatch(Match match) {
		return repository.save(match);
	}

	@Override
	public List<Match> allmatches() {
		List<Match> list = repository.findAll();
		return list;
	}

	@Override
	public List<Match> listmatchesbyteam(String team1, String team2) {
		List<Match> list = repository.findByTeam1ContainingIgnoreCaseOrTeam2ContainingIgnoreCase(team1, team2);
		return list;
	}

	@Override
	public Match findbymatchid(long matchId) {
		Match match = repository.findById(matchId).get();
		return match;
	}

	@Override
	public List<Match> listmatchesbytournament(String tournament) {
		List<Match> list = repository.findByTournamentContainingIgnoreCase(tournament);
		return list;

	}

}
