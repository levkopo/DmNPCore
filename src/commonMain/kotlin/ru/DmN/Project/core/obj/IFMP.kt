package ru.DmN.Project.core.obj

import ru.DmN.Project.core.data.obj.IFMS

/**
 * Fields Methods Provider
 */
interface IFMP : IDP {
    val fields: IFMS<IObject>
    val methods: IFMS<IVObject>
}