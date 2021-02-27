package ru.DmN.Project.core.`object`.utils

import ru.DmN.Project.core.`object`.FMType
import ru.DmN.Project.core.`object`.ObjType
import ru.DmN.Project.core.`object`.api.IEP
import ru.DmN.Project.core.`object`.api.IFMP
import ru.DmN.Project.core.`object`.api.IObject
import ru.DmN.Project.core.`object`.api.IVObject
import ru.DmN.Project.core.`object`.impl.VObject

inline fun <T> cast(o: Any?) = o as T

fun find(obj: IObject, name: String, type: FMType = FMType.UNKNOWN): IObject? {
    var result = findWithType(obj, name, type)

    if (result == null)
        result = findEFM(obj, name, type)

    return result
}

fun findWithType(obj: IObject, name: String, type: FMType = FMType.UNKNOWN): IObject? {
    return when (obj.type) {
        ObjType.NULL        -> null
        ObjType.VAL         -> null
        ObjType.VAR         -> null
        ObjType.METHOD      -> null
        ObjType.INTERFACE   -> findEFM(obj, name, type)
        ObjType.CLASS       -> findEFM(obj, name, type)
        ObjType.OBJECT      -> findEFM(obj, name, type)
        ObjType.REFERENCE   -> findWithType((obj as IVObject).value as IObject, name, type)
        ObjType.PACKAGE     -> {
            for (e in cast<ArrayList<IObject>>((obj as VObject).value))
                if (e.name == name)
                    return e
            return null
        }
    }
}

fun findEFM(obj: IObject, name: String, type: FMType = FMType.UNKNOWN): IObject? {
    var result: IObject? = null

    if (obj is IFMP)
        result = findFM(obj, name, type)

    if (result == null && obj is IEP)
        result = findE(obj, name, type)

    return result
}

fun findFM(obj: IObject, name: String, type: FMType = FMType.UNKNOWN): IObject? {
    if (type == FMType.UNKNOWN || type == FMType.FIELD) {
        val arr = (obj as IFMP).fields
        for (i in 0 until arr.size) {
            if (arr[i].name == name)
                return arr[i]
        }
    }

    if (type == FMType.UNKNOWN || type == FMType.METHOD) {
        val arr = (obj as IFMP).methods
        for (i in 0 until arr.size) {
            if (arr[i].name == name)
                return arr[i]
        }
    }


    return null
}

fun findE(obj: IObject, name: String, type: FMType = FMType.UNKNOWN): IObject? {
    for (e in (obj as IEP).extends) {
        val result = findEFM(e, name, type)

        if (result != null)
            return result
    }

    return null
}