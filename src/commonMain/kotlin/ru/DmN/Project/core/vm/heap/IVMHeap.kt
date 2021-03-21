package ru.DmN.Project.core.vm.heap

import ru.DmN.Project.core.obj.IObject

interface IVMHeap<Object : IObject> {
    fun add(obj: Object)
    fun remove(obj: Object)
    fun remove(obj: String)

    operator fun set(name: String, obj: Object)
    operator fun get(name: String): Object
}