package br.com.verdebordo.needlework.controller

import br.com.verdebordo.needlework.controller.request.PostSupplierRequest
import br.com.verdebordo.needlework.controller.request.PutSupplierRequest
import br.com.verdebordo.needlework.controller.response.SupplierResponse
import br.com.verdebordo.needlework.extension.toSupplier
import br.com.verdebordo.needlework.service.SupplierService
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/suppliers")
class SupplierController(
    val supplierService: SupplierService
) {
    @GetMapping
    fun getAll(
        @PageableDefault(page = 0, size = 10) pageable: Pageable,
        @RequestParam name: String?
    ): Page<SupplierResponse> =
        supplierService.getAll(pageable, name)

    @GetMapping("/{id}")
    fun getSupplier(@PathVariable id: Int): SupplierResponse =
        supplierService.getSupplier(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@Valid @RequestBody request: PostSupplierRequest) =
        supplierService.create(request.toSupplier())

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @RequestBody request: PutSupplierRequest) =
        supplierService.update(id, request.toSupplier())


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int) =
        supplierService.delete(id)
}