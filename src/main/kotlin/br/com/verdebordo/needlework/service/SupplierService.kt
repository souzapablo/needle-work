package br.com.verdebordo.needlework.service

import br.com.verdebordo.needlework.controller.response.SupplierResponse
import br.com.verdebordo.needlework.model.Supplier
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface SupplierService {
    fun getAll(pageable: Pageable, name: String?): Page<SupplierResponse>
    fun getSupplier(id: Int): SupplierResponse
    fun create(supplier: Supplier)
    fun update(id: Int, newData: Supplier)
    fun delete(id: Int)
}