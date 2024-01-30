/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.analysis.low.level.api.fir.sessions;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.analysis.api.GenerateAnalysisApiTestsKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("analysis/analysis-api/testData/sessions/sessionInvalidation")
@TestDataPath("$PROJECT_ROOT")
public class CodeFragmentContextModificationLLFirSessionInvalidationTestGenerated extends AbstractCodeFragmentContextModificationLLFirSessionInvalidationTest {
  @Test
  public void testAllFilesPresentInSessionInvalidation() {
    KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/analysis-api/testData/sessions/sessionInvalidation"), Pattern.compile("^(.+)\\.kt$"), null, true);
  }

  @Test
  @TestMetadata("binaryTreeAdditionalEdge.kt")
  public void testBinaryTreeAdditionalEdge() {
    runTest("analysis/analysis-api/testData/sessions/sessionInvalidation/binaryTreeAdditionalEdge.kt");
  }

  @Test
  @TestMetadata("binaryTreeInvalidateA.kt")
  public void testBinaryTreeInvalidateA() {
    runTest("analysis/analysis-api/testData/sessions/sessionInvalidation/binaryTreeInvalidateA.kt");
  }

  @Test
  @TestMetadata("binaryTreeInvalidateCD.kt")
  public void testBinaryTreeInvalidateCD() {
    runTest("analysis/analysis-api/testData/sessions/sessionInvalidation/binaryTreeInvalidateCD.kt");
  }

  @Test
  @TestMetadata("binaryTreeInvalidateF.kt")
  public void testBinaryTreeInvalidateF() {
    runTest("analysis/analysis-api/testData/sessions/sessionInvalidation/binaryTreeInvalidateF.kt");
  }

  @Test
  @TestMetadata("binaryTreeInvalidateL1.kt")
  public void testBinaryTreeInvalidateL1() {
    runTest("analysis/analysis-api/testData/sessions/sessionInvalidation/binaryTreeInvalidateL1.kt");
  }

  @Test
  @TestMetadata("binaryTreeInvalidateL2.kt")
  public void testBinaryTreeInvalidateL2() {
    runTest("analysis/analysis-api/testData/sessions/sessionInvalidation/binaryTreeInvalidateL2.kt");
  }

  @Test
  @TestMetadata("binaryTreeInvalidateLibrarySourceL1.kt")
  public void testBinaryTreeInvalidateLibrarySourceL1() {
    runTest("analysis/analysis-api/testData/sessions/sessionInvalidation/binaryTreeInvalidateLibrarySourceL1.kt");
  }

  @Test
  @TestMetadata("binaryTreeInvalidateLibrarySourceL2.kt")
  public void testBinaryTreeInvalidateLibrarySourceL2() {
    runTest("analysis/analysis-api/testData/sessions/sessionInvalidation/binaryTreeInvalidateLibrarySourceL2.kt");
  }

  @Test
  @TestMetadata("binaryTreeInvalidateNone.kt")
  public void testBinaryTreeInvalidateNone() {
    runTest("analysis/analysis-api/testData/sessions/sessionInvalidation/binaryTreeInvalidateNone.kt");
  }

  @Test
  @TestMetadata("codeFragmentInvalidateFragment1.kt")
  public void testCodeFragmentInvalidateFragment1() {
    runTest("analysis/analysis-api/testData/sessions/sessionInvalidation/codeFragmentInvalidateFragment1.kt");
  }

  @Test
  @TestMetadata("codeFragmentInvalidateFragment2.kt")
  public void testCodeFragmentInvalidateFragment2() {
    runTest("analysis/analysis-api/testData/sessions/sessionInvalidation/codeFragmentInvalidateFragment2.kt");
  }

  @Test
  @TestMetadata("codeFragmentInvalidateLibrary.kt")
  public void testCodeFragmentInvalidateLibrary() {
    runTest("analysis/analysis-api/testData/sessions/sessionInvalidation/codeFragmentInvalidateLibrary.kt");
  }

  @Test
  @TestMetadata("codeFragmentInvalidateNone.kt")
  public void testCodeFragmentInvalidateNone() {
    runTest("analysis/analysis-api/testData/sessions/sessionInvalidation/codeFragmentInvalidateNone.kt");
  }

