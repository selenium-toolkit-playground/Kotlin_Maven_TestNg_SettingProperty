package com.seleniumToolkit.selenium.test.screenshot

import com.seleniumToolkit.selenium.framework.assertBase.ReportAssert
import com.seleniumToolkit.selenium.framework.screenshot.core.Capture
import com.seleniumToolkit.selenium.framework.screenshot.core.ScreenShootMaker
import com.seleniumToolkit.selenium.framework.tag.SeleniumTest
import com.seleniumToolkit.selenium.pageObject.Home
import com.seleniumToolkit.selenium.pageObject.template.AbstractSeleniumToolkitPageObject
import org.testng.annotations.Test
import java.io.File

class DiffScreenshotTest : AbstractScreenshotTest() {
    @Test(groups = ["allTests"])
    @SeleniumTest
    fun screenshotScrollDiffSuccess() {
        val diffScreenshot = "screenshots/ScreenshotTest_ScreenshotScrollPageDiffSuccess"
        deleteFileIfExist("$diffScreenshot.png")
        val home: Home = AbstractSeleniumToolkitPageObject.Companion.loadSeleniumToolkitPage()
        val getStarted = home.topMenuPageObject.clickGetStartedMenu()
        getStarted.waitUntilUrlContains(getStarted.URL)
        getStarted.prepareFixedElementsForScreenshot()
        ReportAssert.assertTrue(ScreenShootMaker.page.shoot(Capture.FULL_SCROLL, 2000).cutOut(getStarted.slider).equalsWithDiff("screenshots/reference/ScreenshotTest_ScreenshotScrollPageDiffSuccess.png", diffScreenshot), "Screenshot should be same, but is not")
        getStarted.resetFixedElementsForScreenshot()
        val screenshotFile = File("$diffScreenshot.png")
        ReportAssert.assertFalse(screenshotFile.exists(), "File should not exist")
    }

    @Test(groups = ["allTests"])
    @SeleniumTest
    fun screenshotScrollDiffFailedDimensionMissmatch() {
        val diffScreenshot = "target/screenshots/ScreenshotTest_ScreenshotScrollPageDimensionMissmatchDiff"
        deleteFileIfExist("$diffScreenshot.png")
        val home: Home = AbstractSeleniumToolkitPageObject.Companion.loadSeleniumToolkitPage()
        val seleniumHelp = home.topMenuPageObject.clickSeleniumHelpMenu()
        //home.topMenuPageObject.clickAboutMenu();
        seleniumHelp.prepareFixedElementsForScreenshot()
        ReportAssert.assertFalse(ScreenShootMaker.page.shoot(Capture.FULL_SCROLL, 2000).cutOut(seleniumHelp.slider).equalsWithDiff("screenshots/reference/ScreenshotTest_ScreenshotScrollPageDimensionMissmatch.png", "target/screenshots/ScreenshotTest_ScreenshotScrollPageDimensionMissmatchDiff"), "Screens" +
                "hot should be same, but is not")
        seleniumHelp.resetFixedElementsForScreenshot()
        val screenshotFile = File("$diffScreenshot.png")
        ReportAssert.assertFalse(screenshotFile.exists(), "File should not exist, because Dimensiot missmatch")
    }

    @Test(groups = ["allTests"])
    @SeleniumTest
    fun screenshotScrollPageDiffFailed() {
        val diffScreenshot = "target/screenshots/ScreenshotTest_ScreenshotScrollPageDiffFalse"
        deleteFileIfExist("$diffScreenshot.png")
        val home: Home = AbstractSeleniumToolkitPageObject.Companion.loadSeleniumToolkitPage()
        val showcase = home.topMenuPageObject.clickShowcaseMenu()
        showcase.waitUntilUrlContains(showcase.URL)
        home.prepareFixedElementsForScreenshot()
        ReportAssert.assertFalse(ScreenShootMaker.page.shoot(Capture.FULL_SCROLL, 2000).equalsWithDiff("screenshots/reference/DiffScreenshotTest_screenshotScrollPageDiffFailed.png", diffScreenshot, 0.00), "Screenshot should be same, but is not")
        home.resetFixedElementsForScreenshot()
        val screenshotFile = File("$diffScreenshot.png")
        ReportAssert.assertTrue(screenshotFile.exists(), "File should exist")
    }

    @Test(groups = ["allTests"])
    @SeleniumTest
    fun screenshotElementDiffSuccess() {
        val diffScreenshot = "target/screenshots/ScreenshotTest_ScreenshotElementDiffSuccess"
        deleteFileIfExist("$diffScreenshot.png")
        val home: Home = AbstractSeleniumToolkitPageObject.Companion.loadSeleniumToolkitPage()
        home.prepareFixedElementsForScreenshot()
        ReportAssert.assertTrue(ScreenShootMaker.element.shoot(home.solutionButton).equalsWithDiff("screenshots/reference/DiffScreenshotTest_screenshotElementDiffSuccess.png", diffScreenshot), "Screenshot should be same, but is not")
        home.resetFixedElementsForScreenshot()
        val screenshotFile = File("$diffScreenshot.png")
        ReportAssert.assertFalse(screenshotFile.exists(), "File should not exist")
    }
}