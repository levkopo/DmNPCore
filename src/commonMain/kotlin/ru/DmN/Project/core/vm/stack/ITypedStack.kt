package ru.DmN.Project.core.vm.stack

interface ITypedStack<T> {
    fun push(obj: T)
    fun peek(): T
    fun pop(): T
}