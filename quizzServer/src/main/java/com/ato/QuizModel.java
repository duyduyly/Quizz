package com.ato;

import java.util.Set;

import com.entity.Answers;
import com.entity.QuizTopic;

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
