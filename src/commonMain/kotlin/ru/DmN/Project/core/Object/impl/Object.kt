package ru.DmN.Project.core.Object.impl

import ru.DmN.Project.core.Object.ObjType
import ru.DmN.Project.core.Object.api.IObject

data class Object(override val name: String, override val type: ObjType) : IObject