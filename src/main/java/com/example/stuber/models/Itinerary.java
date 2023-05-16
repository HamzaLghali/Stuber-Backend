package com.example.stuber.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Itinerary {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	private Adress start;
	@ManyToOne
	private Adress end;
	private boolean isArrived;
	LocalDate starttime;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "itinerary_student",
			joinColumns = @JoinColumn(name = "itinerary_id"),
			inverseJoinColumns = @JoinColumn(name = "student_id"))
	List<Student> students;
	@ManyToOne
	Bus bus;
	@ManyToOne
	Driver driver;

	public Itinerary(int id, Adress start, Adress end, LocalDate starttime, List<Student> students, Bus bus, Driver driver,boolean isArrived) {
		this.id = id;
		this.start = start;
		this.end = end;
		this.isArrived = isArrived;
		this.starttime = starttime;
		this.students = students;
		this.bus = bus;
		this.driver = driver;
	}
}
