package com.kanishk.SpringJDBCEx.service;

import com.kanishk.SpringJDBCEx.model.Student;
import com.kanishk.SpringJDBCEx.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {


    private StudentRepo repo;

    public StudentRepo getS() {
        return repo;
    }

    @Autowired
    public void setS(StudentRepo repo) {
        this.repo = repo;
    }

    public void addStudent(Student obj){
        repo.save(obj);
    }

    public List<Student> getAllStudents(){
        return repo.findAll();
    }
}
