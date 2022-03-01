package com.nekofar.milad.intellij.slim

import com.jetbrains.php.composer.ComposerProjectGenerator

class SlimProjectGenerator : ComposerProjectGenerator() {
    override fun getIcon() = SlimIcons.ProjectGenerator
    override fun getName() = SlimBundle.message("slim.project.generator.name")
    override fun getDescription() = SlimBundle.message("slim.project.generator.description")
    override fun createPeer() = SlimProjectGeneratorPeer()
}