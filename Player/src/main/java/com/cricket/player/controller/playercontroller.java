package com.cricket.player.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cricket.player.model.Player;
import com.cricket.player.service.PlayerServiceImpl;

@RestController
@RequestMapping("player")
public class playercontroller {

	@Autowired
	private PlayerServiceImpl service;

	@PostMapping("addplayer")
	public ResponseEntity<Player> addplayer(@RequestBody Player player) {
		Player player2 = service.addplayer(player);
		return new ResponseEntity<Player>(player2, HttpStatus.CREATED);
	}

	@GetMapping("allplayers")
	public ResponseEntity<List<Player>> viewplayers() {
		List<Player> list = service.allplayers();
		return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
	}

	@GetMapping("/id/{playerId}")
	public ResponseEntity<Player> playerbyid(@PathVariable("playerId") long playerId) {
		Player player = service.getplayerbyid(playerId);
		return new ResponseEntity<Player>(player, HttpStatus.ACCEPTED);
	}

	@GetMapping("/name/{name}")
	public ResponseEntity<List<Player>> playerbyname(@PathVariable("name") String name) {
		List<Player> player = service.searchPlayersByName(name);
		return new ResponseEntity<>(player, HttpStatus.ACCEPTED);
	}

	@GetMapping("nationality/{nationality}")
	public ResponseEntity<List<Player>> playerbynationality(@PathVariable("nationality") String nationality) {
		List<Player> list = service.searchbynationality(nationality);
		return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
	}

	@GetMapping("toporderbatsman")
	public ResponseEntity<List<Player>> getTopBattingPerformers() {
		List<Player> list = service.getTopBattingPerformers();
		return new ResponseEntity<List<Player>>(list, HttpStatus.ACCEPTED);
	}
	
	@PutMapping("updateplayer")
	public ResponseEntity<Player> updateplayer(@RequestBody Player player)
	{
		Player player2=service.updateplayer(player);
		return new ResponseEntity<Player>(player2, HttpStatus.CREATED);
	}
}
