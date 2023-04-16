package br.com.verdebordo.needlework.controller

import br.com.verdebordo.needlework.controller.response.ProductResponse
import br.com.verdebordo.needlework.service.ProductService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/products")
class ProductController(
    val productService: ProductService
) {
    @GetMapping
    fun getAll(
        @PageableDefault(page = 0, size = 10) pageable: Pageable,
        @RequestParam description: String?
    ): Page<ProductResponse> =
        productService.getAll(pageable, description)

}