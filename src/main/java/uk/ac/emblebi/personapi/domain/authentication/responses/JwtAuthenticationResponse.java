package uk.ac.emblebi.personapi.domain.authentication.responses;

import lombok.Data;

/**
 * TODO: write you class description here
 *
 * @author
 */

@Data
public class JwtAuthenticationResponse {
    private String accessToken;
    private String tokenType = "Bearer";

    public JwtAuthenticationResponse(String accessToken) {
        this.accessToken = accessToken;
    }
}
