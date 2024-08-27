package com.htckymk.issue_management.repository;

import com.htckymk.issue_management.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue,Long> {


}
