package br.com.verdebordo.needlework.service

import br.com.verdebordo.needlework.model.User
import br.com.verdebordo.needlework.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    val userRepository: UserRepository
) {
    fun getAll(name: String?): List<User> {
        name?.let {
            return userRepository.findByNameContainingIgnoreCase(it)
        }
        return userRepository.findAll()
            .toList()
    }

    fun getCustomer(id: Int): User {
        return userRepository.findById(id)
            .orElseThrow()
    }

    fun create(user: User) {
        userRepository.save(user)
    }

    fun update(id: Int, newData: User) {
        val user = getCustomer(id)
        user.updateUser(newData.name, newData.email)
        userRepository.save(user)
    }

    fun delete(id: Int) {
        val user = getCustomer(id)
        userRepository.delete(user)
    }
}