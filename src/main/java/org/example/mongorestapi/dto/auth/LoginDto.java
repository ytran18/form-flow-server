package org.example.mongorestapi.dto.auth;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoginDto {

    private String email;
    private String password;

}
