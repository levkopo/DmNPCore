package ru.DmN.Project.core.obj.api

import ru.DmN.Project.core.data.api.obj.IES

/**
 * Extends Provider
 */
interface IEP : IDP {
    val extends: IES<IDPO>
}