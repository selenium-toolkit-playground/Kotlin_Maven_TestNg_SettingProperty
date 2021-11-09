package com.seleniumToolkit.selenium.test

import com.seleniumToolkit.selenium.framework.assertBase.ReportAssert
import com.seleniumToolkit.selenium.framework.tag.SeleniumTest
import com.seleniumToolkit.selenium.helper.ExcelAdapter
import com.seleniumToolkit.selenium.pageObject.Home
import com.seleniumToolkit.selenium.pageObject.template.AbstractSeleniumToolkitPageObject
import io.qameta.allure.Feature
import org.testng.annotations.DataProvider
import org.testng.annotations.Test
import org.testng.util.Strings

class DataProviderTest_Contact {
    @Test(groups = ["allTests", "dependencyTests", "dataProvider"], dataProvider = "contactProvider")
    @SeleniumTest
    @Feature("DataProvider")
    fun contactWithStandardDataproviderParallel(name: String?, email: String?, phone: String?, message: String?, errorSize: Int?) {
        testContact(name, email, phone, message, errorSize)
    }

    @Test(groups = ["allTests", "dependencyTests", "dataProvider"], dataProvider = "contactProviderFromExcel")
    @SeleniumTest
    @Feature("DataProvider")
    fun contactWithExcelDataproviderNotParallel(name: String?, email: String?, phone: String?, message: String?, errorSize: Int?) {
        testContact(name, email, phone, message, errorSize)
    }

    private fun testContact(name: String?, email: String?, phone: String?, message: String?, errorSize: Int?) {
        val home: Home = AbstractSeleniumToolkitPageObject.Companion.loadSeleniumToolkitPage()
        val getStarted = home.topMenuPageObject.clickGetStartedMenu()
        if (Strings.isNotNullAndNotEmpty(name)) {
            getStarted.enterName(name)
        }
        if (Strings.isNotNullAndNotEmpty(email)) {
            getStarted.enterEmail(email)
        }
        if (Strings.isNotNullAndNotEmpty(phone)) {
            getStarted.enterPhoneNumber(phone)
        }
        if (Strings.isNotNullAndNotEmpty(message)) {
            getStarted.enterMessage(message)
        }
        getStarted.clickSubmitButton()
        ReportAssert.assertEquals(getStarted.getErrorFieldSize(), errorSize, "Test the Size of Errorlist")
    }

    @DataProvider(parallel = true)
    fun contactProvider(): Array<Array<Any>> {
        return arrayOf(arrayOf("Michel", "no Vailid", "052 000 00 00", "", 3), arrayOf("Michel", "info@selenium-toolkit.com", "", "", 2))
    }

    @DataProvider(parallel = false)
    @Throws(Exception::class)
    fun contactProviderFromExcel(): Array<Array<Any?>>? {
        return ExcelAdapter.getTableArray("testdata/contactInput.xlsx", "Daten")
    }
}