package ru.DmN.Project.core.obj.utils

import ru.DmN.Project.core.obj.FMObjType
import ru.DmN.Project.core.obj.ObjType
import ru.DmN.Project.core.obj.api.IEP
import ru.DmN.Project.core.obj.api.IFMP
import ru.DmN.Project.core.obj.api.IObject
import ru.DmN.Project.core.obj.api.IVObject
import ru.DmN.Project.core.obj.impl.VObject

inline fun <T> cast(o: Any?) = o as T

inline fun find(obj: IObject, name: String): IObject? {
    var result = findWithType(obj, name)

    if (result == null)
        result = findEFM(obj, name)

    return result
}

fun findWithType(obj: IObject, name: String): IObject? {
    val type = obj.type

    return if (type is FMObjType) {
        findEFM(obj, name)
    } else {
        when (type) {
            ObjType.REFERENCE -> findWithType((obj as IVObject).value as IObject, name)
            ObjType.PACKAGE -> {
                for (e in cast<ArrayList<IObject>>((obj as VObject).value))
                    if (e.name == name)
                        return e
                null
            }
            else -> null
        }
    }
}

fun findEFM(obj: IObject, name: String): IObject? {
    var result: IObject? = null

    if (obj is IFMP)
        result = findFM(obj, name)

    if (result == null && obj is IEP)
        result = findE(obj, name)

    return result
}

fun findFM(obj: IObject, name: String): IObject? {
    val f = (obj as IFMP).fields

    if (f.autoFinding)
        return obj.fields[name]

    for (i in 0 until f.size) {
        if (f[i].name == name)
            return f[i]
    }

    val m = (obj as IFMP).methods

    if (m.autoFinding)
        return m[name]

    for (i in 0 until m.size) {
        if (m[i].name == name)
            return m[i]
    }

    return null
}

fun findE(obj: IObject, name: String): IObject? {
    for (e in (obj as IEP).extends) {
        val result = findEFM(e, name)

        if (result != null)
            return result
    }

    return null
}