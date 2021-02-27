package ru.DmN.Project.core.data.api

import ru.DmN.Project.core.`object`.api.IObject

/**
 * Field Method Storage
 */
interface IFMS<T : IObject> {
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
}