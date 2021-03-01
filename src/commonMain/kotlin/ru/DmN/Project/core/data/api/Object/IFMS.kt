package ru.DmN.Project.core.data.api.Object

import ru.DmN.Project.core.Object.api.IObject

/**
 * Field Method Storage
 */
interface IFMS<T : IObject> {
    // Fields
    val autoFinding: Boolean
        get() = false
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