package com.realestate.userservice.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "userinfo")
class UserInfoEntity {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userinfo_id_generator")
    @SequenceGenerator(name = "userinfo_id_generator", sequenceName = "userinfo_id_seq")
    private Long id;

    @Id
    @NotBlank(message = "User ID is required")
    @Column(name = "user_id", nullable = false, unique = true)
    private String userId;


    @NotBlank(message = "User first name is required")
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
    @Column(nullable = false)
    private String firstName;

    @NotBlank(message = "User last name is required")
    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
    @Column(nullable = false)
    private String lastName;

    @NotBlank(message = "Phone number is required")
    @Pattern(
            regexp = "^[+]?[0-9]{10,15}$",
            message = "Phone number must contain 10 to 15 digits and may start with +"
    )
    @Column(nullable = false)
    private Long phoneNumber;

    @NotBlank(message = "Email address is required")
    @Email(message = "Email address must be a valid format")
    @Column(nullable = false, unique = true)
    private String email;

    @Size(max = 255, message = "Profile picture URL must not exceed 255 characters")
    private String profilePic;

}
