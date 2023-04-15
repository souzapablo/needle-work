package br.com.verdebordo.needlework.controller.response

data class UserResponse(
    val id: Int?,
    val name: String,
    val email: String,
    val isActive: Boolean
)