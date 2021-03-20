package ru.DmN.Project.core.obj.api

/**
 * Callable Object
 */
interface ICO<VM, I> : IObject {
    fun call(vm: VM, instance: I)
}