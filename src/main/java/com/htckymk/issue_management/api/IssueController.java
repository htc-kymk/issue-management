package com.htckymk.issue_management.api;
import com.htckymk.issue_management.dto.IssueDto;
import com.htckymk.issue_management.dto.ProjectDto;
import com.htckymk.issue_management.service.imlp.IssueServiceImpl;
import com.htckymk.issue_management.util.ApiPaths;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping(ApiPaths.IssueCtrl.CTRL)
@Tag(name = ApiPaths.IssueCtrl.CTRL, description = "Issue APIs")

public class IssueController {

    private final IssueServiceImpl issueServiceImpl;

    public IssueController(IssueServiceImpl issueServiceImpl) {
        this.issueServiceImpl = issueServiceImpl;
    }
    @GetMapping("/{id}")
    @Operation(summary = "Get By Id Operation", responses = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    content = @Content(schema = @Schema(implementation = IssueDto.class)))})
    public ResponseEntity<IssueDto> getById(@PathVariable(value="id",required = true) Long id) {
        IssueDto projectDto = issueServiceImpl.getById(id);
       return ResponseEntity.ok(projectDto);
    }
    @PostMapping
    @Operation(summary = "Create Operation", responses = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    content = @Content(schema = @Schema(implementation = IssueDto.class)))})
    public ResponseEntity<IssueDto> creatProject(@Validated @RequestBody IssueDto project){
       return  ResponseEntity.ok(issueServiceImpl.save(project));

    }
    @PutMapping("/{id}")
    @Operation(summary = "Update Operation", responses = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    content = @Content(schema = @Schema(implementation = IssueDto.class)))})
    public ResponseEntity<IssueDto> updateProject(@PathVariable(value="id",required = true) Long id,@Validated @RequestBody IssueDto project){
       return ResponseEntity.ok(issueServiceImpl.update(id,project));
    }
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Operation", responses = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    content = @Content(schema = @Schema(implementation = Boolean.class)))})
    public ResponseEntity<Boolean> delete(@PathVariable(value="id",required = true) Long id){
        return ResponseEntity.ok(issueServiceImpl.delete(id));
    }


}
