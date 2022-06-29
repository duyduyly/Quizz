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
		Quiz quiz1 =  new Quiz(0,"SQL là Gì?", 2, quizTopic1, null);
		Answers answers01 = new Answers(0,"Select Query Language", quiz1);
		Answers answers02 = new Answers(0,"So  Lang", quiz1);
		Answers answers03 = new Answers(0,"sd", quiz1);
		Answers answers04 = new Answers(0,"Asdasd", quiz1);
	

		
		
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
		
		
		
		QuizTopic quizTopic1_02 = quizTopicRepository.findById(1).get();
		QuizTopic quizTopic1_03 = quizTopicRepository.findById(1).get();
		Quiz quiz2 =  new Quiz(0,"DDL là Gì?", 5, quizTopic1_02, null);
		Answers answers05 = new Answers(0,"Data define language", quiz2);
		Answers answers06 = new Answers(0,"Data define", quiz2);
		Answers answers08 = new Answers(0,"data data language", quiz2);
		Answers answers09 = new Answers(0,"Data data Luna", quiz2);
		
		Quiz quiz3 =  new Quiz(0,"Create TABLE là Gì?", 9, quizTopic1_03, null);
		Answers answers010 = new Answers(0,"Create Table", quiz3);
		Answers answers011 = new Answers(0,"Crate DataBase", quiz3);
		Answers answers012 = new Answers(0,"Select Data", quiz3);
		Answers answers013 = new Answers(0,"Join Data", quiz3);
		
		Set<Answers> answersSet2 = new HashSet<Answers>();
		Set<Answers> answersSet3 = new HashSet<Answers>();
		
		answersSet2.add(answers05);
		answersSet2.add(answers06);
		answersSet2.add(answers08);
		answersSet2.add(answers09);
		answersSet3.add(answers010);
		answersSet3.add(answers011);
		answersSet3.add(answers012);
		answersSet3.add(answers013);
		
		quiz2.setAnswers(answersSet2);
		quiz3.setAnswers(answersSet3);
		
		quizRepository.save(quiz2);
		quizRepository.save(quiz3);
		
//		Account account2 = accountRepository.findById(1).get();
//		QuizTopic quizTopic2 = new QuizTopic(0,"SQL", account2, null);
//		Quiz quiz2 =  new Quiz(0,"Java Laf gi", 2, quizTopic2, null);
//		Answers answers05 = new Answers(0,"01", quiz2);
//		Answers answers06 = new Answers(0,"02", quiz2);
//		Answers answers07 = new Answers(0,"03", quiz2);
//		Answers answers08 = new Answers(0,"04", quiz2);
//
//		
//		
//		Set<QuizTopic> quizTopicSet2 = new HashSet<QuizTopic>();
//		//set answer
//		Set<Quiz> quizSet2 = new HashSet<Quiz>();
//		Set<Answers> answersSet2 = new HashSet<Answers>();
//		
//		answersSet2.add(answers05);
//		answersSet2.add(answers06);
//		answersSet2.add(answers07);
//		answersSet2.add(answers08);
//		quizSet2.add(quiz2);
//		quizTopicSet2.add(quizTopic2);
//		
//		
//		System.err.println(answersSet2.size());
//		quiz2.setAnswers(answersSet2);
//		quizTopic2.setQuizs(quizSet2);
////		acount1.setQuizTopics(quizTopicSet2);
//		
//		quizTopicRepository.save(quizTopic2);
		
		
	}

}
