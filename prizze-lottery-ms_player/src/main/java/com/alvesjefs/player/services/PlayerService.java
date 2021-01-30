package com.alvesjefs.player.services;

import java.time.Instant;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.alvesjefs.player.domain.Mega;
import com.alvesjefs.player.domain.Player;
import com.alvesjefs.player.dto.PlayerDTO;
import com.alvesjefs.player.repositories.PlayerRepository;
import com.alvesjefs.player.services.exceptions.EmailExistsException;
import com.alvesjefs.player.services.exceptions.EmailNotFoundException;

@Service
public class PlayerService {

	@Autowired
	private PlayerRepository playerRepository;

	@Transactional
	public PlayerDTO savePlayerAndShowNumbers(String email) {
		Player findEmail = playerRepository.findByEmail(email);
		if (findEmail != null) {
			throw new EmailExistsException("This email already exists, please recover your password!");
		}

		Player player = new Player();
		player.setEmail(email);
		player.setDate(Instant.now());
		player.getMega().add(new Mega(null, result()));
		player = playerRepository.save(player);
		return new PlayerDTO(player);
	}

	private Set<Integer> result() {
		int numero;
		int[] num = new int[6];
		Random r = new Random();
		Set<Integer> result = new HashSet<>();

		for (int i = 0; i < num.length; i++) {
			numero = r.nextInt(60) + 1;
			for (int j = 0; j < num.length; j++) {
				if (numero == num[j] && j != i) {
					numero = r.nextInt(60) + 1;
				} else {
					num[i] = numero;
				}
			}
		}
		for (int i = 0; i < num.length; i++) {
			result.add(num[i]);
		}
		return result;
	}

	public Page<PlayerDTO> findPlay(String email, Integer page, Integer linesPerPage, String direction,
			String orderBy) {
		Player findEmail = playerRepository.findByEmail(email);
		if (findEmail == null) {
			throw new EmailNotFoundException("Email not found!");
		}

		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		Page<Player> findPage = playerRepository.findAll(pageRequest);
		return findPage.map(x -> new PlayerDTO(x));
	}
}
