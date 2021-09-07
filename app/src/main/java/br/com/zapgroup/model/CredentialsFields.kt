package br.com.zapgroup.model

data class CredentialsFields(
    val password: String,
    val login: String?,
    val description: String?,
    val createdAt: String,
    val lastView: String,
    val updatedAt: String
){
    /*fun getDecodedPassword(): String {
    return crypt.decode(password)
    }

    fun getEncodedPassword(): String {
    return crypt.encode(password)
    }*/

}