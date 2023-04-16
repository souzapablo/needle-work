package br.com.verdebordo.needlework.repository

import br.com.verdebordo.needlework.model.Product
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, Int?> {
    fun findByDescriptionContainingIgnoreCase(pageable: Pageable, description: String): Page<Product>
}