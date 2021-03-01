package ru.DmN.Project.core.data.impl.Object

import ru.DmN.Project.core.Object.api.IObject
import ru.DmN.Project.core.data.api.Object.IFMS

expect class IFMSImpl<T : IObject> : IFMS<T>