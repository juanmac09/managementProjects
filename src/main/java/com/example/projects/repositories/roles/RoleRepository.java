package com.example.projects.repositories.roles;

import com.example.projects.entities.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository  extends CrudRepository <Role,Long> {

}
