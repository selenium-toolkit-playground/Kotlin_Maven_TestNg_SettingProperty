package com.seleniumToolkit.selenium.test

import com.seleniumToolkit.selenium.framework.assertBase.ReportAssert
import com.seleniumToolkit.selenium.framework.driver.WebDriverManager
import com.seleniumToolkit.selenium.framework.tag.SeleniumTest
import com.seleniumToolkit.selenium.pageObject.Home
import com.seleniumToolkit.selenium.pageObject.template.AbstractSeleniumToolkitPageObject
import io.qameta.allure.Feature
import org.testng.annotations.Test
import java.util.concurrent.TimeUnit

class InitialTest {
    @Test(groups = ["allTests", "initTests"], testName = "InitTest-Name")
    @SeleniumTest
    @Feature("InitialTest other depends on this")
    fun websiteIsUpAndRunning() {
        WebDriverManager.getWebdriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS)
        val home: Home = AbstractSeleniumToolkitPageObject.Companion.loadSeleniumToolkitPage()
        ReportAssert.assertEquals(home.textOfTitle, "How Easy To Run Selenium Tests?")
    }
}