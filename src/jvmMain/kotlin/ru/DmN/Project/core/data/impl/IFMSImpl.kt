package ru.DmN.Project.core.data.impl

import ru.DmN.Project.core.`object`.api.IObject
import ru.DmN.Project.core.`object`.utils.cast
import ru.DmN.Project.core.`object`.utils.indexOfIO
import ru.DmN.Project.core.data.api.IFMS
import java.util.ArrayList

actual class IFMSImpl<T : IObject> : ArrayList<IObject>(), IFMS<T> {
    // Fields impl
    override val size: Int
        get() = super.size
    // Adding impl
    override fun add(obj: T) { super.add(obj) }
    // Getting impl
    override fun get(name: String): T? = cast(this.find { o -> o.name == name })
    override fun get(index: Int): T = cast(super.get(index))
    // Setting impl
    override fun set(obj: T, name: String) { this[this.indexOfIO(name)] = obj }
    override fun set(obj: T, index: Int) { this[index] = obj }
}