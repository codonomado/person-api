package uk.ac.emblebi.personapi.domain.authentication.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * TODO: write you class description here
 *
 * @author
 */

@Data
@AllArgsConstructor
public class ApiResponse {
    private Boolean success;
    private String message;
}
