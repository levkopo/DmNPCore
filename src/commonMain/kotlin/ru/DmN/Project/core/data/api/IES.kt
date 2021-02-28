package ru.DmN.Project.core.data.api

import ru.DmN.Project.core.`object`.api.IDPO

/**
 * Extends Storage
 */
interface IES<T : IDPO> : Iterable<T> {
    // Fields
    val size: Int
    // Adding
    fun add(obj: T)
    // Getting
    operator fun get(name: String): T?
    operator fun get(index: Int): T
    // Setting
    operator fun set(obj: T, name: String)
    operator fun set(obj: T, index: Int)
    // Removing
    fun remove(name: String): T?
    fun removeAt(index: Int): T
}