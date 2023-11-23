package com.cricket.team.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.cricket.team.model.Player;
import com.cricket.team.model.Team;
import com.cricket.team.repository.teamrepository;

@Service
public class TeamServiceImpl implements TeamService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private teamrepository repository;

	@Override
	public Team addteam(Team team) {
		return repository.save(team);
	}

	@Override
	public Team getTeambyname(String teamname) {
		Team team = repository.findByTeamname(teamname);

		List<Player> players = new ArrayList<>();
		for (Long playerId : team.getPlayerId()) {
			Player player1 = restTemplate.getForObject("http://localhost:8081/player/id/"+playerId,
					Player.class);
			players.add(player1);
		}

		team.setPlayers(players);
		return team;
	}

	@Override
	public Team updateteam(Team team) {
		return repository.save(team);
	}

	@Override
	public List<Team> getallteams() {
		List<Team> list = repository.findAll();
		for (Team team : list) {
			List<Player> players = new ArrayList<>();
			for (Long playerId : team.getPlayerId()) {
				Player player = restTemplate.getForObject("http://localhost:8081/player/id/" + playerId, Player.class);
				players.add(player);
			}
			team.setPlayers(players);
		}
		return list;
	}

}
