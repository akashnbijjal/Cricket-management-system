package com.cricket.player.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerStatistics {
	
	private int matchesPlayed;
    private int runsScored;
    private int wicketsTaken;
    private double battingAverage;
    private double bowlingAverage;

}
