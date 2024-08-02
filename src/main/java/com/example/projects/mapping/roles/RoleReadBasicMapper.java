package com.example.projects.mapping.roles;

import com.example.projects.dto.roles.read.RoleReadBasicDto;
import com.example.projects.entities.Role;
import com.example.projects.mapping.Mapper;
import org.springframework.stereotype.Component;

@Component
public class RoleReadBasicMapper implements Mapper<RoleReadBasicDto, Role> {

    public RoleReadBasicDto map(Role role) {
        if (role == null) return null;

        RoleReadBasicDto roleReadBasicDto = new RoleReadBasicDto();
        roleReadBasicDto.setName(role.getName());
        roleReadBasicDto.setDescription(role.getDescription());
        return roleReadBasicDto;
    }
}
