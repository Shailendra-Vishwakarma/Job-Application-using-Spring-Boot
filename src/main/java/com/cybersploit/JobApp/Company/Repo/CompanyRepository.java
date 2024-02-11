package com.cybersploit.JobApp.Company.Repo;

import com.cybersploit.JobApp.Company.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
