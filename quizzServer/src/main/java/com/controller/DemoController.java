package com.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.QuizzServerApplication;
import com.ato.QuizModel;
import com.entity.Quiz;
import com.entity.QuizTopic;
import com.mapper.mapper;
import com.repository.AccountRepository;
import com.repository.AnswersRepository;
import com.repository.QuizRepository;
import com.repository.QuizTopicRepository;
import com.repository.ViewRepository;

@RestController
public class DemoController {

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	AnswersRepository answersRepository;

	@Autowired
	QuizTopicRepository quizTopicRepository;

	@Autowired
	QuizRepository quizRepository;

	@Autowired
	ViewRepository viewRepository;

	@GetMapping("/")
	public List<QuizModel> demo() {
		// select quiz by Topic id
		Optional<QuizTopic> quizTopic = quizTopicRepository.findById(1);
		List<Quiz> quizList = quizRepository.findByQuizTopic(quizTopic.get());
	

		List<QuizModel> quizModels = new ArrayList<QuizModel>();
		for (Quiz quiz : quizList) {
			QuizModel quizModel = mapper.quizMapper(quiz);
			quizModels.add(quizModel);
		}
		return quizModels;
	}
}
