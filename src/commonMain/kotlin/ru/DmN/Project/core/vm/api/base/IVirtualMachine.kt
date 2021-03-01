package ru.DmN.Project.core.vm.api.base

interface IVirtualMachine<T> {
    fun init()
    fun eval(code: T)
}