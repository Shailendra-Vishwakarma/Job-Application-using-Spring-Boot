package com.cybersploit.JobApp.Job;

import java.util.List;

public interface JobService {
    List<Job> findAll();

    void createJob(Job job);

    Job getJobById(Long jobId);

    boolean deleteById(Long jobId);

    boolean updateJob(Long jobId, Job updatedJob);
}