package com.example.projects.servicesInterfaces.users;

import com.example.projects.dto.users.write.UserCreateDto;
import com.example.projects.dto.users.write.UserUpdateDto;

public interface IUserWriteService {

    void save(UserCreateDto userCreateDto);
    void update(Long id,UserUpdateDto userUpdateDto);
}
