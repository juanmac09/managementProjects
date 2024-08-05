package com.example.projects.mapping.projects;

import com.example.projects.dto.projects.read.ProjectReadGeneralDto;
import com.example.projects.entities.Project;
import com.example.projects.mapping.Mapper;
import com.example.projects.mapping.users.UserReadGeneralMapper;
import org.springframework.stereotype.Component;

@Component
public class ProjectReadGeneralMapper implements Mapper<ProjectReadGeneralDto, Project> {

    private final UserReadGeneralMapper userReadGeneralDto;

    public ProjectReadGeneralMapper(UserReadGeneralMapper userReadGeneralDto) {
        this.userReadGeneralDto = userReadGeneralDto;
    }

    @Override
    public ProjectReadGeneralDto map(Project project) {
        ProjectReadGeneralDto projectReadGeneralDto = new ProjectReadGeneralDto();
        projectReadGeneralDto.setId(project.getId());
        projectReadGeneralDto.setName(project.getName());
        projectReadGeneralDto.setDescription(project.getDescription());
        projectReadGeneralDto.setStartDate(project.getStartDate());
        projectReadGeneralDto.setEndDate(project.getEndDate());
        projectReadGeneralDto.setCreatedBy(this.userReadGeneralDto.map(project.getCreatedBy()));
        return projectReadGeneralDto;

    }
}
