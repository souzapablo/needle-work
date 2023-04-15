package br.com.verdebordo.needlework.service

import br.com.verdebordo.needlework.controller.response.UserResponse
import br.com.verdebordo.needlework.extension.toResponse
import br.com.verdebordo.needlework.model.User
import br.com.verdebordo.needlework.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    val userRepository: UserRepository
) {
    fun getAll(name: String?): List<UserResponse> {
        name?.let { it ->
            return userRepository.findByNameContainingIgnoreCase(it)
                .map { it.toResponse() }
        }
        return userRepository.findAll()
            .map { it.toResponse() }
            .toList()
    }

    fun getCustomer(id: Int): UserResponse =
        getById(id).toResponse()


    fun create(user: User) =
        userRepository.save(user)

    fun update(id: Int, newData: User) {
        val user = getById(id)
        user.updateUser(newData.name, newData.email)
        userRepository.save(user)
    }

    fun delete(id: Int) {
        val user = getById(id)
        user.delete()
        userRepository.save(user)
    }

    private fun getById(id: Int): User =
        userRepository.findById(id)
            .orElseThrow()
}