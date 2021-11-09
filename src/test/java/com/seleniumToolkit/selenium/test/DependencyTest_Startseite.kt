package com.seleniumToolkit.selenium.test

import com.seleniumToolkit.selenium.framework.assertBase.ReportAssert
import com.seleniumToolkit.selenium.framework.tag.SeleniumTest
import com.seleniumToolkit.selenium.pageObject.Home
import com.seleniumToolkit.selenium.pageObject.template.AbstractSeleniumToolkitPageObject
import io.qameta.allure.Feature
import org.testng.annotations.Test

class DependencyTest_Startseite {
    @Test(groups = ["allTests", "dependencyTests"])
    @SeleniumTest
    @Feature("DependencyTest")
    fun buttonGetStartedWorked() {
        val home: Home = AbstractSeleniumToolkitPageObject.Companion.loadSeleniumToolkitPage()
        ReportAssert.assertEquals(home.textOfTitle, "How Easy To Run Selenium Tests?", "Should Fail to demonstrate Skip-Test")
        val getStarted = home.topMenuPageObject.clickGetStartedMenu()
        getStarted.waitUntilUrlContains(getStarted.URL)
        ReportAssert.assertEquals(getStarted.textOfTitle, "Contact.", "Should Fail to demonstrate Skip-Test")
    }

    @Test(groups = ["allTests", "dependencyTests"], dependsOnMethods = ["buttonGetStartedWorked"])
    @SeleniumTest
    @Feature("DependencyTest")
    fun shouldFail() {
        val home: Home = AbstractSeleniumToolkitPageObject.Companion.loadSeleniumToolkitPage()
        ReportAssert.assertEquals(home.textOfTitle, "Fail", "Should Fail to demonstrate Skip-Test")
    }

    @Test(groups = ["allTests", "dependencyTests"], dependsOnMethods = ["shouldFail"])
    @SeleniumTest
    @Feature("DependencyTest")
    fun skippedBecauseDepends() {
        val home: Home = AbstractSeleniumToolkitPageObject.Companion.loadSeleniumToolkitPage()
        ReportAssert.assertEquals(home.textOfTitle, "Should not be executed because the dependency")
    }
}