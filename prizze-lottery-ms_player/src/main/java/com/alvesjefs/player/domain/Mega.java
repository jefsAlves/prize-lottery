package com.alvesjefs.player.domain;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "TB_MEGA")
public class Mega implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ElementCollection
	@CollectionTable(name = "TB_NUMBERS")
	private Set<Integer> numbers;

	public Mega() {
	}

	public Mega(Long id, Set<Integer> numbers) {
		this.id = id;
		this.numbers = numbers;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JoinColumn(unique = true)
	public Set<Integer> getNumbers() {
		return numbers;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numbers);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mega other = (Mega) obj;
		return Objects.equals(numbers, other.numbers);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Mega [numbers=");
		builder.append(numbers);
		builder.append("]");
		return builder.toString();
	}

}
