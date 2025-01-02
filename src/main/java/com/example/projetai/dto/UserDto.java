package com.example.projetai.dto;

import com.example.projetai.enums.UserRole;
import lombok.Data;

@Data
public class UserDto {

    private Long id;

    private String email;
    private String name ;
    private UserRole role ;
<<<<<<< HEAD
    private String customerStripeId;

=======
    private String img ;
>>>>>>> fae35d52357a437167af54e80b8e5a4b7968a041

}
