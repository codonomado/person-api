package uk.ac.emblebi.personapi.domain.common.advicers;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * TODO: write you class description here
 *
 * @author
 */

@Data
public class ApiError {
    private Date date = new Date();
    private HttpStatus status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;

    private String message;
    private String debugMessage;

    private ApiError() {
        this.timestamp = LocalDateTime.now();
    }

    public ApiError(HttpStatus status, String message, Throwable ex) {
        this();
        this.status = status;
        this.message = message;
        this.debugMessage = ex.getLocalizedMessage();
    }


    public ApiError(Date date, String message, String ex) {
        this();
        this.date = date;
        this.message = message;
        this.debugMessage = ex;
    }

}
