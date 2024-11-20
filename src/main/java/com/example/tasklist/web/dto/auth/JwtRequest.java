package com.example.tasklist.web.dto.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(description = "Request for login")
public class JwtRequest {
    @Schema(description = "email", example = "OlegKulichkov@gmail.com")
    @NotNull(message = "Username must be not null")
    private String username;

    @Schema(description = "password", example = "1234_-qwe")
    @NotNull(message = "Password must be not null")
    private String password;

}
