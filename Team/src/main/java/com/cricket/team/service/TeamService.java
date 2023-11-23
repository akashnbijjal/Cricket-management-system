package com.cricket.team.service;

import java.util.List;

import com.cricket.team.model.Team;

public interface TeamService {

	Team addteam(Team team);

	Team getTeambyname(String teamname);

	Team updateteam(Team team);
	
	List<Team> getallteams();
}
