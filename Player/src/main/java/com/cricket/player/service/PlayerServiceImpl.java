package com.cricket.player.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cricket.player.model.Player;
import com.cricket.player.repository.playerrepository;

@Service
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private playerrepository repository;

	@Override
	public Player addplayer(Player player) {

		return repository.save(player);
	}

	@Override
	public List<Player> allplayers() {
		return repository.findAll();
	}

	@Override
	public Player getplayerbyid(long playerId) {
		Player player = repository.findById(playerId).get();
		return player;
	}

	@Override
	public List<Player> searchPlayersByName(String name) {
	    return repository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(name, name);
	}

	@Override
	public List<Player> searchbynationality(String nationality) {
		List<Player> list=repository.findByNationalityContainingIgnoreCase(nationality);
		return list;
	}
	@Override
	public List<Player> getTopBattingPerformers() {
	    return repository.findTopByOrderByPlayerstatistics_BattingAverageDesc();
	}

	@Override
	public Player updateplayer(Player player) {
		Player player2=repository.save(player);
		return player2;
	}

}
