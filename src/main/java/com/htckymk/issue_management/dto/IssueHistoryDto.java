package com.htckymk.issue_management.dto;

import com.htckymk.issue_management.entity.IssueStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Issue History Data Transfer Object")
public class IssueHistoryDto {
    @Schema(required = true, description= "ID")
    private Long id;
    @Schema(required = true, description= "Issue")
    private String Issue;
    @Schema(required = true, description= "Description")
    private String description;
    @Schema(required = true, description= "Date")
    private Date date;
    @Schema(required = true, description= "Issue Status")
    private IssueStatus issueStatus;
    @Schema(required = true, description= "Issue Details")
    private String details;
    @Schema(required = true, description= "Assignee")
    private UserDto assignee;
}
