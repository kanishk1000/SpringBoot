package com.kanishk.question_service.controller;

import com.kanishk.question_service.model.Question;
import com.kanishk.question_service.model.QuestionWrapper;
import com.kanishk.question_service.model.Response;
import com.kanishk.question_service.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("getAllQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){

        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category){

        return questionService.getQuestionByCategory(category);
    }

    @PostMapping("addOrUpdate")
    public ResponseEntity<String> addOrUpdateQuestion(@RequestBody Question question){
        return questionService.addOrUpdateQuestion(question);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable int id){
        return questionService.deleteQuestion(id);
    }

    @GetMapping("generate")
    public ResponseEntity<List<Integer>> getQuestionForQuiz(@RequestParam String categoryName, @RequestParam Integer numOfQuestion){
        return questionService.getQuestionForQuiz(categoryName, numOfQuestion);
    }

    @PostMapping("getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionFromID(@RequestBody List<Integer> questionIDs){
        return questionService.getQuestionFromID(questionIDs);
    }

    @PostMapping("getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses){
        return questionService.getScore(responses);
    }

}
