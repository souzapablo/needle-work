package br.com.verdebordo.needlework.controller

import br.com.verdebordo.needlework.controller.request.PostUserRequest
import br.com.verdebordo.needlework.controller.request.PutUserRequest
import br.com.verdebordo.needlework.controller.response.UserResponse
import br.com.verdebordo.needlework.extension.toUser
import br.com.verdebordo.needlework.service.UserService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/users")
class UserController(
    val userService: UserService
) {

    @GetMapping
    fun getAll(
        @PageableDefault(page = 0, size = 10) pageable: Pageable,
        @RequestParam name: String?
    ): Page<UserResponse> =
        userService.getAll(pageable, name)

    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id: Int): UserResponse =
        userService.getCustomer(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody request: PostUserRequest) =
        userService.create(request.toUser())


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @RequestBody customer: PutUserRequest) =
        userService.update(id, customer.toUser())


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int) =
        userService.delete(id)
}