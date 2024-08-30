package com.htckymk.issue_management.api;


import com.htckymk.issue_management.dto.ProjectDto;
import com.htckymk.issue_management.service.imlp.ProjectServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/project")
public class ProjectController {
    private final ProjectServiceImpl projectServiceImpl;

    public ProjectController(ProjectServiceImpl projectServiceImpl) {
        this.projectServiceImpl = projectServiceImpl;
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProjectDto> getById(@PathVariable(value="id",required = true) Long id) {
       ProjectDto projectDto = projectServiceImpl.getById(id);
       return ResponseEntity.ok(projectDto);
    }
    @PostMapping
    public ResponseEntity<ProjectDto> creatProject(@Validated @RequestBody ProjectDto project){
       return  ResponseEntity.ok(projectServiceImpl.save(project));

    }
    @PutMapping("/{id}")
    public ResponseEntity<ProjectDto> updateProject(@PathVariable(value="id",required = true) Long id,@Validated @RequestBody ProjectDto project){
       return ResponseEntity.ok(projectServiceImpl.update(id,project));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value="id",required = true) Long id){
        return ResponseEntity.ok(projectServiceImpl.delete(id));
    }


}
