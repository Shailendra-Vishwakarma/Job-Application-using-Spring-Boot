package com.cybersploit.JobApp.Job.Repo;

import com.cybersploit.JobApp.Job.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job,Long> {
}
