package br.com.verdebordo.needlework.validation

import br.com.verdebordo.needlework.service.UserService
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

class EmailAvailableValidator(
    private val userService: UserService
) : ConstraintValidator<EmailAvailable, String> {
    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        if(value.isNullOrEmpty())
            return false

        return userService.isEmailAvailable(value)
    }

}
