package ru.DmN.Project.core.obj

import ru.DmN.Project.core.data.obj.IES

/**
 * Extends Provider
 */
interface IEP : IDP {
    val extends: IES<IDPO>
}