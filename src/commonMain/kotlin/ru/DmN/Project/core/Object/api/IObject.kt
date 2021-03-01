package ru.DmN.Project.core.Object.api

import ru.DmN.Project.core.Object.ObjType

interface IObject {
    val name: String
    val type: ObjType
}