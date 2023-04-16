package br.com.verdebordo.needlework.service

import br.com.verdebordo.needlework.controller.response.ProductResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface ProductService {
    fun getAll(pageable: Pageable, description: String?): Page<ProductResponse>
}