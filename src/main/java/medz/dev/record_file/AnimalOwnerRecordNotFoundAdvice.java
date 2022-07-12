package record_file;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AnimalOwnerRecordNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(AnimalOwnerRecordNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String ownerNotFoundHandler(AnimalOwnerRecordNotFoundException exception){
        return exception.getMessage();
    }
}
