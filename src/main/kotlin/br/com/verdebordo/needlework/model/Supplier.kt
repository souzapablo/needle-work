package br.com.verdebordo.needlework.model

import jakarta.persistence.*

@Entity(name = "supplier")
data class Supplier(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    @Column(nullable = false)
    var name: String = "",

    @Column(nullable = false)
    var contact: String = "",

    @ManyToOne
    var user: User? = null
) {
    @Column(nullable = false)
    var isActive: Boolean = true
        private set

    fun delete() {
        isActive = !isActive
    }

    fun updateSupplier(newName: String, newContact: String) {
        if (newName.isNotBlank())
            name = newName

        if (newContact.isNotBlank())
            contact = newContact
    }
}