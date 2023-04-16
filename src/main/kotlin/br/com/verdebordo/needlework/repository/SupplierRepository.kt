package br.com.verdebordo.needlework.repository

import br.com.verdebordo.needlework.model.Supplier
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface SupplierRepository : JpaRepository<Supplier, Int?> {
    fun findByNameContainingIgnoreCase(pageable: Pageable, name: String): Page<Supplier>
}