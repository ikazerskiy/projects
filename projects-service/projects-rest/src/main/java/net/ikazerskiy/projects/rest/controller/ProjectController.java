package net.ikazerskiy.projects.rest.controller;

import net.ikazerskiy.projects.service.api.ProjectService;
import net.ikazerskiy.projects.service.api.dto.ProjectDto;
import net.ikazerskiy.projects.service.api.dto.SearchResult;
import net.ikazerskiy.projects.service.api.dto.request.ProjectCreateRequest;
import net.ikazerskiy.projects.service.api.exception.FieldValidationException;
import net.ikazerskiy.projects.service.api.exception.ProjectAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/services/projects/", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping(path = "/")
    public String createProject(@RequestBody ProjectCreateRequest projectCreateRequest)
            throws FieldValidationException, ProjectAlreadyExistsException {
        return projectService.createProject(projectCreateRequest);
    }

    @GetMapping("/list")
    public SearchResult<ProjectDto> getProjectsList() {
        return projectService.findAll();
    }

}
