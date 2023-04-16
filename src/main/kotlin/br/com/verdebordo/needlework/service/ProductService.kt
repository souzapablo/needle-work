package br.com.verdebordo.needlework.service

import br.com.verdebordo.needlework.controller.response.ProductResponse
import br.com.verdebordo.needlework.model.Product
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface ProductService {
    fun getAll(pageable: Pageable, description: String?): Page<ProductResponse>
    fun getById(id: Int): ProductResponse
    fun create(product: Product)
    fun update(id: Int, newData: Product)
    fun delete(id: Int)
}