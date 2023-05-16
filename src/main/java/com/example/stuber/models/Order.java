package com.example.stuber.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String description;
	@ManyToOne
	private Parent parent;
	@ManyToOne
	private Student student;
	@ManyToOne
	private Adress start;

	private boolean isAccepted;
	private boolean isProcessed;
}
