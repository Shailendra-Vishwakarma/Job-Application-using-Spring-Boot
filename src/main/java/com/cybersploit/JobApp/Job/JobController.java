package com.cybersploit.JobApp.Job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/jobs")
public class JobController {
    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
     public ResponseEntity<List<Job>> findAll(){
         return ResponseEntity.ok(jobService.findAll());
    }
    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job){
         jobService.createJob(job);
         return new ResponseEntity<>("New job created",HttpStatus.CREATED);
    }
    @GetMapping("/{jobId}")
    public ResponseEntity<Job> getJobById(@PathVariable Long jobId){
        Job job = jobService.getJobById(jobId);
        if(job!=null) return new ResponseEntity<>(job, HttpStatus.OK);
        else return new ResponseEntity<>(job, HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{jobId}")
    public ResponseEntity<String> deleteById(@PathVariable Long jobId){
      boolean deleted= jobService.deleteById(jobId);
      if(deleted)
          return new ResponseEntity<>("Job deleted successfully",HttpStatus.OK);
      else
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/{jobId}")
    public ResponseEntity<String> updateJob(@PathVariable Long jobId, @RequestBody Job updatedJob){
      boolean updatedjob= jobService.updateJob(jobId,updatedJob);
      if(updatedjob)
          return new ResponseEntity<>("Job updated successfully",HttpStatus.OK);
      else
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
