package com.example.projects.controllers.users;


import com.example.projects.dtos.users.write.UserCreateDto;
import com.example.projects.servicesInterfaces.users.IUserWriteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final IUserWriteService userWriteService;

    public UserController(IUserWriteService userWriteService) {
        this.userWriteService = userWriteService;
    }
    @PostMapping("/created")
    public ResponseEntity<String> create(@RequestBody UserCreateDto userCreateDto) {
        this.userWriteService.save(userCreateDto);
        return ResponseEntity.ok("registered successfully");
    }
}
