package ru.DmN.Project.core.`object`.impl

import ru.DmN.Project.core.`object`.ObjType
import ru.DmN.Project.core.`object`.api.*
import ru.DmN.Project.core.data.api.IES
import ru.DmN.Project.core.data.api.IFMS

data class AObject(
    override val extends: IES<IDPO>,
    override val fields: IFMS<IObject>,
    override val methods: IFMS<IVObject>,
    override val name: String,
    override val type: ObjType
) : IObject, IFMP, IEP, IDPO