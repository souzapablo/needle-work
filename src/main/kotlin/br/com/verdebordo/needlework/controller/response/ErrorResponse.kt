package br.com.verdebordo.needlework.controller.response

data class ErrorResponse(
    val httpCode: Int,
    val message: String,
    val internalCode: String,
    val errors: List<FieldErrorResponse>? = null
)