package com.example.tasklist.web.dto.user;

import com.example.tasklist.web.dto.validation.OnCreate;
import com.example.tasklist.web.dto.validation.OnUpdate;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import org.hibernate.mapping.Set;
import org.hibernate.validator.constraints.Length;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Data
@Schema(description = "User Dto")
public class UserDto {
    @NotNull(message = "Id must ne not null", groups = OnUpdate.class)
    @Schema(description = "User id", example = "1")
    private Long id;

    @NotNull(message = "Name must be not null", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255, message = "Name length must be smaller than 255 symbols", groups = {OnCreate.class, OnUpdate.class})
    @Schema(description = "User name", example = "Oleg Kulichko")
    private String name;
    @NotNull(message = "Username must be not null", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255, message = "Username length must be smaller than 255 symbols", groups = {OnCreate.class, OnUpdate.class})
    @Schema(description = "User email", example = "OlegKulichko@gmail.com")
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message = "password must be not null", groups = {OnCreate.class, OnUpdate.class})
    @Schema(description = "User password", example = "123_4-qwe")
    private String password;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message = "password confirmation must be not null", groups = {OnCreate.class})
    @Schema(description = "User password confirmation", example = "123_4-qwe")
    private String passwordConfirmation;
}
