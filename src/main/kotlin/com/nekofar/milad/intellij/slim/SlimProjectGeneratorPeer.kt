package com.nekofar.milad.intellij.slim

import com.intellij.ide.util.projectWizard.SettingsStep
import com.intellij.openapi.ui.ValidationInfo
import com.intellij.platform.WebProjectGenerator
import com.intellij.util.textCompletion.TextFieldWithCompletion
import com.jetbrains.php.composer.ComposerCreateProjectForm
import com.jetbrains.php.composer.ComposerProjectPeer
import com.jetbrains.php.composer.ComposerProjectSettings
import com.jetbrains.php.composer.addDependency.ComposerPackage
import javax.swing.JComponent
import javax.swing.JPanel

class SlimProjectGeneratorPeer : ComposerProjectPeer() {
    private val form = ComposerCreateProjectForm()
    private val packageName = "slim/slim-skeleton"

    override fun getComponent(): JComponent {
        return updatePackageField(form.contentPane)
    }

    override fun buildUI(settingsStep: SettingsStep) {
        val contentPane = updatePackageField(form.contentPane)
        settingsStep.addSettingsComponent(contentPane)
    }

    override fun getSettings(): ComposerProjectSettings {
        val settings = form.settings

        return ComposerProjectSettings(
            settings.isDownload,
            ComposerPackage(packageName),
            settings.version,
            settings.options,
            settings.execution
        )
    }

    private fun updatePackageField(contentPane: JComponent): JComponent {
        val components = ((contentPane.components[1] as JPanel).components[0] as JPanel).components
        val packageTextField = (components[1] as TextFieldWithCompletion)
        packageTextField.text = packageName
        return contentPane
    }

    override fun validate(): ValidationInfo? {
        return form.validate()
    }

    @Deprecated("Deprecated in Java")
    override fun addSettingsStateListener(listener: WebProjectGenerator.SettingsStateListener) {
        form.addSettingsStateListener(listener);
    }
}
