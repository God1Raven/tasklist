package com.example.tasklist.web.dto.user;

import com.example.tasklist.web.dto.validation.OnCreate;
import com.example.tasklist.web.dto.validation.OnUpdate;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import org.hibernate.mapping.Set;
import org.hibernate.validator.constraints.Length;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Data
public class UserDto {
    @NotNull(message = "Id must ne not null", groups = OnUpdate.class)
    private Long id;

    @NotNull(message = "Name must be not null", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255, message = "Name length must be smaller than 255 symbols", groups = {OnCreate.class, OnUpdate.class})
    private String name;
    @NotNull(message = "Username must be not null", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255, message = "Username length must be smaller than 255 symbols", groups = {OnCreate.class, OnUpdate.class})
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message = "password must be not null", groups = {OnCreate.class, OnUpdate.class})
    private String password;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message = "password confirmation must be not null", groups = {OnCreate.class})
    private String passwordConfirmation;

}
