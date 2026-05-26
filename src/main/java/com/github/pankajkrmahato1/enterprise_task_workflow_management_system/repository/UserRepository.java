package com.github.pankajkrmahato1.enterprise_task_workflow_management_system.repository;


import com.github.pankajkrmahato1.enterprise_task_workflow_management_system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    boolean existsByEmail(String email);
    }

