package com.github.pankajkrmahato1.enterprise_task_workflow_management_system.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRequestDTO(
        @NotBlank
        String username,

        @Email
        @NotBlank String email,

        @NotBlank String password
) {
}
