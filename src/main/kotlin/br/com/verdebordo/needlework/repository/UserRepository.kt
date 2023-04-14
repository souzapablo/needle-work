package br.com.verdebordo.needlework.repository

import br.com.verdebordo.needlework.model.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Int?> {
    fun findByNameContainingIgnoreCase(name: String): List<User>
}