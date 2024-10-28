package com.example.tasklist.domain.user;

import com.example.tasklist.domain.task.Task;
import lombok.Data;
import org.hibernate.mapping.Set;
import com.example.tasklist.domain.user.Role;

import java.util.List;

@Data
public class User {

    private Long id;
    private String name;
    private String username;
    private String password;
    private String passwordConfirmation;
    private List<Role> roles;
    private List<Task> tasks;

}
