package br.com.verdebordo.needlework.service

import br.com.verdebordo.needlework.controller.response.SupplierResponse
import br.com.verdebordo.needlework.extension.toResponse
import br.com.verdebordo.needlework.model.Supplier
import br.com.verdebordo.needlework.repository.SupplierRepository
import org.springframework.stereotype.Service

@Service
class SupplierService(
    val supplierRepository: SupplierRepository,
    val userService: UserService
) {
    fun getAll(name: String?): List<SupplierResponse> {
        name?.let { it ->
            return supplierRepository.findByNameContainingIgnoreCase(it)
                .map { it.toResponse() }
        }
        return supplierRepository.findAll()
            .map { it.toResponse() }
            .toList()
    }

    fun getSupplier(id: Int): SupplierResponse =
        getById(id).toResponse()


    fun create(supplier: Supplier) {
        userService.getCustomer(supplier.user?.id ?: 0)
        supplierRepository.save(supplier)
    }

    fun update(id: Int, newData: Supplier) {
        val supplier = getById(id)
        supplier.updateSupplier(newData.name, newData.contact)
        supplierRepository.save(supplier)
    }

    fun delete(id: Int) {
        val supplier = getById(id)
        supplier.delete()
        supplierRepository.save(supplier)
    }

    private fun getById(id: Int): Supplier =
        supplierRepository.findById(id)
            .orElseThrow()
}