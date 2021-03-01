package ru.DmN.Project.core.Object.impl

import ru.DmN.Project.core.Object.ObjType
import ru.DmN.Project.core.Object.api.*
import ru.DmN.Project.core.data.api.Object.IES
import ru.DmN.Project.core.data.api.Object.IFMS

data class AVObject(
    override val extends: IES<IDPO>,
    override val fields: IFMS<IObject>,
    override val methods: IFMS<IVObject>,
    override val name: String,
    override val type: ObjType,
    override var value: Any?
) : IVObject, IFMP, IEP