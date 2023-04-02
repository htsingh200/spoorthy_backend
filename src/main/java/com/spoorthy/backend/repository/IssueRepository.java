package com.spoorthy.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spoorthy.backend.entity.Issue;

public interface IssueRepository extends JpaRepository<Issue, Long> {
    
}
