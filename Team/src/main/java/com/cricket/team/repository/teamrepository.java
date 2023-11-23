package com.cricket.team.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.cricket.team.model.Team;

public interface teamrepository extends MongoRepository<Team, Long> {
	Team findByTeamname(String teamname);
}
