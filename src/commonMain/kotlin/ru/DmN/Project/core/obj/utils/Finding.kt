package ru.DmN.Project.core.obj.utils

import ru.DmN.Project.core.obj.FMObjType
import ru.DmN.Project.core.obj.ObjType
import ru.DmN.Project.core.obj.api.IEP
import ru.DmN.Project.core.obj.api.IFMP
import ru.DmN.Project.core.obj.api.IObject
import ru.DmN.Project.core.obj.api.IVObject
import ru.DmN.Project.core.obj.impl.VObject

inline fun <T> cast(o: Any?) = o as T

fun find(obj: IObject, name: String): IObject? = findWithType(obj, name) ?: findEFM(obj, name)
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
    return if (obj is IFMP)
        findFM(obj, name) ?: findE(obj, name)
    else if (obj is IEP)
        findE(obj, name)
    else null
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