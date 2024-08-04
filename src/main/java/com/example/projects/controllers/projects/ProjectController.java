package com.example.projects.controllers.projects;

import com.example.projects.dto.authentication.UserAuthenticated;
import com.example.projects.dto.projects.write.CreateProjectDto;
import com.example.projects.servicesInterfaces.projects.IProjectWriteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/project")
public class ProjectController {

    private final IProjectWriteService projectWriteService;
    private final UserAuthenticated userAuthenticated;

    public ProjectController(IProjectWriteService projectWriteService, UserAuthenticated userAuthenticated) {
        this.projectWriteService = projectWriteService;
        this.userAuthenticated = userAuthenticated;
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody CreateProjectDto projectDto) {

        projectDto.setCreatedBy(this.userAuthenticated.getUser());

        this.projectWriteService.save(projectDto);
        return new ResponseEntity<String>("Created", HttpStatus.CREATED);
    }
}
