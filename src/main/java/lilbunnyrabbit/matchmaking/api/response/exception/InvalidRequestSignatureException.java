package lilbunnyrabbit.matchmaking.api.response.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED, reason = "Invalid request signature")
public class InvalidRequestSignatureException extends Exception {
}
