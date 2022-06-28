package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Quiz;
import com.entity.QuizTopic;

public interface QuizTopicRepository extends JpaRepository<QuizTopic, Integer> {

}
