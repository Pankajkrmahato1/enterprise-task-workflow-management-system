package com.github.pankajkrmahato1.enterprise_task_workflow_management_system.exception;

import java.time.LocalDateTime;

public record ApiErrorResponse(LocalDateTime timestamp, Integer status, String message) {
}
