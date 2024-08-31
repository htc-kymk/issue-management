package com.htckymk.issue_management.service.imlp;

import com.htckymk.issue_management.dto.IssueDto;
import com.htckymk.issue_management.dto.ProjectDto;
import com.htckymk.issue_management.entity.Issue;
import com.htckymk.issue_management.entity.Project;
import com.htckymk.issue_management.repository.ProjectRepository;
import com.htckymk.issue_management.service.ProjectService;
import com.htckymk.issue_management.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
@Service
public class ProjectServiceImpl implements ProjectService{
    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;

    public ProjectServiceImpl(ProjectRepository projectRepository,ModelMapper modelMapper) {
        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public ProjectDto save(ProjectDto project) {

        Project projectCheck= projectRepository.getByProjectCode(project.getProjectCode());
        if(projectCheck != null){
            throw new IllegalArgumentException("Project code already exists");
        }
        Project p=modelMapper.map(project,Project.class);
        p=projectRepository.save(p);
        project.setId(p.getId());
        return project;}

    @Override
    public ProjectDto getById(Long id) {
      Project p= projectRepository.getOne(id);
      return modelMapper.map(p,ProjectDto.class);

    }
    @Override
    public ProjectDto getByProjectCode(String projectCode) {
        return null;}

    @Override
    public Project getByProjectCodeAndIdNot(String projectCode, Long id) {
        return projectRepository.getByProjectCodeAndIdNot(projectCode, id);
    }
    @Override
    public TPage<ProjectDto> getAllPageable(Pageable pageable) {
        Page<Project> data = projectRepository.findAll(pageable);
        TPage<ProjectDto> respnose = new TPage<ProjectDto>();
        respnose.setStat(data, Arrays.asList(modelMapper.map(data.getContent(), ProjectDto[].class)));
        return respnose;
    }

    @Override
    public List<ProjectDto> getByProjectCodeContains(String projectCode) {
        return List.of();}


    @Override
    public Boolean delete(Project project) {
        return null;}

    @Override
    public Boolean delete(Long  id) {
         projectRepository.deleteById(id);
         return true;
    }



    @Override
    public ProjectDto update(Long id, ProjectDto project) {
        Project projectDb= projectRepository.getOne(id);
        if(projectDb==null){
            throw new IllegalArgumentException("Project does not exist id:" + id);
        }
        Project projectCheck= projectRepository.getByProjectCodeAndIdNot(project.getProjectCode(),id);
        if(projectCheck != null){
            throw new IllegalArgumentException("Project code already exists");
        }
        projectDb.setProjectCode(project.getProjectCode());
        projectDb.setProjectName(project.getProjectName());

        projectRepository.save(projectDb);
        return modelMapper.map(projectDb,ProjectDto.class);

    }
}
