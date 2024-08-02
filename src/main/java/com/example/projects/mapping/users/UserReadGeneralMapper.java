package com.example.projects.mapping.users;

import com.example.projects.dto.roles.read.RoleReadBasicDto;
import com.example.projects.dto.users.read.UserReadGeneralDto;
import com.example.projects.entities.Role;
import com.example.projects.entities.User;
import com.example.projects.mapping.Mapper;
import com.example.projects.mapping.roles.RoleReadBasicMapper;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UserReadGeneralMapper implements Mapper<UserReadGeneralDto, User> {

    private final RoleReadBasicMapper roleReadBasicMapper;

    public UserReadGeneralMapper(RoleReadBasicMapper roleReadBasicMapper) {
        this.roleReadBasicMapper = roleReadBasicMapper;
    }

    public UserReadGeneralDto map(User user) {
        if (user == null) return null;
        UserReadGeneralDto userReadGeneralDto = new UserReadGeneralDto();
        userReadGeneralDto.setUsername(user.getUsername());
        userReadGeneralDto.setEmail(user.getEmail());
        userReadGeneralDto.setRoles(
                user.getRoles().stream()
                        .map(this.roleReadBasicMapper::map)
                        .collect(Collectors.toList())
        );
        return userReadGeneralDto;
    }
}
