package ru.DmN.Project.core.`object`.api

import ru.DmN.Project.core.data.api.IFMS

/**
 * Fields Methods Provider
 */
interface IFMP {
    val fields: IFMS<IObject>
    val methods: IFMS<IVObject>
}