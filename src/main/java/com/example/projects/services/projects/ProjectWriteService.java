package com.example.projects.services.projects;

import com.example.projects.dto.projects.write.CreateProjectDto;
import com.example.projects.entities.Project;
import com.example.projects.repositories.projects.ProjectRepository;
import com.example.projects.servicesInterfaces.projects.IProjectWriteService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ProjectWriteService implements IProjectWriteService {

    private final ProjectRepository projectRepository;

    public ProjectWriteService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Transactional
    @Override
    public void save(CreateProjectDto projectDto) {
        Project project = new Project(projectDto.getTitle(),projectDto.getDescription(),projectDto.getStartDate(),projectDto.getEndDate(),projectDto.getCreatedBy());
        projectRepository.save(project);
    }
}
