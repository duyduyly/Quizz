package com.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.AnswerModel;
import com.dto.QuizModel;
import com.entity.Answers;
import com.entity.Quiz;
import com.entity.QuizTopic;
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

	@Autowired
	ModelMapper modelMapper;

	@GetMapping("/")
	public List<QuizModel> demo() {
		// select quiz by Topic id
		Optional<QuizTopic> quizTopic = quizTopicRepository.findById(1);
		List<Quiz> quizList = quizRepository.findByQuizTopic(quizTopic.get());

		List<QuizModel> quizModels = new ArrayList<QuizModel>();
		for (Quiz quiz : quizList) {
			QuizModel quizModel = modelMapper.map(quiz, QuizModel.class);
			
			Set<Answers> answers = quiz.getAnswers();
			Set<AnswerModel> answerModel = new HashSet<AnswerModel>();
			
			for (Answers Answers : answers) {
				AnswerModel answerModel1 = modelMapper.map(Answers, AnswerModel.class);
				answerModel.add(answerModel1);
			}
			
			quizModel.setAnswerModel(answerModel);
			quizModels.add(quizModel);
		}
		return quizModels;
	}

}
