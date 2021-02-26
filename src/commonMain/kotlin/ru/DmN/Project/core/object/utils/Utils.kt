package ru.DmN.Project.core.`object`.utils

import ru.DmN.Project.core.`object`.ObjType
import ru.DmN.Project.core.`object`.api.IES
import ru.DmN.Project.core.`object`.api.IFMS
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
        ObjType.REFERENCE   -> findWithType((obj as IVObject).value as IObject, name)
        ObjType.METHOD      -> null
        ObjType.INTERFACE   -> findEFM(obj, name)
        ObjType.CLASS       -> findEFM(obj, name)
        ObjType.OBJECT      -> findEFM(obj, name)
        ObjType.PACKAGE     -> {
            for (e in cast<ArrayList<IObject>>((obj as VObject).value))
                if (e.name == name)
                    return e
            return null
        }
    }
}

fun findEFM(obj: IObject, name: String, type: FMType = FMType.UNKNOWN): IObject? {
    var result = findFM(obj, name, type)

    if (result == null)
        result = findE(obj, name, type)

    return result
}

enum class FMType {
    FIELD,
    METHOD,
    UNKNOWN
}

fun findFM(obj: IObject, name: String, type: FMType = FMType.UNKNOWN): IObject? {
    if (obj is IFMS) {
        if (type == FMType.UNKNOWN || type == FMType.FIELD)
            for (e in obj.fields) {
                if (e.name == name)
                    return e
            }

        if (type == FMType.UNKNOWN || type == FMType.METHOD)
            for (e in obj.methods) {
                if (e.name == name)
                    return e
            }
    }

    return null
}

fun findE(obj: IObject, name: String, type: FMType = FMType.UNKNOWN): IObject? {
    if (obj is IES) {
        for (e in obj.extends) {
            val result = findEFM(e, name, type)

            if (result != null)
                return result
        }
    }

    return null
}