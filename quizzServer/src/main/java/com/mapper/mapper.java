package com.mapper;

import java.util.HashSet;
import java.util.Set;

import com.ato.AnswerModel;
import com.ato.QuizModel;
import com.entity.Answers;
import com.entity.Quiz;

public class mapper {

	public static Quiz quizModelMapper(QuizModel quizModel) {
		Quiz quiz = new Quiz();

		quiz.setId(quizModel.getId());
		quiz.setQuestion(quizModel.getQuestion());
//		quiz.setQuizTopic(quizModel.getQuizTopic());
		quiz.setRightAnswerId(quizModel.getRightAnswerId());

		Set<Answers> answerSet = new HashSet<Answers>();
		for (AnswerModel answerModel : quizModel.getAnswerModel()) {
			Answers answers = AnswerModelMapper(answerModel);
			answerSet.add(answers);
		}

		quiz.setAnswers(answerSet);

		return quiz;
	}

	public static QuizModel quizMapper(Quiz quiz) {
		QuizModel quizModel = new QuizModel();

		quizModel.setId(quiz.getId());
		quizModel.setQuestion(quiz.getQuestion());
//		quizModel.setQuizTopic(quiz.getQuizTopic());
		quizModel.setRightAnswerId(quiz.getRightAnswerId());

		Set<AnswerModel> answerModelSet = new HashSet<AnswerModel>();
		for (Answers answers : quiz.getAnswers()) {
			AnswerModel answerModel = AnswerMapper(answers);
			answerModelSet.add(answerModel);
		}

		quizModel.setAnswerModel(answerModelSet);

		return quizModel;
	}

	public static AnswerModel AnswerMapper(Answers answers) {
		AnswerModel answerModel = new AnswerModel();

		answerModel.setId(answers.getId());
		answerModel.setAnswer(answers.getAnswer());

		return answerModel;
	}

	public static Answers AnswerModelMapper(AnswerModel answerModel) {
		Answers answers = new Answers();

		answers.setId(answerModel.getId());
		answers.setAnswer(answerModel.getAnswer());

		return answers;
	}
}
