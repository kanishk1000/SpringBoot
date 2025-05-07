package com.kanishk.spring_boot_rest.service;

import com.kanishk.spring_boot_rest.model.JobPost;
import com.kanishk.spring_boot_rest.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepo repo;

    public void addJob(JobPost jobPost){
        repo.save(jobPost);
    }

    public List<JobPost> getAllJobs(){
        return repo.findAll();
    }

    public JobPost getJob(int postId) {
        return repo.findById(postId).orElse(new JobPost());
    }

    public void updateJob(JobPost jobPost) {
        repo.save(jobPost);
    }

    public void deleteJob(int postId) {
        repo.deleteById(postId);
    }

    public void load() {

        List<JobPost> jobs = new ArrayList<>(Arrays.asList(
                new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
                        Arrays.asList("Core Java", "J2EE", "Spring Boot", "Hibernate")),
                new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React",
                        3, Arrays.asList("HTML", "CSS", "JavaScript", "React")),
                new JobPost(3, "Mobile App Developer", "Experience in mobile app development for iOS and Android",
                        3, Arrays.asList("iOS Development", "Android Development", "Mobile App")),
                new JobPost(4, "DevOps Engineer", "Implement and manage continuous integration and delivery pipelines",
                        4, Arrays.asList("DevOps", "CI/CD", "Docker", "Kubernetes"))
        ));

        repo.saveAll(jobs);
    }

    public List<JobPost> search(String keyword) {
        return repo.findByPostProfileContainingOrPostDescContaining(keyword, keyword);
    }
}

