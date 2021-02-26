package ru.DmN.Project.core.`object`.impl

import ru.DmN.Project.core.`object`.ObjType
import ru.DmN.Project.core.`object`.api.IES
import ru.DmN.Project.core.`object`.api.IFMS
import ru.DmN.Project.core.`object`.api.IObject
import ru.DmN.Project.core.`object`.api.IVObject

data class AObject(
    override val extends: ArrayList<IObject>,
    override val fields: ArrayList<IObject>,
    override val methods: ArrayList<IVObject>,
    override val name: String,
    override val type: ObjType
) : IObject, IFMS, IES