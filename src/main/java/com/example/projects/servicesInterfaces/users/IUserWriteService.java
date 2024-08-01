package com.example.projects.servicesInterfaces.users;

import com.example.projects.dtos.users.write.UserCreateDto;

public interface IUserWriteService {

    public void save(UserCreateDto userCreateDto);
}
