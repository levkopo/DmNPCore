package ru.DmN.Project.core.`object`.api

import ru.DmN.Project.core.data.api.IES

/**
 * Extends Provider
 */
interface IEP : IDP {
    val extends: IES<IDPO>
}