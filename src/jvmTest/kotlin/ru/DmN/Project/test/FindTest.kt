package ru.DmN.Project.test

import com.google.common.base.Stopwatch
import org.junit.Test
import ru.DmN.Project.core.obj.ObjType
import ru.DmN.Project.core.obj.api.IFMP
import ru.DmN.Project.core.obj.api.IObject
import ru.DmN.Project.core.obj.api.IVObject
import ru.DmN.Project.core.obj.impl.AObject
import ru.DmN.Project.core.obj.impl.Object
import ru.DmN.Project.core.obj.impl.VObject
import ru.DmN.Project.core.obj.utils.find
import ru.DmN.Project.core.data.api.obj.IFMS
import ru.DmN.Project.core.data.impl.obj.IESImpl
import ru.DmN.Project.core.data.impl.obj.IFMSF
import ru.DmN.Project.core.data.impl.obj.IFMSImpl
import java.util.concurrent.TimeUnit
import kotlin.test.assertEquals

class FindTest {
    @Test
    fun find1() {
        for (counter in 0 until 10000) {
            val o1 = object : IObject, IFMP {
                override val fields: IFMS<IObject> = IFMSImpl()
                override val methods: IFMS<IVObject> = IFMSImpl()
                override val name: String = "TestObject1"
                override val type: ObjType = ObjType.NULL
            }

            val o2 = VObject("TestObject2", ObjType.NULL, null)

            for (i in 0..1024) {
                if (i == 256)
                    o1.methods.add(o2)

                o1.fields.add(Object("O$i", ObjType.NULL))
                o1.fields.add(Object("O${i + 1023}", ObjType.NULL))
            }

            assertEquals(find(o1, "TestObject2"), o2)
        }
    }

    @Test
    fun find1T() {
        val o1 = object : IObject, IFMP {
            override val fields: IFMS<IObject> = IFMSImpl()
            override val methods: IFMS<IVObject> = IFMSImpl()
            override val name: String = "TestObject1"
            override val type: ObjType = ObjType.NULL
        }

        val o2 = VObject("TestObject2", ObjType.NULL, null)

        for (i in 0..100000) {
            if (i == 99999)
                o1.methods.add(o2)

            o1.fields.add(Object("O$i", ObjType.NULL))
            o1.fields.add(Object("O${i + 1023}", ObjType.NULL))
        }

        val sw = Stopwatch()
        sw.start()

        find(o1, "TestObject2")

        sw.stop()
        println(sw)
    }

    @Test
    fun find2() {
        for (counter in 0 until 100000) {
            val o1 = AObject(IESImpl(), IFMSImpl(), IFMSImpl(), "Object_1", ObjType.OBJECT)
            val o2 = AObject(IESImpl(), IFMSImpl(), IFMSImpl(), "Object_2", ObjType.OBJECT)

            o1.fields.add(VObject("i", ObjType.VAL, 12))
            o2.fields.add(VObject("j", ObjType.VAL, 21))

            o2.extends.add(o1)

            assertEquals((find(o2, "i") as IVObject).value, 12)
            assertEquals((find(o2, "j") as IVObject).value, 21)
        }
    }

    @Test
    fun find2T() {
        val o1 = AObject(IESImpl(), IFMSImpl(), IFMSImpl(), "Object_1", ObjType.OBJECT)
        val o2 = AObject(IESImpl(), IFMSF(), IFMSF(), "Object_2", ObjType.OBJECT)
        (o2.fields as IFMSF).instance = o2
        (o2.methods as IFMSF).instance = o2

        o1.fields.add(VObject("i", ObjType.VAL, 12))
        o2.fields.add(VObject("j", ObjType.VAL, 21))

        o2.extends.add(o1)

        val sw = Stopwatch()
        sw.start()

        o2.fields["i"]
        o2.fields["j"]

//        println(o2.fields["i"])
//        println(o2.fields["j"])

//        find(o2, "i")
//        find(o2, "j")

//        println(find(o2, "i"))
//        println(find(o2, "j"))

//        o2.fields["j"]
//        (o2.extends[0] as IFMP).fields["i"]

//        println(o2.fields["j"])
//        println((o2.extends[0] as IFMP).fields["i"])

        sw.stop()
        println(sw)
    }
}