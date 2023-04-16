package br.com.verdebordo.needlework.model

import jakarta.persistence.*

@Entity(name = "user")
data class User(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    @Column(nullable = false)
    var name: String = "",

    @Column(nullable = false, unique = true)
    var email: String = "",

    @Column(nullable = false)
    @OneToMany(
        fetch = FetchType.LAZY,
        cascade = [CascadeType.REMOVE],
        mappedBy = "user"
    )
    var suppliers: List<Supplier> = mutableListOf()

) {
    @Column(nullable = false)
    var isActive: Boolean = true
        private set

    fun delete() {
        isActive = !isActive
    }

    fun updateUser(newName: String, newEmail: String) {
        if (newName.isNotBlank())
            name = newName
        if (newEmail.isNotBlank())
            email = newEmail
    }
}

