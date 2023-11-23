package com.cricket.player.model;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Player")
public class Player {

	@Id
	private long playerId;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private String nationality;
	private String playingPosition;
	private String playerRole;
	private PlayerStatistics playerstatistics;

}
