package br.com.verdebordo.needlework.controller.request

data class PostSupplierRequest(
    val name: String,
    val contact: String,
    val userId: Int
)