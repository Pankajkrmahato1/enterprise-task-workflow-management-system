package com.github.pankajkrmahato1.enterprise_task_workflow_management_system.service;

import com.github.pankajkrmahato1.enterprise_task_workflow_management_system.DTO.UserRequestDTO;
import com.github.pankajkrmahato1.enterprise_task_workflow_management_system.DTO.UserResponseDTO;
import com.github.pankajkrmahato1.enterprise_task_workflow_management_system.entity.Role;
import com.github.pankajkrmahato1.enterprise_task_workflow_management_system.entity.User;
import com.github.pankajkrmahato1.enterprise_task_workflow_management_system.exception.ResourceAlreadyExistsException;
import com.github.pankajkrmahato1.enterprise_task_workflow_management_system.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {

        if(userRepository.existsByEmail(userRequestDTO.email())){
            throw new ResourceAlreadyExistsException("email already exists");
        }

        User user = User.builder()
                .username(userRequestDTO.username())
                .email(userRequestDTO.email())
                .password(userRequestDTO.password())
                .role(Role.Engineer)
                .build();

        User saved = userRepository.save(user);

        return new UserResponseDTO(
                saved.getId(),
                saved.getEmail(),
                saved.getUsername(),
                saved.getRole().name()
        );
                
    }
}
