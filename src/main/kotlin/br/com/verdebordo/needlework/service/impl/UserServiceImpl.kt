package br.com.verdebordo.needlework.service.impl

import br.com.verdebordo.needlework.controller.exception.NotFoundException
import br.com.verdebordo.needlework.controller.response.UserResponse
import br.com.verdebordo.needlework.enum.Errors
import br.com.verdebordo.needlework.extension.toResponse
import br.com.verdebordo.needlework.model.User
import br.com.verdebordo.needlework.repository.UserRepository
import br.com.verdebordo.needlework.service.UserService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    val userRepository: UserRepository
) : UserService {
    override fun getAll(pageable: Pageable, name: String?): Page<UserResponse> {
        name?.let { it ->
            return userRepository.findByNameContainingIgnoreCase(pageable, it)
                .map { it.toResponse() }
        }
        return userRepository.findAll(pageable)
            .map { it.toResponse() }
    }

    override fun getUser(id: Int): UserResponse =
        getById(id).toResponse()

    override fun create(user: User) {
        userRepository.save(user)
    }

    override fun update(id: Int, newData: User) {
        val user = getById(id)
        user.updateUser(newData.name, newData.email)
        userRepository.save(user)
    }

    override fun delete(id: Int) {
        val user = getById(id)
        user.delete()
        userRepository.save(user)
    }

    override fun isEmailAvailable(email: String): Boolean =
        !userRepository.existsByEmail(email)

    private fun getById(id: Int): User =
        userRepository.findById(id)
            .orElseThrow {
                NotFoundException(
                    Errors.NW101.message.format(id),
                    Errors.NW101.code
                )
            }

}