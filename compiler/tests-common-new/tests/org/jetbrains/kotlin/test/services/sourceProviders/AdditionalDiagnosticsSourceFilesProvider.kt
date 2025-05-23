/*
 * Copyright 2010-2020 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.test.services.sourceProviders

import org.jetbrains.kotlin.test.directives.AdditionalFilesDirectives
import org.jetbrains.kotlin.test.directives.AdditionalFilesDirectives.CHECK_TYPE
import org.jetbrains.kotlin.test.directives.AdditionalFilesDirectives.CHECK_TYPE_WITH_EXACT
import org.jetbrains.kotlin.test.directives.AdditionalFilesDirectives.INFERENCE_HELPERS
import org.jetbrains.kotlin.test.directives.model.DirectivesContainer
import org.jetbrains.kotlin.test.directives.model.RegisteredDirectives
import org.jetbrains.kotlin.test.directives.model.SimpleDirective
import org.jetbrains.kotlin.test.model.TestFile
import org.jetbrains.kotlin.test.model.TestModule
import org.jetbrains.kotlin.test.services.AdditionalSourceProvider
import org.jetbrains.kotlin.test.services.TestModuleStructure
import org.jetbrains.kotlin.test.services.TestServices

class AdditionalDiagnosticsSourceFilesProvider(testServices: TestServices) : AdditionalSourceProvider(testServices) {
    private val helpersPath = "diagnostics/helpers"
    private val directiveToFileMap: Map<SimpleDirective, String> = mapOf(
        CHECK_TYPE to "$helpersPath/types/checkType.kt",
        CHECK_TYPE_WITH_EXACT to "$helpersPath/types/checkTypeWithExact.kt",
        INFERENCE_HELPERS to "$helpersPath/inference/inferenceUtils.kt"
    )

    override val directiveContainers: List<DirectivesContainer> =
        listOf(AdditionalFilesDirectives)

    @OptIn(ExperimentalStdlibApi::class)
    override fun produceAdditionalFiles(
        globalDirectives: RegisteredDirectives,
        module: TestModule,
        testModuleStructure: TestModuleStructure
    ): List<TestFile> {
        return buildList {
            for ((directive, path) in directiveToFileMap) {
                if (directive in module.directives) {
                    add(this::class.java.classLoader.getResource(path)!!.toTestFile())
                }
            }
        }
    }
}
