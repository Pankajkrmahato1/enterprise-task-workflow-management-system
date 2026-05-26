package com.github.pankajkrmahato1.enterprise_task_workflow_management_system.controller;

import com.github.pankajkrmahato1.enterprise_task_workflow_management_system.DTO.UserRequestDTO;
import com.github.pankajkrmahato1.enterprise_task_workflow_management_system.DTO.UserResponseDTO;
import com.github.pankajkrmahato1.enterprise_task_workflow_management_system.entity.User;
import com.github.pankajkrmahato1.enterprise_task_workflow_management_system.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    @PostMapping
   public ResponseEntity<UserResponseDTO> createUser(
           @Valid
           @RequestBody
           UserRequestDTO requestDTO
    ) {
        return ResponseEntity.ok(userService.createUser(requestDTO));
    }

}
