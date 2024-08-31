package com.htckymk.issue_management.service;

import com.htckymk.issue_management.util.TPage;
import com.htckymk.issue_management.dto.ProjectDto;
import com.htckymk.issue_management.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface ProjectService {

    ProjectDto save(ProjectDto project);

    ProjectDto getById(Long id);

    ProjectDto getByProjectCode(String projectCode);

    Project getByProjectCodeAndIdNot(String projectCode, Long id);

    List<ProjectDto> getByProjectCodeContains(String projectCode);

    TPage<ProjectDto> getAllPageable(Pageable pageable);

    Boolean delete(Project project);

    Boolean delete(Long id);

    ProjectDto update(Long id, ProjectDto project);
}
