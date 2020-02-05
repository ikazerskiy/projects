package net.ikazerskiy.projects.service.dao;

import net.ikazerskiy.projects.service.dao.entity.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, String> {
}
