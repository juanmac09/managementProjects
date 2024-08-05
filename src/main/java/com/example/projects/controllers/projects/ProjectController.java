package com.example.projects.controllers.projects;

import com.example.projects.common.responses.ApiResponse;
import com.example.projects.dto.authentication.UserAuthenticated;
import com.example.projects.dto.projects.read.ProjectReadGeneralDto;
import com.example.projects.dto.projects.write.CreateProjectDto;
import com.example.projects.dto.users.read.UserReadGeneralDto;
import com.example.projects.servicesInterfaces.projects.IProjectReadGeneralService;
import com.example.projects.servicesInterfaces.projects.IProjectWriteService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/project")
public class ProjectController {

    private final IProjectWriteService projectWriteService;
    private final IProjectReadGeneralService projectReadService;
    private final UserAuthenticated userAuthenticated;

    public ProjectController(IProjectWriteService projectWriteService, UserAuthenticated userAuthenticated, IProjectReadGeneralService projectReadService, UserAuthenticated userAuthenticated2) {

        this.projectWriteService = projectWriteService;
        this.userAuthenticated = userAuthenticated;
        this.projectReadService = projectReadService;
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<?>> create(@RequestBody CreateProjectDto projectDto) {
        ApiResponse<?> apiResponse = new ApiResponse<>();
        apiResponse.setSuccess(true);
        apiResponse.setMessage("Created");
        projectDto.setCreatedBy(this.userAuthenticated.getUser());
        this.projectWriteService.save(projectDto);
        return new ResponseEntity<ApiResponse<?>>(apiResponse, HttpStatus.CREATED);
    }

    @GetMapping("/get-all-projects/page/{page}/size/{size}")
    public ResponseEntity<ApiResponse<Page<ProjectReadGeneralDto>>> getAllProjects(@PathVariable("page") int page, @PathVariable("size") int size) {
        Pageable pageable = PageRequest.of(page,size);
        ApiResponse<Page<ProjectReadGeneralDto>> apiResponse = new ApiResponse<>();
        apiResponse.setSuccess(true);
        apiResponse.setMessage("Get All Projects");
        apiResponse.setData(this.projectReadService.getGeneralProjects(pageable));

        return  new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }



}
