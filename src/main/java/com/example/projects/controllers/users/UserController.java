package com.example.projects.controllers.users;


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
    public ResponseEntity<String> create(@RequestBody UserCreateDto userCreateDto) {
        this.userWriteService.save(userCreateDto);
        return ResponseEntity.ok("registered successfully");
    }

    @GetMapping("/get-users/page/{page}/size/{size}")
    public ResponseEntity<Page<UserReadGeneralDto>> getUsers(@PathVariable("page") int page, @PathVariable("size") int size){
        Pageable pageable = PageRequest.of(page,size);

        return new ResponseEntity<Page<UserReadGeneralDto>>(this.userReadGeneralService.getAllUsers(pageable), HttpStatus.OK);
    }

        @PutMapping("/update/{id}")
        public ResponseEntity<HashMap<String,String>> update(@PathVariable("id") Long id, @RequestBody UserUpdateDto userUpdateDto) {
            HashMap<String,String> response = new HashMap<String,String>();
            response.put("message","Updated");

            this.userWriteService.update(id,userUpdateDto);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
    }
