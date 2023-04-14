package br.com.verdebordo.needlework.model

import jakarta.persistence.*

@Entity(name = "user")
data class User(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    @Column(nullable = false)
    var name: String,

    @Column(nullable = false)
    var email: String
) {
    fun updateUser(newName: String, newEmail: String) {
        name = newName
        email = newEmail
    }
}