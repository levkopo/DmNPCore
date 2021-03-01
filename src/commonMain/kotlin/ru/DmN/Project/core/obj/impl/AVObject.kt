package ru.DmN.Project.core.obj.impl

import ru.DmN.Project.core.obj.ObjType
import ru.DmN.Project.core.obj.api.*
import ru.DmN.Project.core.data.api.obj.IES
import ru.DmN.Project.core.data.api.obj.IFMS

data class AVObject(
    override val extends: IES<IDPO>,
    override val fields: IFMS<IObject>,
    override val methods: IFMS<IVObject>,
    override val name: String,
    override val type: ObjType,
    override var value: Any?
) : IVObject, IFMP, IEP