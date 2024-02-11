package com.cybersploit.JobApp.Job.Impl;

import com.cybersploit.JobApp.Job.Job;
import com.cybersploit.JobApp.Job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {
     private List<Job> jobList=new ArrayList<>();
     private Long jobId=1L;
    @Override
    public List<Job> findAll() {
        return jobList;
    }

    @Override
    public void createJob(Job job) {
        job.setId(jobId++);
      jobList.add(job);
    }

    @Override
    public Job getJobById(Long jobId) {
        for (Job job : jobList) {
         if(job.getId() == jobId) {
         return job;
         }
        }
        return null;
}

    @Override
    public boolean deleteById(Long jobId) {
        Iterator<Job> itr=jobList.iterator();
        while (itr.hasNext()) {
            Job job=itr.next();
            if(job.getId().equals(jobId))
                itr.remove();
            return true;
        }
        return false;
    }

    @Override
    public boolean updateJob(Long jobId, Job updatedJob) {
         Iterator<Job> itr=jobList.iterator();
         while(itr.hasNext()){
             Job job = itr.next();
             if(job.getId()==jobId){
               job.setTitle(updatedJob.getTitle());
               job.setDescription(updatedJob.getDescription());
               job.setMinSalary(updatedJob.getMinSalary());
               job.setMaxSalary(updatedJob.getMaxSalary());
               job.setLocation(updatedJob.getLocation());
               return true;
             }

         }
        return false;
    }
}
