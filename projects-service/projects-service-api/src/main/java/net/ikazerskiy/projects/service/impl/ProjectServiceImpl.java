package net.ikazerskiy.projects.service.impl;

import net.ikazerskiy.projects.service.api.ProjectService;
import net.ikazerskiy.projects.service.api.dto.ProjectDto;
import net.ikazerskiy.projects.service.api.dto.ProjectSearchResult;
import net.ikazerskiy.projects.service.api.dto.SearchResult;
import net.ikazerskiy.projects.service.api.dto.request.ProjectCreateRequest;
import net.ikazerskiy.projects.service.api.exception.FieldValidationException;
import net.ikazerskiy.projects.service.api.exception.ProjectAlreadyExistsException;
import net.ikazerskiy.projects.service.dao.ProjectRepository;
import net.ikazerskiy.projects.service.dao.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public SearchResult<ProjectDto> findAll() {
        SearchResult<ProjectDto> searchResult = new ProjectSearchResult();
        Iterable<Project> projects = projectRepository.findAll();
        if (projects != null) {
            projects.forEach(project -> {
                ProjectDto projectDto = new ProjectDto();
                projectDto.setUid(project.getUid());
                projectDto.setName(project.getName());
                projectDto.setDescription(project.getDescription());

                searchResult.getSearchResult().add(projectDto);
            });
        }
        return searchResult;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String createProject(ProjectCreateRequest projectCreateRequest)
            throws ProjectAlreadyExistsException, FieldValidationException {
        Project newProject = new Project();
        newProject.setUid(UUID.randomUUID().toString());
        newProject.setName(projectCreateRequest.getName());
        newProject.setDescription(projectCreateRequest.getDescription());
        newProject.setCreateDate(new Date());
        newProject.setUpdateDate(newProject.getCreateDate());
        projectRepository.save(newProject);

        return newProject.getUid();
    }
}
