// DO NOT EDIT MANUALLY!
// Generated by org/jetbrains/kotlin/generators/arguments/GenerateGradleOptions.kt
// To regenerate run 'generateGradleOptions' task
@file:Suppress("RemoveRedundantQualifierName", "Deprecation", "Deprecation_Error", "DuplicatedCode")

package org.jetbrains.kotlin.gradle.dsl

enum class JsSourceMapNamesPolicy(val policy: String) {
    SOURCE_MAP_NAMES_POLICY_FQ_NAMES("fully-qualified-names"),
    SOURCE_MAP_NAMES_POLICY_SIMPLE_NAMES("simple-names"),
    SOURCE_MAP_NAMES_POLICY_NO("no"),
    ;

    companion object {
        @JvmStatic
        fun fromPolicy(policy: String): JsSourceMapNamesPolicy =
            JsSourceMapNamesPolicy.values().firstOrNull { it.policy == policy }
                ?: throw IllegalArgumentException(
                    "Unknown JS source map names policy: $policy,\navailable policies: ${JsSourceMapNamesPolicy.values().joinToString{ it.policy }}\n" +
                            "Prefer configuring 'sourceMapNamesPolicy' value via 'compilerOptions' DSL: https://kotl.in/compiler-options-dsl"
                )
    }
}
