package ru.DmN.Project.core.data.impl.obj

import ru.DmN.Project.core.obj.api.IObject
import ru.DmN.Project.core.obj.utils.cast
import ru.DmN.Project.core.obj.utils.indexOfIO
import ru.DmN.Project.core.data.api.obj.IFMS
import java.util.ArrayList

actual open class IFMSImpl<T : IObject> : IFMS<T> {
    private val instance = ArrayList<T>()

    // Fields impl
    override val size: Int
        get() = instance.size
    // Adding impl
    override fun add(obj: T) { instance.add(obj) }
    // Getting impl
    override fun get(name: String): T? = cast(instance.find { o -> o.name == name })
    override fun get(index: Int): T = cast(instance[index])
    // Setting impl
    override fun set(obj: T, name: String) { instance[instance.indexOfIO(name)] = obj }
    override fun set(obj: T, index: Int) { instance[index] = obj }
    // Removing impl
    override fun remove(name: String): T? {
        val i = instance.indexOfIO(name)

        return if (i > -1)
            cast(this.removeAt(i))
        else null
    }
    override fun removeAt(index: Int): T = cast(this.removeAt(index))
}