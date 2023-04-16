package br.com.verdebordo.needlework.repository

import br.com.verdebordo.needlework.model.User
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Int?> {
    fun findByNameContainingIgnoreCase(pageable: Pageable, name: String): Page<User>
}