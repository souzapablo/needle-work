package br.com.verdebordo.needlework.controller

import br.com.verdebordo.needlework.controller.request.PostProductRequest
import br.com.verdebordo.needlework.controller.request.PutProductRequest
import br.com.verdebordo.needlework.controller.response.ProductResponse
import br.com.verdebordo.needlework.extension.toProduct
import br.com.verdebordo.needlework.service.ProductService
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

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

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int): ProductResponse =
        productService.getById(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody @Valid request: PostProductRequest) =
        productService.create(request.toProduct())

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @RequestBody request: PutProductRequest) =
        productService.update(id, request.toProduct())

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int) =
        productService.delete(id)
}