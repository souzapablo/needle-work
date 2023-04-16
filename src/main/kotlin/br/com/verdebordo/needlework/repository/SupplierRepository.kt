package br.com.verdebordo.needlework.repository

import br.com.verdebordo.needlework.model.Supplier
import org.springframework.data.jpa.repository.JpaRepository

interface SupplierRepository : JpaRepository<Supplier, Int?> {
    fun findByNameContainingIgnoreCase(name: String): List<Supplier>
}