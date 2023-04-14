package br.com.verdebordo.needlework.controller

import br.com.verdebordo.needlework.controller.request.PostUserRequest
import br.com.verdebordo.needlework.controller.request.PutUserRequest
import br.com.verdebordo.needlework.model.User
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/users")
class UserController {
    val users = mutableListOf<User>()

    @GetMapping
    fun getAll(@RequestParam name: String?): List<User> {
        name?.let {
            return users.filter {
                it.name.contains(name, true)
            }
        }
        return users
    }

    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id: Int): User {
        return users.first {
            it.id == id
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody user: PostUserRequest) {
        val id = if (users.lastOrNull()?.id == null) 1 else (users.last().id + 1)
        users.add(User(id, user.name, user.email))
        println(user)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @RequestBody customer: PutUserRequest) {
        users.first { it.id == id }.let {
            it.name = customer.name
            it.email = customer.email
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int) {
        users.removeIf {
            it.id == id
        }
    }
}