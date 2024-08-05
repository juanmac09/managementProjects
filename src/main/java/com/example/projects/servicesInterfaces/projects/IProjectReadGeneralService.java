package com.example.projects.servicesInterfaces.projects;

import com.example.projects.dto.projects.read.ProjectReadGeneralDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProjectReadGeneralService {

    Page<ProjectReadGeneralDto> getGeneralProjects(Pageable pageable);
}
