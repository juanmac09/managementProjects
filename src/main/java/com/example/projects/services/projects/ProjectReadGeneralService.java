package com.example.projects.services.projects;

import com.example.projects.dto.projects.read.ProjectReadGeneralDto;
import com.example.projects.entities.Project;
import com.example.projects.mapping.projects.ProjectReadGeneralMapper;
import com.example.projects.repositories.projects.ProjectRepository;
import com.example.projects.servicesInterfaces.projects.IProjectReadGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProjectReadGeneralService implements IProjectReadGeneralService {

    private final ProjectRepository projectRepository;
    private final ProjectReadGeneralMapper projectReadGeneralMapper;

    private ProjectReadGeneralService(ProjectRepository projectRepository, ProjectReadGeneralMapper projectReadGeneralMapper) {
        this.projectRepository = projectRepository;
        this.projectReadGeneralMapper = projectReadGeneralMapper;
    }

    @Override
    public Page<ProjectReadGeneralDto> getGeneralProjects(Pageable pageable) {
        Page<Project> projects = projectRepository.findAllByOrderByNameAsc(pageable);
        return projects.map(this.projectReadGeneralMapper::map);
    }
}
