package com.github.pankajkrmahato1.enterprise_task_workflow_management_system.service;

import com.github.pankajkrmahato1.enterprise_task_workflow_management_system.DTO.UserRequestDTO;
import com.github.pankajkrmahato1.enterprise_task_workflow_management_system.DTO.UserResponseDTO;
import com.github.pankajkrmahato1.enterprise_task_workflow_management_system.entity.Role;
import com.github.pankajkrmahato1.enterprise_task_workflow_management_system.entity.User;
import com.github.pankajkrmahato1.enterprise_task_workflow_management_system.exception.ResourceAlreadyExistsException;
import com.github.pankajkrmahato1.enterprise_task_workflow_management_system.exception.ResourceNotFoundException;
import com.github.pankajkrmahato1.enterprise_task_workflow_management_system.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

        return mapToResponse(saved);
    }
    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public UserResponseDTO updateUser(Long id, UserRequestDTO reqeust) {
        User user = userRepository.findById(id)
                .orElseThrow(
                        ()->new ResourceNotFoundException ("user not found")
                );
        user.setUsername(reqeust.username());
        user.setEmail(reqeust.email());
        user.setPassword(reqeust.password());
        User updated = userRepository.save(user);

        return mapToResponse(updated);
    }

    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException ("user not found"));
        userRepository.delete(user);
    }

    public UserResponseDTO mapToResponse(User user) {
        return new UserResponseDTO(
                user.getId(),
                user.getEmail(),
                user.getUsername(),
                user.getRole().name()
        );
    }

    public UserResponseDTO getUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("user not found"));
        return mapToResponse(user);
    }
}
