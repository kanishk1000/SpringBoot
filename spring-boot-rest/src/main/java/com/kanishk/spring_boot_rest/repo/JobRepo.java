package com.kanishk.spring_boot_rest.repo;

import com.kanishk.spring_boot_rest.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer> {

    List<JobPost> findByPostProfileContainingOrPostDescContaining(String postProf, String postDesc);
}

//List<JobPost> jobs = new ArrayList<>(Arrays.asList(
//        new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
//                Arrays.asList("Core Java", "J2EE", "Spring Boot", "Hibernate")),
//        new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React",
//                3, Arrays.asList("HTML", "CSS", "JavaScript", "React")),
//        new JobPost(3, "Mobile App Developer", "Experience in mobile app development for iOS and Android",
//                3, Arrays.asList("iOS Development", "Android Development", "Mobile App")),
//        new JobPost(4, "DevOps Engineer", "Implement and manage continuous integration and delivery pipelines",
//                4, Arrays.asList("DevOps", "CI/CD", "Docker", "Kubernetes"))
//));
//
//public List<JobPost> getAllJobs(){
//    return jobs;
//}
//
//public void addJob(JobPost job){
//    jobs.add(job);
//}
//
//public JobPost getJob(int postId) {
//
//    for(JobPost job : jobs){
//        if(job.getPostId() == postId){
//            return job;
//        }
//    }
//
//    return null;
//}
//
//public void updateJob(JobPost jobPost) {
//
//    for(JobPost job : jobs){
//        if(job.getPostId() == jobPost.getPostId()){
//            job.setPostDesc(jobPost.getPostDesc());
//            job.setPostProfile(jobPost.getPostProfile());
//            job.setPostTechStack(jobPost.getPostTechStack());
//            job.setReqExperience(jobPost.getReqExperience());
//        }
//    }
//}
//
//public void deleteJob(int postId) {
//
//    for(JobPost job : jobs){
//        if(job.getPostId() == postId){
//            jobs.remove(job);
//        }
//    }
//}
