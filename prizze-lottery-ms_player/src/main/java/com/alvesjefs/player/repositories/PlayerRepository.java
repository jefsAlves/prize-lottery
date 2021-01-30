package com.alvesjefs.player.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alvesjefs.player.domain.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {

	Player findByEmail(String email);
}
