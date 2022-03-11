package com.nekofar.milad.intellij.slim

import com.intellij.ide.util.projectWizard.WizardContext
import com.intellij.platform.ProjectTemplatesFactory

class SlimProjectTemplatesFactory : ProjectTemplatesFactory() {
    override fun getGroups() = arrayOf("PHP")
    override fun createTemplates(group: String?, context: WizardContext) = arrayOf(SlimProjectGenerator())
}