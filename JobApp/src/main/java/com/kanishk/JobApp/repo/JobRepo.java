package com.kanishk.JobApp.repo;

import com.kanishk.JobApp.model.JobPost;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class JobRepo {

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

    public List<JobPost> getAllJobs(){
        return jobs;
    }

    public void addJob(JobPost job){
        jobs.add(job);
//        System.out.println(job.toString());
    }
}
