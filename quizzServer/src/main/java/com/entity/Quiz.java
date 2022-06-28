package com.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "QUIZ")
public class Quiz extends baseEntity {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String question;
	
	private int rightAnswerId;
	
	
	//Many TO One with QuizTopic
	@ManyToOne
	@JoinColumn(name = "QUIZTOPIC_ID",nullable = false)
	private QuizTopic quizTopic;
	
	//one To Many With Answers
	@OneToMany(mappedBy = "quiz" ,cascade = {CascadeType.PERSIST})
	private Set<Answers> answers;
	
	
}
