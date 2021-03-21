package ru.DmN.Project.core.vm

interface IVirtualMachine<T> {
    fun init()
    fun eval(code: T)
}