package br.com.verdebordo.needlework.extension

import br.com.verdebordo.needlework.controller.request.PostUserRequest
import br.com.verdebordo.needlework.controller.request.PutUserRequest
import br.com.verdebordo.needlework.model.User

fun PostUserRequest.toUser(): User {
    return User(name = this.name, email = this.email)
}

fun PutUserRequest.toUser(): User {
    return User(name = this.name, email = this.email)
}
