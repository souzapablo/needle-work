package br.com.verdebordo.needlework.controller.request

import java.math.BigDecimal

data class PostProductRequest(
    val description: String,
    val price: BigDecimal,
    val supplierId: Int
)