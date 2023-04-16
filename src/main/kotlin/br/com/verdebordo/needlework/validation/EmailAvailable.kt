package br.com.verdebordo.needlework.validation

import jakarta.validation.Constraint
import jakarta.validation.Payload
import kotlin.reflect.KClass

@Constraint(validatedBy = [EmailAvailableValidator::class])
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
annotation class EmailAvailable(
    val message: String = "E-mail already registered",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)
