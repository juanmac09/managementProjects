package com.example.projects.servicesInterfaces.users;

import com.example.projects.dto.users.read.UserReadGeneralDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserReadGeneralService {

    public Page<UserReadGeneralDto> getAllUsers(Pageable pageable);
}
