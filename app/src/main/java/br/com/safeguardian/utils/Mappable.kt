package br.com.safeguardian.utils


interface Mappable<out T> {

    fun map(): T

}
