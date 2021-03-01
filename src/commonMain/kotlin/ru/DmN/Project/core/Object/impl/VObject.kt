package ru.DmN.Project.core.Object.impl

import ru.DmN.Project.core.Object.ObjType
import ru.DmN.Project.core.Object.api.IVObject

data class VObject(override val name: String, override val type: ObjType, override var value: Any?) : IVObject