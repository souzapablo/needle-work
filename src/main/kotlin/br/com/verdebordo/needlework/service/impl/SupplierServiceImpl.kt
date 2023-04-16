package br.com.verdebordo.needlework.service.impl

import br.com.verdebordo.needlework.controller.exception.NotFoundException
import br.com.verdebordo.needlework.controller.response.SupplierResponse
import br.com.verdebordo.needlework.enum.Errors
import br.com.verdebordo.needlework.extension.toResponse
import br.com.verdebordo.needlework.model.Supplier
import br.com.verdebordo.needlework.repository.SupplierRepository
import br.com.verdebordo.needlework.service.SupplierService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class SupplierServiceImpl(
    val supplierRepository: SupplierRepository,
    val userService: UserServiceImpl
) : SupplierService {
    override fun getAll(pageable: Pageable, name: String?): Page<SupplierResponse> {
        name?.let { it ->
            return supplierRepository.findByNameContainingIgnoreCase(pageable, it)
                .map { it.toResponse() }
        }
        return supplierRepository.findAll(pageable)
            .map { it.toResponse() }
    }

    override fun getSupplier(id: Int): SupplierResponse =
        getById(id).toResponse()


    override fun create(supplier: Supplier) {
        userService.getUser(supplier.user?.id ?: 0)
        supplierRepository.save(supplier)
    }

    override fun update(id: Int, newData: Supplier) {
        val supplier = getById(id)
        supplier.updateSupplier(newData.name, newData.contact)
        supplierRepository.save(supplier)
    }

    override fun delete(id: Int) {
        val supplier = getById(id)
        supplier.delete()
        supplierRepository.save(supplier)
    }

    private fun getById(id: Int): Supplier =
        supplierRepository.findById(id)
            .orElseThrow {
                NotFoundException(
                    Errors.NW201.message.format(id),
                    Errors.NW201.code
                )
            }
}