  @Test
  @TestMetadata("codeFragmentInvalidateSourceModule.kt")
  public void testCodeFragmentInvalidateSourceModule() {
    runTest("analysis/analysis-api/testData/sessions/sessionInvalidation/codeFragmentInvalidateSourceModule.kt");
  }

  @Test
  @TestMetadata("codeFragmentWithContextModuleDependent.kt")
  public void testCodeFragmentWithContextModuleDependent() {
    runTest("analysis/analysis-api/testData/sessions/sessionInvalidation/codeFragmentWithContextModuleDependent.kt");
  }

  @Test
  @TestMetadata("codeFragmentWithUnrelatedModule.kt")
  public void testCodeFragmentWithUnrelatedModule() {
    runTest("analysis/analysis-api/testData/sessions/sessionInvalidation/codeFragmentWithUnrelatedModule.kt");
  }

  @Test
  @TestMetadata("codeFragmentWithUnrelatedModuleAndLibrary.kt")
  public void testCodeFragmentWithUnrelatedModuleAndLibrary() {
    runTest("analysis/analysis-api/testData/sessions/sessionInvalidation/codeFragmentWithUnrelatedModuleAndLibrary.kt");
  }

  @Test
  @TestMetadata("linearInvalidateC.kt")
  public void testLinearInvalidateC() {
    runTest("analysis/analysis-api/testData/sessions/sessionInvalidation/linearInvalidateC.kt");
  }

  @Test
  @TestMetadata("linearInvalidateL1.kt")
  public void testLinearInvalidateL1() {
    runTest("analysis/analysis-api/testData/sessions/sessionInvalidation/linearInvalidateL1.kt");
  }

  @Test
  @TestMetadata("linearInvalidateLibrarySourceL1.kt")
  public void testLinearInvalidateLibrarySourceL1() {
    runTest("analysis/analysis-api/testData/sessions/sessionInvalidation/linearInvalidateLibrarySourceL1.kt");
  }

  @Test
  @TestMetadata("rhombusInvalidateBC.kt")
  public void testRhombusInvalidateBC() {
    runTest("analysis/analysis-api/testData/sessions/sessionInvalidation/rhombusInvalidateBC.kt");
  }

  @Test
  @TestMetadata("rhombusInvalidateCD.kt")
  public void testRhombusInvalidateCD() {
    runTest("analysis/analysis-api/testData/sessions/sessionInvalidation/rhombusInvalidateCD.kt");
  }

  @Test
  @TestMetadata("rhombusInvalidateD.kt")
  public void testRhombusInvalidateD() {
    runTest("analysis/analysis-api/testData/sessions/sessionInvalidation/rhombusInvalidateD.kt");
  }

  @Test
  @TestMetadata("rhombusInvalidateL1.kt")
  public void testRhombusInvalidateL1() {
    runTest("analysis/analysis-api/testData/sessions/sessionInvalidation/rhombusInvalidateL1.kt");
  }

  @Test
  @TestMetadata("rhombusInvalidateL2.kt")
  public void testRhombusInvalidateL2() {
    runTest("analysis/analysis-api/testData/sessions/sessionInvalidation/rhombusInvalidateL2.kt");
  }

  @Test
  @TestMetadata("rhombusInvalidateLibrarySourceL1.kt")
  public void testRhombusInvalidateLibrarySourceL1() {
    runTest("analysis/analysis-api/testData/sessions/sessionInvalidation/rhombusInvalidateLibrarySourceL1.kt");
  }

  @Test
  @TestMetadata("rhombusInvalidateLibrarySourceL2.kt")
  public void testRhombusInvalidateLibrarySourceL2() {
    runTest("analysis/analysis-api/testData/sessions/sessionInvalidation/rhombusInvalidateLibrarySourceL2.kt");
  }

  @Test
  @TestMetadata("transitiveCodeFragment.kt")
  public void testTransitiveCodeFragment() {
    runTest("analysis/analysis-api/testData/sessions/sessionInvalidation/transitiveCodeFragment.kt");
  }

  @Test
  @TestMetadata("unrelatedCodeFragment.kt")
  public void testUnrelatedCodeFragment() {
    runTest("analysis/analysis-api/testData/sessions/sessionInvalidation/unrelatedCodeFragment.kt");
  }
}
