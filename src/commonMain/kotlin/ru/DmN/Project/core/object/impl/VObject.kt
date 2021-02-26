package ru.DmN.Project.core.`object`.impl

import ru.DmN.Project.core.`object`.ObjType
import ru.DmN.Project.core.`object`.api.IVObject

data class VObject(override val name: String, override val type: ObjType, override var value: Any?) : IVObject