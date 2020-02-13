package uk.ac.emblebi.personapi.domain.authentication.requests;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * TODO: write you class description here
 *
 * @author
 */

@Data
public class LoginRequest {
    @NotBlank
    private String usernameOrEmail;

    @NotBlank
    private String password;
}