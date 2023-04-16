package br.com.verdebordo.needlework.controller.exception

import br.com.verdebordo.needlework.controller.response.ErrorResponse
import br.com.verdebordo.needlework.controller.response.FieldErrorResponse
import br.com.verdebordo.needlework.enum.Errors
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
class ControllerAdvice {
    @ExceptionHandler(NotFoundException::class)
    fun handleNotFoundException(ex: NotFoundException, request: WebRequest): ResponseEntity<ErrorResponse> {
        val error = ErrorResponse(
            httpCode = HttpStatus.NOT_FOUND.value(),
            message = ex.message,
            internalCode = ex.errorCode
        )

        return ResponseEntity(error, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(
        ex: MethodArgumentNotValidException,
        request: WebRequest
    ): ResponseEntity<ErrorResponse> {
        val error = ErrorResponse(
            httpCode = HttpStatus.UNPROCESSABLE_ENTITY.value(),
            message = Errors.NW001.message,
            internalCode = Errors.NW001.code,
            ex.bindingResult.fieldErrors.map {
                FieldErrorResponse(
                    it.defaultMessage ?: "invalid",
                    it.field
                )
            }
        )

        return ResponseEntity(error, HttpStatus.UNPROCESSABLE_ENTITY)
    }
}