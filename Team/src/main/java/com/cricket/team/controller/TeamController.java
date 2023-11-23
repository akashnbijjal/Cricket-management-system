package com.cricket.team.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cricket.team.model.Team;
import com.cricket.team.service.TeamServiceImpl;

@RestController
@RequestMapping("team")
public class TeamController {

	@Autowired
	private TeamServiceImpl service;

	@PostMapping("addteam")
	public ResponseEntity<Team> addteam(@RequestBody Team team) {
		Team team2 = service.addteam(team);
		return new ResponseEntity<Team>(team2, HttpStatus.CREATED);
	}

	@GetMapping("/getteam/{teamname}")
	public ResponseEntity<Team> getteamdetails(@PathVariable("teamname") String teamname) {
		Team list = service.getTeambyname(teamname);
		return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
	}

	@PutMapping("updateteam")
	public ResponseEntity<Team> updateteam(@RequestBody Team team) {
		Team team1 = service.updateteam(team);
		return new ResponseEntity<Team>(team1, HttpStatus.ACCEPTED);
	}

	@GetMapping("getallteams")
	public ResponseEntity<List<Team>> getallteams()
	{
		List<Team> team=service.getallteams();

		return new ResponseEntity<List<Team>>(team, HttpStatus.ACCEPTED);
	}
}
