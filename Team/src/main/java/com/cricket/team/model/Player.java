package com.cricket.team.model;

import java.util.Date;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player {
	@Id
	private Long playerId;
	private String firstName;
	private String lastName;
	private String nationality;
	private String playingPosition;
	private String playerRole;
}
