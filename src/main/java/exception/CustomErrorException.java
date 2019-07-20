package exception;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class CustomErrorException extends RuntimeException {

    private HttpStatus httpStatus;
    private String message;

    public CustomErrorException(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
