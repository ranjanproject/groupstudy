package live.groupstudy.gs.activities.login

enum class LoginScreen(val routeName: String) {
    GetNumber("GetNumber"),
    VerifyOTP("VerifyOTP/{${LoginActivity.PHONE_NUMBER}}")
}