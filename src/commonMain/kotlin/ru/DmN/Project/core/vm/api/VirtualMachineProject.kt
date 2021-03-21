package ru.DmN.Project.core.vm.api

import ru.DmN.Project.core.obj.api.IEP
import ru.DmN.Project.core.obj.api.IFMP
import ru.DmN.Project.core.obj.api.IObject
import ru.DmN.Project.core.obj.api.IVObject

abstract class VirtualMachineProject {
    abstract val name: String
    abstract val version: String
    abstract val authors: ArrayList<String>
    abstract val license: String

    abstract fun <T> toIObject(obj: T): IObject
    abstract fun <T> toIVObject(obj: T): IVObject
    abstract fun <T> toIEP(obj: T): IEP
    abstract fun <T> toIFMP(obj: T): IFMP

    abstract fun <T> ofIObject(obj: IObject): T
    abstract fun <T> ofIVObject(obj: IVObject): T
    abstract fun <T> ofIEP(obj: IEP): T
    abstract fun <T> ofIFMP(obj: IFMP): T
}