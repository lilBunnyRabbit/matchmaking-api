package sixmans.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
@SuppressWarnings("serial")
public class UniversalError extends RuntimeException {

    public UniversalError() {
        super();
    }

    public UniversalError(String message) {
        super(message);
    }
}