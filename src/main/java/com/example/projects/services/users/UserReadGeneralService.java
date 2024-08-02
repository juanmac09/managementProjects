package com.example.projects.services.users;

import com.example.projects.dto.users.read.UserReadGeneralDto;
import com.example.projects.entities.User;
import com.example.projects.mapping.users.UserReadGeneralMapper;
import com.example.projects.repositories.users.UserRepository;
import com.example.projects.servicesInterfaces.users.IUserReadGeneralService;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserReadGeneralService implements IUserReadGeneralService {

    private final UserReadGeneralMapper userReadGeneralMapper;
    private final UserRepository userRepository;

    public UserReadGeneralService(UserReadGeneralMapper userReadGeneralMapper, UserRepository UserRepository) {
        this.userReadGeneralMapper = userReadGeneralMapper;
        this.userRepository = UserRepository;
    }

    @Transactional
    @Override
    public Page<UserReadGeneralDto> getAllUsers(Pageable pageable) {
        Page<User> users = userRepository.findAll(pageable);

        return  users.map(this.userReadGeneralMapper::map);
    }
}
