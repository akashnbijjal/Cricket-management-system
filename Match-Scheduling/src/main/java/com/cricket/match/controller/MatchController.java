package com.cricket.match.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cricket.match.model.Match;
import com.cricket.match.service.MatchServiceImpl;

@RestController
@RequestMapping("match")
public class MatchController {

	@Autowired
	private MatchServiceImpl service;

	@PostMapping("creatematch")
	public ResponseEntity<Match> creatematch(@RequestBody Match match) {
		Match match2 = service.createMatch(match);
		return new ResponseEntity<Match>(match2, HttpStatus.CREATED);
	}

	@GetMapping("matches/{teamname}")
	public ResponseEntity<List<Match>> getmatchbyname(@PathVariable("teamname") String teamname) {
		List<Match> match2 = service.listmatchesbyteam(teamname, teamname);
		return new ResponseEntity<>(match2, HttpStatus.ACCEPTED);
	}

	@GetMapping("allmatches")
	public ResponseEntity<List<Match>> getallmatches() {
		List<Match> match2 = service.allmatches();
		return new ResponseEntity<>(match2, HttpStatus.ACCEPTED);
	}

	@GetMapping("{tournament}")
	public ResponseEntity<List<Match>> getmatchesbytournament(@PathVariable("tournament") String tournament) {
		List<Match> match = service.listmatchesbytournament(tournament);
		return new ResponseEntity<List<Match>>(match, HttpStatus.ACCEPTED);
	}
}
