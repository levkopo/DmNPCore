package ru.DmN.Project.core.data.impl

import ru.DmN.Project.core.`object`.api.IObject
import ru.DmN.Project.core.data.api.IFMS

expect class IFMSImpl<T : IObject> : IFMS<T>