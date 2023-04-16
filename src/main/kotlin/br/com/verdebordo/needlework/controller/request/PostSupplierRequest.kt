package br.com.verdebordo.needlework.controller.request

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class PostSupplierRequest(
    @field:NotBlank(message = "Name should not be empty")
    val name: String,

    @field:NotBlank(message = "Contact should not be empty")
    val contact: String,

    @field:NotNull(message = "User id should not be empty")
    val userId: Int
)