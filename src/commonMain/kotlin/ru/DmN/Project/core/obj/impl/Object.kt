package ru.DmN.Project.core.obj.impl

import ru.DmN.Project.core.obj.ObjType
import ru.DmN.Project.core.obj.api.IObject

data class Object(override val name: String, override val type: ObjType) : IObject