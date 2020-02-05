package net.ikazerskiy.projects.service.api;

import net.ikazerskiy.projects.service.api.dto.ProjectDto;
import net.ikazerskiy.projects.service.api.dto.SearchResult;

public interface ProjectService {
    SearchResult<ProjectDto> findAll();
}
