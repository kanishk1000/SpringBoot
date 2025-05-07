package com.kanishk.quiz_service.service;


import com.kanishk.quiz_service.feign.QuizInterface;
import com.kanishk.quiz_service.model.QuestionWrapper;
import com.kanishk.quiz_service.model.Quiz;
import com.kanishk.quiz_service.model.Response;
import com.kanishk.quiz_service.repo.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {

    @Autowired
    QuizRepo quizRepo;

    @Autowired
    QuizInterface quizInterface;

    public ResponseEntity<String> createQuiz(String category, int noOfQuestions, String title) {

          List<Integer> questionIds = quizInterface.getQuestionForQuiz(category, noOfQuestions).getBody();

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questionIds);
        quizRepo.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {

        Quiz quiz = quizRepo.findById(id).get();
        List<Integer> questionsIDsFromDB = quiz.getQuestions();
        ResponseEntity<List<QuestionWrapper>> questionForUser = quizInterface.getQuestionFromID(questionsIDsFromDB);

        return questionForUser;
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {

        ResponseEntity<Integer> score = quizInterface.getScore(responses);

        return score;
    }
}
