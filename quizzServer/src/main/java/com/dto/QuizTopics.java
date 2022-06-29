package com.dto;

import java.util.Set;

import com.entity.Quiz;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizTopics {

	private int id;
	
	private String name;
	
	private Set<Quiz> quizs;
	
}
