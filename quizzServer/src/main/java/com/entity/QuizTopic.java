package com.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "QUIZTOPICS")
public class QuizTopic extends baseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;

	// Many To one with Account
	@ManyToOne
	@JoinColumn(name = "ACCOUNT_ID", nullable = false)
	private Account account;

	// One To many with quizz
	@OneToMany(mappedBy = "quizTopic")
	private Set<Quiz> quizs;

}
