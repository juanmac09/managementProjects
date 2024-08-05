package com.example.projects.controllers.users;


import com.example.projects.common.responses.ApiResponse;
import com.example.projects.dto.users.read.UserReadGeneralDto;
import com.example.projects.dto.users.write.UserCreateDto;
import com.example.projects.dto.users.write.UserUpdateDto;
import com.example.projects.servicesInterfaces.users.IUserReadGeneralService;
import com.example.projects.servicesInterfaces.users.IUserWriteService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.HashMap;

@RestController
@RequestMapping("/users")
public class UserController {

    private final IUserWriteService userWriteService;
    private final IUserReadGeneralService userReadGeneralService;

    public UserController(IUserWriteService userWriteService, IUserReadGeneralService userReadGeneralService) {
        this.userWriteService = userWriteService;
        this.userReadGeneralService = userReadGeneralService;
    }
    @PostMapping("/created")
    public ResponseEntity<ApiResponse<?>> create(@RequestBody UserCreateDto userCreateDto) {
        ApiResponse<?> apiResponse = new ApiResponse<>();
        apiResponse.setMessage("Registered successfully");
        apiResponse.setSuccess(true);
        this.userWriteService.save(userCreateDto);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @GetMapping("/get-users/page/{page}/size/{size}")
    public ResponseEntity<ApiResponse<Page<UserReadGeneralDto>>> getUsers(@PathVariable("page") int page, @PathVariable("size") int size){
        Pageable pageable = PageRequest.of(page,size);

        ApiResponse<Page<UserReadGeneralDto>> apiResponse = new ApiResponse<>();
        apiResponse.setMessage("Users found");
        apiResponse.setSuccess(true);
        apiResponse.setData(this.userReadGeneralService.getAllUsers(pageable));

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

        @PutMapping("/update/{id}")
        public ResponseEntity<ApiResponse<?>> update(@PathVariable("id") Long id, @RequestBody UserUpdateDto userUpdateDto) {
            ApiResponse<?> apiResponse = new ApiResponse<>();
            apiResponse.setMessage("User updated");

            this.userWriteService.update(id,userUpdateDto);
            return new ResponseEntity<>(apiResponse,HttpStatus.OK);
        }
    }
