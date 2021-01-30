package com.alvesjefs.player.dto;

import java.io.Serializable;
import java.util.Set;

import com.alvesjefs.player.domain.Mega;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class MegaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	private Long id;
	private Set<Integer> numbers;

	public MegaDTO() {
	}

	public MegaDTO(Long id, Set<Integer> numbers) {
		this.id = id;
		this.numbers = numbers;
	}

	public MegaDTO(Mega mega) {
		id = mega.getId();
		numbers = mega.getNumbers();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Integer> getNumbers() {
		return numbers;
	}

	public void setNumbers(Set<Integer> numbers) {
		this.numbers = numbers;
	}

}
