package com.example.projects.services.users;

import com.example.projects.dto.users.write.UserCreateDto;
import com.example.projects.dto.users.write.UserUpdateDto;
import com.example.projects.entities.Role;
import com.example.projects.entities.User;
import com.example.projects.exceptions.users.UpdateException;
import com.example.projects.exceptions.users.UserNotFoundException;
import com.example.projects.repositories.roles.RoleRepository;
import com.example.projects.repositories.users.UserRepository;
import com.example.projects.servicesInterfaces.users.IUserWriteService;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserWriteService implements IUserWriteService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserWriteService(UserRepository userRepository, PasswordEncoder passwordEncoder,RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }



    @Transactional
    @Override
    public void save(UserCreateDto userCreateDto) {
        User user = new User();
        user.setUsername(userCreateDto.getUsername());
        user.setEmail(userCreateDto.getEmail());
        user.setPassword(passwordEncoder.encode(userCreateDto.getEmail()));
        Iterable<Role> roles = this.roleRepository.findAllById(userCreateDto.getRoles());

        for (Role role : roles) {
            user.addRole(role);
        }

        userRepository.save(user);
    }

    @Transactional
    @Override
    public void update(Long id,UserUpdateDto userUpdateDto) {

        if (!userUpdateDto.equals()){
            throw new UpdateException("Password does not match");
        }

        Optional<User> userdb = this.userRepository.findById(id);
        if (!userdb.isPresent()){
            throw new UserNotFoundException("User not found");
        }
        User user = userdb.get();
        user.setPassword(passwordEncoder.encode(userUpdateDto.getPassword()));
        this.userRepository.save(user);
    }
}
