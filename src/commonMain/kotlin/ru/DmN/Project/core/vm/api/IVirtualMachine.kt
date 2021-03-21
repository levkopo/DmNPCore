package ru.DmN.Project.core.vm.api

interface IVirtualMachine<T> {
    fun init()
    fun eval(code: T)
}