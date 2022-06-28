package com;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.entity.Account;
import com.entity.Answers;
import com.entity.Quiz;
import com.entity.QuizTopic;
import com.repository.AccountRepository;
import com.repository.AnswersRepository;
import com.repository.QuizRepository;
import com.repository.QuizTopicRepository;
import com.repository.ViewRepository;

@SpringBootApplication
public class QuizzServerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(QuizzServerApplication.class, args);
	}

	
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
	
	@Override
	public void run(String... args) throws Exception {
		
		
		//set view
		//set QuizTopic
		Account acount1 = new Account(0,"1", "user01", "Author01", null, null);
		
		QuizTopic quizTopic1 = new QuizTopic(0,"SQL", acount1, null);
		Quiz quiz1 =  new Quiz(0,"SQL là Gì", 2, quizTopic1, null);
		Answers answers01 = new Answers(0,"01", quiz1);
		Answers answers02 = new Answers(0,"02", quiz1);
		Answers answers03 = new Answers(0,"03", quiz1);
		Answers answers04 = new Answers(0,"04", quiz1);

		
		
		Set<QuizTopic> quizTopicSet = new HashSet<QuizTopic>();
		//set answer
		Set<Quiz> quizSet = new HashSet<Quiz>();
		Set<Answers> answersSet = new HashSet<Answers>();
		
		answersSet.add(answers01);
		answersSet.add(answers02);
		answersSet.add(answers03);
		answersSet.add(answers04);
		quizSet.add(quiz1);
		quizTopicSet.add(quizTopic1);
		
		
		System.err.println(answersSet.size());
		quiz1.setAnswers(answersSet);
		quizTopic1.setQuizs(quizSet);
		acount1.setQuizTopics(quizTopicSet);
		
		accountRepository.save(acount1);
		
		
		
		
	}

}
