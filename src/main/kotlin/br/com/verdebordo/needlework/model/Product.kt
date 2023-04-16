package br.com.verdebordo.needlework.model

import jakarta.persistence.*
import java.math.BigDecimal

@Entity(name = "product")
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    @Column(nullable = false)
    var description: String = "",

    @Column(nullable = false)
    var price: BigDecimal = BigDecimal.ZERO,

    @ManyToOne
    val supplier: Supplier? = null,
) {
    @Column(nullable = false)
    var isActive: Boolean = true
        private set

    fun delete() {
        isActive = !isActive
    }

    fun update(newPrice: BigDecimal?, newDescription: String) {
        newPrice?.let {
            price = it
        }

        if (newDescription.isNotBlank())
            description = newDescription
    }
}