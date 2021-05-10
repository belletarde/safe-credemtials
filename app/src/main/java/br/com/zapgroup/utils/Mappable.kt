package br.com.zapgroup.utils


interface Mappable<out T> {

    fun map(): T

}
