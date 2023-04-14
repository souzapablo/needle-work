package br.com.verdebordo.needlework.service

import br.com.verdebordo.needlework.model.User
import org.springframework.stereotype.Service

@Service
class UserService {
    val users = mutableListOf<User>()

    fun getAll(name: String?): List<User> {
        name?.let {
            return users.filter {
                it.name.contains(name, true)
            }
        }
        return users
    }

    fun getCustomer(id: Int): User {
        return users.first {
            it.id == id
        }
    }

    fun create(user: User) {
        val id = if (users.lastOrNull()?.id == null) 1 else (users.last().id?.let { it + 1 })
        user.id = id
        users.add(user)
        println(user)
    }

    fun update(id: Int, user: User) {
        users.first { it.id == id }.let {
            it.name = user.name
            it.email = user.email
        }
    }

    fun delete(id: Int) {
        users.removeIf {
            it.id == id
        }
    }
}