package com.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ACCOUNT")
public class Account extends baseEntity {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String username;
	
	private String password;
	
	private String name;
	
	
	// one to many with QuizTopic
	@OneToMany(mappedBy = "account")
	private Set<QuizTopic> quizTopics;
	
	
	//one to many with views
	@OneToMany(mappedBy = "account")
	private Set<View> views;
}
