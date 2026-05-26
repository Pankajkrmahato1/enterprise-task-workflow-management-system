package com.github.pankajkrmahato1.enterprise_task_workflow_management_system.controller;

import com.github.pankajkrmahato1.enterprise_task_workflow_management_system.DTO.UserRequestDTO;
import com.github.pankajkrmahato1.enterprise_task_workflow_management_system.DTO.UserResponseDTO;
import com.github.pankajkrmahato1.enterprise_task_workflow_management_system.entity.User;
import com.github.pankajkrmahato1.enterprise_task_workflow_management_system.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO>
    getUser(
            @PathVariable Long id
    ){
        return ResponseEntity.ok(userService.getUser(id));
    }

    @GetMapping

    public ResponseEntity<List<UserResponseDTO>>
    getAllUsers(){

        return ResponseEntity.ok(

                userService.getAllUsers()

        );

    }

    @PutMapping("/{id}")

    public ResponseEntity<UserResponseDTO>

    updateUser(

            @PathVariable Long id,

            @RequestBody

            @Valid

            UserRequestDTO request){

        return ResponseEntity.ok(

                userService.updateUser(

                        id,

                        request

                )

        );

    }

    @DeleteMapping("/{id}")

    public ResponseEntity<Void>

    deleteUser(

            @PathVariable

            Long id){

        userService.deleteUser(id);

        return ResponseEntity
                .noContent()
                .build();

    }

}
