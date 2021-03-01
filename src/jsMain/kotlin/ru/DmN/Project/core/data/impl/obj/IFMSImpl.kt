package ru.DmN.Project.core.data.impl.obj

import ru.DmN.Project.core.obj.api.IObject
import ru.DmN.Project.core.obj.utils.cast
import ru.DmN.Project.core.obj.utils.indexOfIO
import ru.DmN.Project.core.data.api.obj.IFMS

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
    override fun set(obj: T, index: Int) { super.set(index, obj) }
    // Removing impl
    override fun remove(name: String): T? {
        val i = this.indexOfIO(name)

        return if (i > -1)
            cast(this.removeAt(i))
        else null
    }
    override fun removeAt(index: Int): T = cast(this.removeAt(index))
}