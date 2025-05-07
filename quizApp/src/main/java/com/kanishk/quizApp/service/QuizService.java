package com.kanishk.quizApp.service;

import com.kanishk.quizApp.model.Question;
import com.kanishk.quizApp.model.QuestionWrapper;
import com.kanishk.quizApp.model.Quiz;
import com.kanishk.quizApp.model.Response;
import com.kanishk.quizApp.repo.QuestionRepo;
import com.kanishk.quizApp.repo.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizRepo quizRepo;

    @Autowired
    QuestionRepo questionRepo;

    public ResponseEntity<String> createQuiz(String category, int noOfQuestions, String title) {

        List<Question> questions = questionRepo.findRandomQuestionsByCategory(category, noOfQuestions);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);

        quizRepo.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {

        Optional<Quiz> optionalQuiz = quizRepo.findById(id);
        List<Question> questionsFromDB = optionalQuiz.get().getQuestions();
        List<QuestionWrapper> questionForUser = new ArrayList<>();

        for(Question q : questionsFromDB){

            questionForUser.add(new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4()));
        }

        return new ResponseEntity<>(questionForUser, HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {

        Quiz quiz = quizRepo.findById(id).get();
        List<Question> quizQuestions = quiz.getQuestions();
        List<String> rightAnswers = new ArrayList<>();

        Integer score = 0;

        for(int i=0; i<quizQuestions.size(); i++){

            if(quizQuestions.get(i).getRightAnswer().equals(responses.get(i).getResponse())){
                score++;
            }
        }

        return new ResponseEntity<>(score, HttpStatus.OK);
    }
}
