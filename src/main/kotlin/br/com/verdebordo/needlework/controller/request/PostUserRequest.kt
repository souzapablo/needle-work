package br.com.verdebordo.needlework.controller.request

import br.com.verdebordo.needlework.validation.EmailAvailable
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank

data class PostUserRequest(
    @field:NotBlank(message = "Name should not be empty")
    val name: String,

    @field:Email(message = "Invalid e-mail")
    @EmailAvailable
    val email: String
)