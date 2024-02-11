package live.groupstudy.gs.repositories

import live.groupstudy.gs.datasources.FirebaseDataSource

class LoginRepository(private val firebaseDataSource: FirebaseDataSource) {
    fun verifyNumber(number: String){
        firebaseDataSource.verifyNumber(number)
    }
}