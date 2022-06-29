package com.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizModel {

	private int id;

	private String question;

	private int rightAnswerId;
	
	private Set<AnswerModel> answerModel;
	
//	private QuizTopic quizTopic;
	
}
