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
    return when (obj) {
        is IFMP -> findFM(obj, name) ?: findE(obj, name)
        is IEP -> findE(obj, name)
        else -> null
    }
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

fun findField(obj: IObject, name: String): IObject? = findFieldWithType(obj, name) ?: findFieldEFM(obj, name)
fun findFieldWithType(obj: IObject, name: String): IObject? {
    val type = obj.type

    return if (type is FMObjType) {
        findFieldEFM(obj, name)
    } else {
        when (type) {
            ObjType.REFERENCE -> findFieldWithType((obj as IVObject).value as IObject, name)
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

fun findFieldEFM(obj: IObject, name: String): IObject? {
    return when (obj) {
        is IFMP -> findFieldFM(obj, name) ?: findFieldE(obj, name)
        is IEP -> findFieldE(obj, name)
        else -> null
    }
}

fun findFieldFM(obj: IObject, name: String): IObject? {
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

fun findFieldE(obj: IObject, name: String): IObject? {
    for (e in (obj as IEP).extends) {
        val result = findFieldEFM(e, name)

        if (result != null)
            return result
    }

    return null
}

fun findMethod(obj: IObject, name: String): IObject? = findMethodWithType(obj, name) ?: findMethodEFM(obj, name)
fun findMethodWithType(obj: IObject, name: String): IObject? {
    val type = obj.type

    return if (type is FMObjType) {
        findMethodEFM(obj, name)
    } else {
        when (type) {
            ObjType.REFERENCE -> findMethodWithType((obj as IVObject).value as IObject, name)
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

fun findMethodEFM(obj: IObject, name: String): IObject? {
    return when (obj) {
        is IFMP -> findMethodFM(obj, name) ?: findMethodE(obj, name)
        is IEP -> findMethodE(obj, name)
        else -> null
    }
}

fun findMethodFM(obj: IObject, name: String): IObject? {
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

fun findMethodE(obj: IObject, name: String): IObject? {
    for (e in (obj as IEP).extends) {
        val result = findMethodEFM(e, name)

        if (result != null)
            return result
    }

    return null
}