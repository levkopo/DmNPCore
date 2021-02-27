package ru.DmN.Project.core.`object`.impl

import ru.DmN.Project.core.`object`.ObjType
import ru.DmN.Project.core.`object`.api.IEP
import ru.DmN.Project.core.`object`.api.IFMP
import ru.DmN.Project.core.`object`.api.IObject
import ru.DmN.Project.core.`object`.api.IVObject
import ru.DmN.Project.core.data.api.IFMS

data class AVObject(
    override val extends: ArrayList<IObject>,
    override val fields: IFMS<IObject>,
    override val methods: IFMS<IVObject>,
    override val name: String,
    override val type: ObjType,
    override var value: Any?
) : IVObject, IFMP, IEP