package com.cricket.player.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cricket.player.model.Player;

public interface playerrepository extends MongoRepository<Player, Long> {

	List<Player> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String name, String name2);

	List<Player> findByNationalityContainingIgnoreCase(String nationality);

	List<Player> findTopByOrderByPlayerstatistics_BattingAverageDesc();

}
