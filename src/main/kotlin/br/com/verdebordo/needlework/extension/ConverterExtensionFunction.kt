package br.com.verdebordo.needlework.extension

import br.com.verdebordo.needlework.controller.request.PostUserRequest
import br.com.verdebordo.needlework.controller.request.PutUserRequest
import br.com.verdebordo.needlework.controller.response.UserResponse
import br.com.verdebordo.needlework.model.User

fun PostUserRequest.toUser(): User {
    return User(
        name = this.name,
        email = this.email
    )
}

fun PutUserRequest.toUser(): User {
    return User(
        name = this.name ?: "",
        email = this.email ?: ""
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