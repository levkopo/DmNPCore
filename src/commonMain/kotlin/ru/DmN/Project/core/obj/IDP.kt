package ru.DmN.Project.core.obj

import ru.DmN.Project.core.data.obj.IDS

/**
 * Defs Provider
 */
interface IDP : DP {
    val fields: IDS<IObject>
}