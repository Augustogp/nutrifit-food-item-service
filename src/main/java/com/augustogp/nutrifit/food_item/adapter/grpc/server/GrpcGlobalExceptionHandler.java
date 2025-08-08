package com.augustogp.nutrifit.food_item.adapter.grpc.server;

import com.augustogp.nutrifit.food_item.exception.ResourceNotFoundException;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import net.devh.boot.grpc.server.advice.GrpcAdvice;
import net.devh.boot.grpc.server.advice.GrpcExceptionHandler;
import org.springframework.web.bind.MethodArgumentNotValidException;

@GrpcAdvice
public class GrpcGlobalExceptionHandler {

    @GrpcExceptionHandler(ResourceNotFoundException.class)
    public StatusRuntimeException resourceNotFoundException(ResourceNotFoundException e) {

        return io.grpc.Status.NOT_FOUND
                .withDescription(e.getMessage())
                .withCause(e)
                .asRuntimeException();
    }

    @GrpcExceptionHandler(IllegalArgumentException.class)
    public StatusRuntimeException illegalArgumentException(IllegalArgumentException e) {
        return Status.INVALID_ARGUMENT
                .withDescription(e.getMessage())
                .withCause(e)
                .asRuntimeException();
    }

    @GrpcExceptionHandler(MethodArgumentNotValidException.class)
    public StatusRuntimeException methodArgumentNotValidException(MethodArgumentNotValidException e) {
        StringBuilder errorMessage = new StringBuilder("Validation failed: ");
        e.getBindingResult().getFieldErrors().forEach(fieldError ->
            errorMessage.append(fieldError.getField()).append(" - ").append(fieldError.getDefaultMessage()).append("; ")
        );
        return Status.INVALID_ARGUMENT
                .withDescription(errorMessage.toString())
                .withCause(e)
                .asRuntimeException();
    }
}
