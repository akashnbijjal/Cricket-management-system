package com.cricket.match.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Match")
public class Match {

	@Id
	private long matchId;

	private String tournament;
	private String team1;

	private String team2;

	private String venue;
	
	private String Result;

	private LocalDateTime matchDateTime;
}
