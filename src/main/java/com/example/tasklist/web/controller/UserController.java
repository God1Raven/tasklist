package com.example.tasklist.web.controller;

import com.example.tasklist.domain.task.Task;
import com.example.tasklist.domain.user.User;
import com.example.tasklist.service.TaskService;
import com.example.tasklist.service.UserService;
import com.example.tasklist.web.dto.task.TaskDto;
import com.example.tasklist.web.dto.user.UserDto;
import com.example.tasklist.web.dto.validation.OnCreate;
import com.example.tasklist.web.dto.validation.OnUpdate;
import com.example.tasklist.web.mappers.TaskMapper;
import com.example.tasklist.web.mappers.UserMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Validated
@Tag(name = "User Controller", description = "User API")
public class UserController {

    private final UserService userService;
    private final TaskService taskService;
    private final UserMapper userMapper;
    private final TaskMapper taskMapper;

    @PutMapping
    @Operation(summary = "Update User")
    public UserDto update(@Validated(OnUpdate.class)@RequestBody UserDto userDto ){
        User user = userMapper.dtoToEntity(userDto);
        User updatedUser = userService.update(user);
        return userMapper.entityToDto(updatedUser);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get User")
    public UserDto getById(@PathVariable Long id){
        User user =  userService.getById(id);
        return userMapper.entityToDto(user);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete User")
    public void deleteById(@PathVariable Long id){
        userService.delete(id);
    }
    @GetMapping("/{id}/tasks")
    @Operation(summary = "Get all user tasks")
    public List<TaskDto> getTasksByUserId(@PathVariable Long id){
        List<Task> tasks = taskService.getAllByUserId(id);
        return taskMapper.toDto(tasks);
    }

    @PostMapping("/{id}/tasks")
    @Operation(summary = "Create User")
    public TaskDto create(@PathVariable Long userId,
                          @Validated(OnCreate.class) @RequestBody TaskDto taskDto){
        Task task = taskMapper.DtoToEntity(taskDto);
        Task createdTask  = taskService.create(task, userId);
        return taskMapper.entityToDto(createdTask);
    }
}
