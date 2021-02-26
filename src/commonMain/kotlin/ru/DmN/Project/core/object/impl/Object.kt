package ru.DmN.Project.core.`object`.impl

import ru.DmN.Project.core.`object`.ObjType
import ru.DmN.Project.core.`object`.api.IObject

data class Object(override val name: String, override val type: ObjType) : IObject