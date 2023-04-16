package br.com.verdebordo.needlework.service.impl

import br.com.verdebordo.needlework.controller.response.ProductResponse
import br.com.verdebordo.needlework.extension.toResponse
import br.com.verdebordo.needlework.repository.ProductRepository
import br.com.verdebordo.needlework.service.ProductService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class ProductServiceImpl(private val productRepository: ProductRepository) : ProductService {
    override fun getAll(pageable: Pageable, description: String?): Page<ProductResponse> {
        description?.let { it ->
            return productRepository.findByDescriptionContainingIgnoreCase(pageable, it)
                .map { it.toResponse() }
        }
        return productRepository.findAll(pageable)
            .map { it.toResponse() }
    }
}