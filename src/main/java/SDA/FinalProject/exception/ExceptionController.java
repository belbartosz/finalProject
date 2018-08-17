package SDA.FinalProject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ExceptionMessage handleNotFoundException(NotFoundException e) {
        return new ExceptionMessage(e.getMessage());
    }

    @ExceptionHandler(AlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ExceptionMessage handleAlreadyExistsException(AlreadyExistsException e){
        return new ExceptionMessage(e.getMessage());
    }


    class ExceptionMessage {

        private String message;

        public ExceptionMessage(String message) {
            this.message = message;
        }
    }

}
