package com.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Setter@Getter
@Entity
@Table(name = "ANSWERS")
public class Answers extends baseEntity {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private String answer;
	
	
	//Many To one with Quiz
	@ManyToOne
	@JoinColumn(name = "QUIZ_ID")
	private Quiz quiz;
}
