package com.nekofar.milad.intellij.slim

import com.automation.remarks.junit5.Video
import com.intellij.remoterobot.RemoteRobot
import com.intellij.remoterobot.search.locators.byXpath
import com.nekofar.milad.intellij.slim.pages.dialog
import com.nekofar.milad.intellij.slim.pages.idea
import com.nekofar.milad.intellij.slim.pages.welcomeFrame
import com.nekofar.milad.intellij.slim.utils.RemoteRobotExtension
import com.nekofar.milad.intellij.slim.utils.StepsLogger
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder
import org.junit.jupiter.api.extension.ExtendWith

@TestMethodOrder(OrderAnnotation::class)
@ExtendWith(RemoteRobotExtension::class)
class UITest {
    init {
        StepsLogger.init()
    }

    @AfterEach
    fun closeProject(remoteRobot: RemoteRobot) = with(remoteRobot) {
        idea {
            menuBar.select("File", "Close Project")
        }
    }

    @Test
    @Video
    @Order(1)
    fun createNewProject(remoteRobot: RemoteRobot) = with(remoteRobot) {
        welcomeFrame {
            createNewProjectLink.click()
            dialog("New Project") {
                findText("PHP").click()
                jList(
                    byXpath(
                        "//div[contains(@visible_text_keys, 'slim.project.generator.name')]"
                    )
                ).clickItem("Slim")
                button("Next").click()
                button("Finish").click()
            }
        }
    }
}