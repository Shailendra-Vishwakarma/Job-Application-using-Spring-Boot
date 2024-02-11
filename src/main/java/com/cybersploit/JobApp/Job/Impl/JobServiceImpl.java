package com.cybersploit.JobApp.Job.Impl;

import com.cybersploit.JobApp.Job.Job;
import com.cybersploit.JobApp.Job.JobService;
import com.cybersploit.JobApp.Job.Repo.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {
     //private List<Job> jobList=new ArrayList<>();
        private Long jobId=1L;
    JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }
    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
        job.setId(jobId++);
        jobRepository.save(job);
    }

    @Override
    public Job getJobById(Long jobId) {
         return jobRepository.findById(jobId).orElse(null);
}

    @Override
    public boolean deleteById(Long jobId){
        try{
            jobRepository.deleteById(jobId);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean updateJob(Long jobId, Job updatedJob) {

        Optional<Job> jobOptional=jobRepository.findById(jobId);
             if(jobOptional.isPresent()) {
                 Job job = jobOptional.get();
                 job.setTitle(updatedJob.getTitle());
                 job.setDescription(updatedJob.getDescription());
                 job.setMinSalary(updatedJob.getMinSalary());
                 job.setMaxSalary(updatedJob.getMaxSalary());
                 job.setLocation(updatedJob.getLocation());
                 jobRepository.save(job);
                 return true;
             }
        return false;
    }
}
