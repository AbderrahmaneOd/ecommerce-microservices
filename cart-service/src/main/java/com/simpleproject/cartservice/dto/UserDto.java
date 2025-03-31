package com.simpleproject.cartservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@AllArgsConstructor
@Builder
//@Data
public class UserDto {
    @Id
    private String id;
    private String email;
    private String username;

    public String getId() {
        return id;
    }
}
