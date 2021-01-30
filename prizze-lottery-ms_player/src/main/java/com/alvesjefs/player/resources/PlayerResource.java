package com.alvesjefs.player.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.alvesjefs.player.dto.PlayerDTO;
import com.alvesjefs.player.services.PlayerService;

@RestController
@RequestMapping(value = "api/player")
public class PlayerResource {

	@Autowired
	private PlayerService playerService;

	@PostMapping(value = "/players")
	public ResponseEntity<PlayerDTO> randomNumbers(@RequestParam String email) {
		PlayerDTO randomNumber = playerService.savePlayerAndShowNumbers(email);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(randomNumber.getId())
				.toUri();
		return ResponseEntity.created(uri).body(randomNumber);
	}

	@GetMapping(value = "/searchPlayer")
	public ResponseEntity<Page<PlayerDTO>> findPlayer(
			@RequestParam String email,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "3") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "DESC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "date") String orderBy) {
		Page<PlayerDTO> findPage = playerService.findPlay(email, page, linesPerPage, direction, orderBy);
		return ResponseEntity.ok().body(findPage);
	}
}
