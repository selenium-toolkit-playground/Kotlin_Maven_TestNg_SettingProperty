package com.seleniumToolkit.selenium.test

import com.seleniumToolkit.selenium.framework.assertBase.ReportAssert
import com.seleniumToolkit.selenium.framework.tag.SeleniumTest
import com.seleniumToolkit.selenium.pageObject.Home
import com.seleniumToolkit.selenium.pageObject.template.AbstractSeleniumToolkitPageObject
import org.testng.annotations.Test

class TagTest {
    @Test(groups = ["allTests"])
    @SeleniumTest(browser = ["browserName=chrome,browserName=firefox"])
    fun sample() {
        val home: Home = AbstractSeleniumToolkitPageObject.Companion.loadSeleniumToolkitPage()
        ReportAssert.assertEquals(home.textOfTitle, "How Easy To Run Selenium Tests?")
        val getStarted = home.topMenuPageObject.clickGetStartedMenu()
        getStarted.enterName("Michel")
    }
}