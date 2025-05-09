package com.kanishk.question_service.repo;

import com.kanishk.question_service.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Integer> {


    List<Question> findByCategory(String category);

    @Query(value = "SELECT q.id FROM question q where q.category=:category ORDER BY RANDOM() LIMIT :noOfQuestion", nativeQuery = true)
    List<Integer> findRandomQuestionsByCategory(String category, int noOfQuestion);
}
