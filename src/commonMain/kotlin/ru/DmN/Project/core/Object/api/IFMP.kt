package ru.DmN.Project.core.Object.api

import ru.DmN.Project.core.data.api.Object.IFMS

/**
 * Fields Methods Provider
 */
interface IFMP : IDP {
    val fields: IFMS<IObject>
    val methods: IFMS<IVObject>
}