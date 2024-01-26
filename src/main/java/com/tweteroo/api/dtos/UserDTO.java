package com.tweteroo.api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class UserDTO {
    
    private static final String URL_REGEX = "^https?://\\S+$";

    @NotBlank(message="Avatar cannot be empty")
    @Pattern(regexp=URL_REGEX, message="Invalid URL")
    private String avatar;

    @NotBlank(message="Username cannot be empty")
    @Size(max = 100, message = "Maximum length for name is 100 characters")
    private String username;

}
