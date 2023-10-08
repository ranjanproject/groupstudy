package live.groupstudy.gs.viewmodels

import androidx.lifecycle.ViewModel
import live.groupstudy.gs.repositories.LoginRepository

class LoginViewModel(private val loginRepository: LoginRepository): ViewModel(), LoginStateHolder {

    override fun generateOtp(number: String) {
        loginRepository.verifyNumber(number)
    }

    override fun validateOtp(otp: String) {
        TODO("Not yet implemented")
    }
}