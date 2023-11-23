package com.cricket.team.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Team")
public class Team {

	@Id
	private long teamId;

	private String captain;

	private String teamname;

	
	private List<Long> playerId;
	
	@Transient
	private List<Player> players = new ArrayList<>();

	private String homeground;
	
	private String coach;

}
