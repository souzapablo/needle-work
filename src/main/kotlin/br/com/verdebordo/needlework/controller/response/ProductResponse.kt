package br.com.verdebordo.needlework.controller.response

import java.math.BigDecimal

data class ProductResponse(
    val id: Int?,
    val description: String,
    val price: BigDecimal,
    val supplierId: Int?,
    val isActive: Boolean
)
