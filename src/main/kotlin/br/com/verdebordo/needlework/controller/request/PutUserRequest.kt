package br.com.verdebordo.needlework.controller.request

data class PutUserRequest(
    val newName: String?,
    val newEmail: String?
)