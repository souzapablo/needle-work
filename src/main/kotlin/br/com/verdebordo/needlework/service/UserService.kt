package br.com.verdebordo.needlework.service

import br.com.verdebordo.needlework.controller.response.UserResponse
import br.com.verdebordo.needlework.model.User
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface UserService {
    fun getAll(pageable: Pageable, name: String?): Page<UserResponse>
    fun getUser(id: Int): UserResponse
    fun create(user: User)
    fun update(id: Int, newData: User)
    fun delete(id: Int)
    fun isEmailAvailable(email: String): Boolean
}