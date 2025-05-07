package com.kanishk.quizApp.service;

import com.kanishk.quizApp.model.Question;
import com.kanishk.quizApp.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepo repo;

    public ResponseEntity<List<Question>> getAllQuestions() {

        try {
            return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }


    public ResponseEntity<String> addOrUpdateQuestion(Question question) {
        repo.save(question);
        return new ResponseEntity<>("Successful", HttpStatus.CREATED);
    }

    public ResponseEntity<String> deleteQuestion(int id) {
        repo.deleteById(id);
        return new ResponseEntity<>("Successfully Deleted", HttpStatus.OK);
    }

    public ResponseEntity<List<Question>> getQuestionByCategory(String category) {
        return new ResponseEntity<>( repo.findByCategory(category), HttpStatus.OK );
    }

}
