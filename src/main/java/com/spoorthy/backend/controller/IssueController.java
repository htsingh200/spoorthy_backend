package com.spoorthy.backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spoorthy.backend.entity.Issue;
import com.spoorthy.backend.service.IssueService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/issues")
public class IssueController {
    private IssueService issueService;

    @PostMapping
    public ResponseEntity<Issue> createIssue(@RequestBody Issue issue) {
        Issue newIssue = issueService.createIssue(issue);
        return new ResponseEntity<>(newIssue, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Issue>> getAllIssues() {
        List<Issue> issues = issueService.getAllIssues();
        return new ResponseEntity<>(issues, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Issue> getIssueById(@PathVariable("id") Long userId) {
        Issue issue = issueService.getIssueById(userId);
        return new ResponseEntity<>(issue, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Issue> updateIssue(@PathVariable("id") Long userId, @RequestBody Issue issue) {
        issue.setId(userId);
        Issue updatedIssue = issueService.updateIssue(issue);
        return new ResponseEntity<>(updatedIssue, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteIssue(@PathVariable("id") Long userId) {
        issueService.deleteIssue(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
