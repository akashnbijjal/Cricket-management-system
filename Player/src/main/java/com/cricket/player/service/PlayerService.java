package com.cricket.player.service;

import java.util.List;

import com.cricket.player.model.Player;

public interface PlayerService {

	Player addplayer(Player player);
	
	List<Player> allplayers();
	
	Player getplayerbyid(long playerId);
	
	List<Player> searchPlayersByName(String name);
	
	List<Player> searchbynationality(String nationality);
	
	List<Player> getTopBattingPerformers();
	
	Player updateplayer(Player player);
	
	
}
