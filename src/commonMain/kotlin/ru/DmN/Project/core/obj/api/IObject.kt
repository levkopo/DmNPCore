package ru.DmN.Project.core.obj.api

import ru.DmN.Project.core.obj.ObjType

interface IObject {
    val name: String
    val type: ObjType
}