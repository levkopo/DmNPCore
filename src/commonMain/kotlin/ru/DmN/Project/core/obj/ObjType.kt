package ru.DmN.Project.core.obj

class FMObjType : ObjType()

open class ObjType {
    companion object {
        val NULL        = ObjType()

        val VAL         = ObjType()
        val VAR         = ObjType()
        val REFERENCE   = ObjType()

        val METHOD      = FMObjType()

        val INTERFACE   = FMObjType()
        val CLASS       = FMObjType()
        val OBJECT      = FMObjType()

        val PACKAGE     = ObjType()
    }
}