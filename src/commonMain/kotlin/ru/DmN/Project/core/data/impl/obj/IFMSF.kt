package ru.DmN.Project.core.data.impl.obj

import ru.DmN.Project.core.obj.api.IObject
import ru.DmN.Project.core.obj.utils.cast
import ru.DmN.Project.core.obj.utils.findE

class IFMSF<T : IObject> : IFMSImpl<T>() {
    lateinit var instance: IObject

    override val autoFinding: Boolean
        get() = true

    override fun get(name: String): T? {
        return super.get(name) ?: cast(findE(instance, name))
    }
}