package ru.DmN.Project.core.data.impl.Object

import ru.DmN.Project.core.Object.api.IDPO
import ru.DmN.Project.core.Object.utils.cast
import ru.DmN.Project.core.Object.utils.indexOfIO
import ru.DmN.Project.core.data.api.Object.IES

actual class IESImpl<T : IDPO> : IES<T> {
    private val instance = ArrayList<T>()

    // Fields impl
    override val size: Int
        get() = instance.size
    // Adding impl
    override fun add(obj: T) { instance.add(obj) }
    // Getting impl
    override fun get(name: String): T? = cast(instance.find { o -> o.name == name })
    override fun get(index: Int): T = cast(instance.get(index))
    // Setting impl
    override fun set(obj: T, name: String) { instance[instance.indexOfIO(name)] = obj }
    override fun set(obj: T, index: Int) { instance[index] = obj }
    // Removing impl
    override fun remove(name: String): T? {
        val i = instance.indexOfIO(name)

        return if (i > -1)
            cast(instance.removeAt(i))
        else null
    }
    override fun removeAt(index: Int): T = cast(instance.removeAt(index))
    // Iterator impl
    override fun iterator(): Iterator<T> = object : Iterator<T> {
        var i = 0

        override fun hasNext(): Boolean = i < instance.size
        override fun next(): T = instance[i++]
    }
}