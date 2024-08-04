package com.example.projects.servicesInterfaces.projects;

import com.example.projects.dto.projects.write.CreateProjectDto;

public interface IProjectWriteService {

    void save(CreateProjectDto projectDto);
}
