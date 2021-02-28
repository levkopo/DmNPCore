package ru.DmN.Project.core.`object`.api

import ru.DmN.Project.core.data.api.IFMS

/**
 * Fields Methods Provider
 */
interface IFMP : IDP {
    val fields: IFMS<IObject>
    val methods: IFMS<IVObject>
}