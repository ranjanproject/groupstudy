package live.groupstudy.gs.datasources

import android.content.Context
import android.util.Log
import com.google.firebase.FirebaseException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import live.groupstudy.gs.activities.login.LoginActivity
import java.util.concurrent.TimeUnit

class FirebaseDataSource: PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

    fun verifyNumber(phoneNumber: String){
        val options = PhoneAuthOptions.newBuilder(Firebase.auth)
            .setPhoneNumber("+91$phoneNumber") // Phone number to verify
            .setTimeout(30L, TimeUnit.SECONDS) // Timeout and unit
            .setCallbacks(this) // OnVerificationStateChangedCallbacks
            .build()

        PhoneAuthProvider.verifyPhoneNumber(options)

    }

    override fun onCodeAutoRetrievalTimeOut(p0: String) {
        super.onCodeAutoRetrievalTimeOut(p0)
        Log.d(LoginActivity.TAG, p0)
    }

    override fun onCodeSent(p0: String, p1: PhoneAuthProvider.ForceResendingToken) {
        super.onCodeSent(p0, p1)
        Log.d(LoginActivity.TAG,"$p0 $p1")

    }

    override fun onVerificationCompleted(p0: PhoneAuthCredential) {

        Log.d(LoginActivity.TAG,p0.toString())
    }

    override fun onVerificationFailed(p0: FirebaseException) {
        Log.d(LoginActivity.TAG,p0.toString())
    }


}