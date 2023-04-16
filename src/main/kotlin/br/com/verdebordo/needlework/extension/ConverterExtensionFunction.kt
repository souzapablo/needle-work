package br.com.verdebordo.needlework.extension

import br.com.verdebordo.needlework.controller.request.PostSupplierRequest
import br.com.verdebordo.needlework.controller.request.PostUserRequest
import br.com.verdebordo.needlework.controller.request.PutSupplierRequest
import br.com.verdebordo.needlework.controller.request.PutUserRequest
import br.com.verdebordo.needlework.controller.response.SupplierResponse
import br.com.verdebordo.needlework.controller.response.UserResponse
import br.com.verdebordo.needlework.model.Supplier
import br.com.verdebordo.needlework.model.User

fun PostUserRequest.toUser(): User {
    return User(
        name = this.name,
        email = this.email
    )
}

fun PutUserRequest.toUser(): User {
    return User(
        name = this.newName ?: "",
        email = this.newEmail ?: ""
    )
}

fun User.toResponse(): UserResponse {
    return UserResponse(
        id = this.id,
        name = this.name,
        email = this.email,
        isActive = this.isActive
    )
}

fun Supplier.toResponse(): SupplierResponse =
    SupplierResponse(
        id = this.id,
        name = this.name,
        userId = this.user?.id,
        isActive = this.isActive
    )

fun PostSupplierRequest.toSupplier(): Supplier =
    Supplier(
        name = this.name,
        contact = this.contact,
        user = User(id = this.userId)
    )

fun PutSupplierRequest.toSupplier(): Supplier =
    Supplier(
        name = this.newName ?: "",
        contact = this.newContact ?: ""
    )
