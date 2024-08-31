package com.htckymk.issue_management.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Project Data Transfer Object")
public class ProjectDto {
    @Schema(description = "Project ID")
    private Long id;
    @NotNull
    @Schema(required = true, description = "Name Of Project")
    private String projectName;
    @NotNull
    @Schema(required = true, description = "Code Of Project")
    private String projectCode;
}
