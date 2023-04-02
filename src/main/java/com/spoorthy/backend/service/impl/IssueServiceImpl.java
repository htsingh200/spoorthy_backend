package com.spoorthy.backend.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spoorthy.backend.entity.Issue;
import com.spoorthy.backend.repository.IssueRepository;
import com.spoorthy.backend.service.IssueService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class IssueServiceImpl implements IssueService {

    private IssueRepository issueRepository;

    @Override
    public Issue createIssue(Issue issue) {
        return issueRepository.save(issue);
    }

    @Override
    public Issue updateIssue(Issue issue) {
        Issue existingIssue = issueRepository.findById(issue.getId()).orElse(null);

        System.out.println("Result: " + issue.getResult());
        System.out.println("Updated time " + issue.getUpdatedAt());

        if (issue.getPriority() != null) {
            existingIssue.setPriority(issue.getPriority());
        }
        if (issue.getSolution() != null) {
            existingIssue.setSolution(issue.getSolution());
        }
        if (issue.getResult() != null) {
            existingIssue.setResult(issue.getResult());
        }
        if (issue.getUpdatedAt() != null) {
            existingIssue.setUpdatedAt(issue.getUpdatedAt());
        }
        existingIssue.setStatus(issue.isStatus());

        return issueRepository.save(existingIssue);
    }

    @Override
    public void deleteIssue(Long id) {
        issueRepository.deleteById(id);
    }

    @Override
    public Issue getIssueById(Long id) {
        return issueRepository.findById(id).orElse(null);
    }

    @Override
    public List<Issue> getAllIssues() {
        return issueRepository.findAll();
    }

}
