package net.ikazerskiy.projects.service.api;

import net.ikazerskiy.projects.service.api.dto.ProjectDto;
import net.ikazerskiy.projects.service.api.dto.SearchResult;
import net.ikazerskiy.projects.service.api.dto.request.ProjectCreateRequest;
import net.ikazerskiy.projects.service.api.exception.FieldValidationException;
import net.ikazerskiy.projects.service.api.exception.ProjectAlreadyExistsException;

public interface ProjectService {
    SearchResult<ProjectDto> findAll();
    String createProject(ProjectCreateRequest projectCreateRequest)
            throws ProjectAlreadyExistsException, FieldValidationException;
}
