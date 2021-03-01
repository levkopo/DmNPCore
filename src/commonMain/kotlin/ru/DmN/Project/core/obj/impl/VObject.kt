package ru.DmN.Project.core.obj.impl

import ru.DmN.Project.core.obj.ObjType
import ru.DmN.Project.core.obj.api.IVObject

data class VObject(override val name: String, override val type: ObjType, override var value: Any?) : IVObject