package ru.DmN.Project.core.Object.api

import ru.DmN.Project.core.data.api.Object.IES

/**
 * Extends Provider
 */
interface IEP : IDP {
    val extends: IES<IDPO>
}