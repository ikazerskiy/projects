package net.ikazerskiy.projects.service;

import net.ikazerskiy.projects.service.api.ProjectService;
import net.ikazerskiy.projects.service.api.dto.ProjectDto;
import net.ikazerskiy.projects.service.api.dto.ProjectSearchResult;
import net.ikazerskiy.projects.service.api.dto.SearchResult;
import net.ikazerskiy.projects.service.dao.ProjectRepository;
import net.ikazerskiy.projects.service.dao.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

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
}
