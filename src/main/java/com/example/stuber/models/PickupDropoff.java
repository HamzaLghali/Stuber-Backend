package com.example.stuber.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class PickupDropoff {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String type;
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REFRESH, CascadeType.DETACH})
	@JoinColumn(name = "student_id")
	private Student student;

	private LocalDateTime time;
	@ManyToOne
	private Adress location;

	public PickupDropoff(int id, String type, Student student, Adress location) {
		this.id = id;
		this.type = type;
		this.student = student;
		this.time = LocalDateTime.now();
		this.location = location;
	}
}
