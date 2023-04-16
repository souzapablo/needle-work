package br.com.verdebordo.needlework.enum

enum class Errors(
    val code: String,
    val message: String
) {
    NW001("NW-001", "Invalid request"),
    NW101("NW-101", "User [%s] not found"),
    NW201("NW-201", "Supplier [%s] not found"),
    NW301("NW-301", "Product [%s] not found")
}