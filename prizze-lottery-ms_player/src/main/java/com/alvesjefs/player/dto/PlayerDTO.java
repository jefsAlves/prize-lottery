package com.alvesjefs.player.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.alvesjefs.player.domain.Player;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class PlayerDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String email;
	private Instant date;

	private Set<MegaDTO> mega = new HashSet<>();

	public PlayerDTO() {
	}

	public PlayerDTO(Long id, String email, Instant date) {
		this.id = id;
		this.email = email;
		this.date = date;
	}

	public PlayerDTO(Player player) {
		id = player.getId();
		email = player.getEmail();
		date = player.getDate();
		mega = player.getMega().stream().map(x -> new MegaDTO(x)).collect(Collectors.toSet());
	}

	@JsonIgnore
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JsonIgnore
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@JsonIgnore
	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public Set<MegaDTO> getMega() {
		return mega;
	}

}
