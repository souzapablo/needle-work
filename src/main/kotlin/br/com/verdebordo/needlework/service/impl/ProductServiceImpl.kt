package br.com.verdebordo.needlework.service.impl

import br.com.verdebordo.needlework.controller.exception.NotFoundException
import br.com.verdebordo.needlework.controller.response.ProductResponse
import br.com.verdebordo.needlework.enum.Errors
import br.com.verdebordo.needlework.extension.toResponse
import br.com.verdebordo.needlework.model.Product
import br.com.verdebordo.needlework.repository.ProductRepository
import br.com.verdebordo.needlework.service.ProductService
import br.com.verdebordo.needlework.service.SupplierService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class ProductServiceImpl(
    private val productRepository: ProductRepository,
    private val supplierService: SupplierService
) : ProductService {
    override fun getAll(pageable: Pageable, description: String?): Page<ProductResponse> {
        description?.let { it ->
            return productRepository.findByDescriptionContainingIgnoreCase(pageable, it)
                .map { it.toResponse() }
        }
        return productRepository.findAll(pageable)
            .map { it.toResponse() }
    }

    override fun getById(id: Int): ProductResponse =
        findProduct(id).toResponse()

    override fun create(product: Product) {
        val supplier = supplierService.getSupplier(product.supplier?.id ?: 0)
        productRepository.save(product)
    }

    override fun update(id: Int, newData: Product) {
        val product = findProduct(id)
        product.update(newData.price, newData.description)
        productRepository.save(product)
    }

    override fun delete(id: Int) {
        val product = findProduct(id)
        product.delete()
        productRepository.save(product)
    }

    private fun findProduct(id: Int): Product =
        productRepository.findById(id)
            .orElseThrow {
                NotFoundException(
                    message = Errors.NW301.message.format(id),
                    errorCode = Errors.NW301.code
                )
            }
}