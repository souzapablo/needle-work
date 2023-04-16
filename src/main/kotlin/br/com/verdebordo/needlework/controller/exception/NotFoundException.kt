package br.com.verdebordo.needlework.controller.exception

class NotFoundException(
    override val message: String,
    val errorCode: String
) : Exception() {
}