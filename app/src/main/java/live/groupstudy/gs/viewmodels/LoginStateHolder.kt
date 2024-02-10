package live.groupstudy.gs.viewmodels

import androidx.lifecycle.ViewModel

interface LoginStateHolder{


    fun generateOtp(number: String)

    fun validateOtp(otp: String)


}