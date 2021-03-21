package ru.DmN.Project.core.obj.utils

import ru.DmN.Project.core.obj.IObject

fun List<IObject>.indexOfIO(name: String): Int {
    for (i in this.indices)
        if (this[i].name == name)
            return i
    return -1
}