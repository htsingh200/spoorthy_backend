package com.spoorthy.backend.service;

import java.util.List;

import com.spoorthy.backend.entity.Issue;

public interface IssueService {
    Issue createIssue(Issue issue);

    Issue updateIssue(Issue issue);

    Issue getIssueById(Long id);

    void deleteIssue(Long id);

    List<Issue> getAllIssues();
}
