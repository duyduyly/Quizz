package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Quiz;
import com.entity.QuizTopic;

public interface QuizRepository extends JpaRepository<Quiz, Integer> {

	List<Quiz> findByQuizTopic(QuizTopic id);
}
