package ru.DmN.Project.test

import org.junit.Test
import ru.DmN.Project.core.`object`.ObjType
import ru.DmN.Project.core.`object`.api.IFMS
import ru.DmN.Project.core.`object`.api.IObject
import ru.DmN.Project.core.`object`.api.IVObject
import java.lang.Exception
import kotlin.test.assertEquals

class ObjectTest {
    @Test
    fun find1() {
        val o1 = object : IObject, IFMS {
            override val fields: ArrayList<IObject> = ArrayList()
            override val methods: ArrayList<IVObject> = ArrayList()
            override val name: String = "TestObject1"
            override val type: ObjType = ObjType.NULL
        }

        val o2 = object : IVObject {
            override val name: String = "TestObject2"
            override val type: ObjType = ObjType.NULL
            override var value: Any? = 12
                set(_) = throw Exception()
        }

        for (i in 0..1024) {
            if (i == 256)
                o1.methods.add(o2)

            o1.fields.add(object : IObject {
                override val name: String = "O$i"
                override val type: ObjType = ObjType.NULL

            })

            o1.fields.add(object : IObject {
                override val name: String = "O${i + 1023}"
                override val type: ObjType = ObjType.NULL

            })
        }

        assertEquals(ru.DmN.Project.core.`object`.utils.find(o1, "TestObject2"), o2)
    }
}