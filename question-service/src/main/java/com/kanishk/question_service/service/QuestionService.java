package com.kanishk.question_service.service;

import com.kanishk.question_service.model.Question;
import com.kanishk.question_service.model.QuestionWrapper;
import com.kanishk.question_service.model.Response;
import com.kanishk.question_service.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    public ResponseEntity<List<Integer>> getQuestionForQuiz(String categoryName, Integer numOfQuestion) {
         return new ResponseEntity<>(repo.findRandomQuestionsByCategory(categoryName, numOfQuestion), HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuestionFromID(List<Integer> questionIDs) {

        List<QuestionWrapper> questions = new ArrayList<>();

        for(Integer id : questionIDs){
            Question q = repo.findById(id).get();
            questions.add( new QuestionWrapper
                    (q.getId(), q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4()));
        }

        return new ResponseEntity<>(questions, HttpStatus.OK);

    }

    public ResponseEntity<Integer> getScore(List<Response> responses) {

        Integer score = 0;

        for(Response response : responses){

            Question q = repo.findById(response.getId()).get();

            if( response.getResponse().equals(q.getRightAnswer()) ){
                score++;
            }
        }

        return new ResponseEntity<>(score, HttpStatus.OK);
    }
}
