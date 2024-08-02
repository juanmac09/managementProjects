package com.example.projects.servicesInterfaces.users;

import com.example.projects.dto.users.write.UserCreateDto;

public interface IUserWriteService {

    public void save(UserCreateDto userCreateDto);
}
