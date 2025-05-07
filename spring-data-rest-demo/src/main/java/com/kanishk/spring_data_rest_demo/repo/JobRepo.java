package com.kanishk.spring_data_rest_demo.repo;

import com.kanishk.spring_data_rest_demo.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer> {

//    List<JobPost> findByPostProfileContainingOrPostDescContaining(String postProf, String postDesc);
}

