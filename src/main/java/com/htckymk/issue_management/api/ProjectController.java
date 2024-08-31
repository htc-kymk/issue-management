package com.htckymk.issue_management.api;


import com.htckymk.issue_management.advice.ExceptionResponse;
import com.htckymk.issue_management.dto.ProjectDto;
import com.htckymk.issue_management.service.imlp.ProjectServiceImpl;
import com.htckymk.issue_management.util.ApiPaths;
import com.htckymk.issue_management.util.TPage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;


@RestController
@RequestMapping(ApiPaths.ProjectCtrl.CTRL)
@Tag(name = ApiPaths.ProjectCtrl.CTRL, description = "Project APIs")
@Slf4j
public class ProjectController {
    private final ProjectServiceImpl projectServiceImpl;

    public ProjectController(ProjectServiceImpl projectServiceImpl) {
        this.projectServiceImpl = projectServiceImpl;
    }
    @GetMapping("/pagination")
    @Operation(summary = "Get By Pagination Operation", responses = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    content = @Content(schema = @Schema(implementation = ProjectDto.class)))})
    public ResponseEntity<TPage<ProjectDto>> getAllByPagination(Pageable pageable) {
        TPage<ProjectDto> data = projectServiceImpl.getAllPageable(pageable);
        return ResponseEntity.ok(data);
    }


    @GetMapping("/{id}")
    @Operation(summary = "Get By Id Operation", responses = {
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                            content = @Content(schema = @Schema(implementation = ProjectDto.class)))})
    public ResponseEntity<ProjectDto> getById(@PathVariable(value="id",required = true) Long id) {
        log.info("ProjectController-> GetByID" );
        log.debug("ProjectController-> GetByID -> PARAM:" + id);

        ProjectDto projectDto = projectServiceImpl.getById(id);
       return ResponseEntity.ok(projectDto);
    }
    @PostMapping
    @Operation(summary = "Create Operation", responses = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    content = @Content(schema = @Schema(implementation = ProjectDto.class)))})
    public ResponseEntity<ProjectDto> creatProject(@Validated @RequestBody ProjectDto project){
       return  ResponseEntity.ok(projectServiceImpl.save(project));

    }
    @PutMapping("/{id}")
    @Operation(summary = "Update Operation", responses = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    content = @Content(schema = @Schema(implementation = ProjectDto.class)))})
    public ResponseEntity<ProjectDto> updateProject(@PathVariable(value="id",required = true) Long id,@Validated @RequestBody ProjectDto project){
       return ResponseEntity.ok(projectServiceImpl.update(id,project));
    }
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Operation", responses = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    content = @Content(schema = @Schema(implementation = Boolean.class)))})
    public ResponseEntity<Boolean> delete(@PathVariable(value="id",required = true) Long id){
        return ResponseEntity.ok(projectServiceImpl.delete(id));
    }


}
