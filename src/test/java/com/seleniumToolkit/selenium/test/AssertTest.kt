package com.seleniumToolkit.selenium.test

import com.seleniumToolkit.selenium.framework.allure.AllureUtils
import com.seleniumToolkit.selenium.framework.assertBase.ReportAssert
import com.seleniumToolkit.selenium.helper.TestObject
import org.testng.annotations.Test

class AssertTest {
    @Test(groups = ["allTests"])
    fun sample() {
        AllureUtils.startStep("ReportAssert.assertEquals")
        ReportAssert.assertEquals(1, 1, "1==1 int")
        ReportAssert.assertEquals(1L, 1L, "1==1 long")
        ReportAssert.assertEquals(1.0.toFloat(), 1.0.toFloat(), "1.0==1.0 float")
        ReportAssert.assertEquals(1.0, 1.0, "1.0==1.0 double")
        ReportAssert.assertEquals("1.0", "1.0", "\"1.0\"==\"1.0\" String")
        ReportAssert.assertEquals(intArrayOf(1, 2), intArrayOf(1, 2), "[1,2]==[1,2] int[]")
        ReportAssert.assertEquals(longArrayOf(1L, 2L), longArrayOf(1L, 2L), "[1,2]==[1,2] long[]")
        ReportAssert.assertEquals(floatArrayOf(1.0.toFloat(), 2.0.toFloat()), floatArrayOf(1.0.toFloat(), 2.0.toFloat()), "[1.0,2.0]==[1.0,2.0] float[]")
        ReportAssert.assertEquals(doubleArrayOf(1.0, 2.0), doubleArrayOf(1.0, 2.0), "[1.0,2.0]==[1.0,2.0] double[]")
        ReportAssert.assertEquals(arrayOf("1.0", "2.0"), arrayOf("1.0", "2.0"), "[1.0,2.0]==[1.0,2.0] String[]")
        ReportAssert.assertEquals(TestObject("1.0"), TestObject("1.0"), "new TestObject(\"1.0\") == new TestObject(\"1.0\")")
        AllureUtils.stopStepPassed()
        AllureUtils.startStep("ReportAssert.assertNotEquals")
        ReportAssert.assertNotEquals(1, 2, "1!=2 int")
        ReportAssert.assertNotEquals(1L, 2L, "1!=2 long")
        ReportAssert.assertNotEquals(1.0.toFloat(), 2.0.toFloat(), "1.0!=2.0 float")
        ReportAssert.assertNotEquals(1.0, 2.0, "1.0!=2.0 double")
        ReportAssert.assertNotEquals("1.0", "2.0", "\"1.0\"!=\"2.0\" String")
        ReportAssert.assertNotEquals(intArrayOf(1, 2), intArrayOf(2, 2), "[1,2]!=[2,2] int[]")
        ReportAssert.assertNotEquals(longArrayOf(1L, 2L), longArrayOf(2L, 2L), "[1,2]!=[2,2] long[]")
        ReportAssert.assertNotEquals(floatArrayOf(1.0.toFloat(), 2.0.toFloat()), floatArrayOf(2.0.toFloat(), 2.0.toFloat()), "[1.0,2.0]!=[2.0,2.0] float[]")
        ReportAssert.assertNotEquals(doubleArrayOf(1.0, 2.0), doubleArrayOf(2.0, 2.0), "[1.0,2.0]!=[2.0,2.0] double[]")
        ReportAssert.assertNotEquals(arrayOf("1.0", "2.0"), arrayOf("2.0", "2.0"), "[1.0,2.0]!=[2.0,2.0] String[]")
        ReportAssert.assertNotEquals(TestObject("1.0"), TestObject("2.0"), "new TestObject(\"1.0\") != new TestObject(\"2.0\")")
        AllureUtils.stopStepPassed()
        AllureUtils.startStep("ReportAssert.assertTrue/assertFalse")
        ReportAssert.assertTrue(true, "ReportAssert.assertTrue")
        ReportAssert.assertFalse(false, "ReportAssert.assertFalse")
        AllureUtils.stopStepPassed()
        AllureUtils.startStep("ReportAssert.assertNull")
        ReportAssert.assertNull(null, "ReportAssert.assertNull null")
        AllureUtils.stopStepPassed()
        AllureUtils.startStep("ReportAssert.assertSame/assertNotSame")
        val t = TestObject("1.0")
        ReportAssert.assertSame(t, t, "t = new TestObject(\"1.0\"); t == t")
        ReportAssert.assertNotSame(t, TestObject("1.0"), "t = new TestObject(\"1.0\"); t !=  new TestObject(\"1.0\");")
        AllureUtils.stopStepPassed()
    }
}