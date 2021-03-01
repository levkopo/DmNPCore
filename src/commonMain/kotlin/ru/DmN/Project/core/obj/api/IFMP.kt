package ru.DmN.Project.core.obj.api

import ru.DmN.Project.core.data.api.obj.IFMS

/**
 * Fields Methods Provider
 */
interface IFMP : IDP {
    val fields: IFMS<IObject>
    val methods: IFMS<IVObject>
}