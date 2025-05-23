/*
 * Copyright 2010-2020 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.ir.backend.js.lower.calls

import org.jetbrains.kotlin.ir.backend.js.JsIrBackendContext
import org.jetbrains.kotlin.ir.declarations.IrConstructor
import org.jetbrains.kotlin.ir.expressions.IrExpression
import org.jetbrains.kotlin.ir.expressions.IrFunctionAccessExpression
import org.jetbrains.kotlin.ir.expressions.impl.IrCallImpl
import org.jetbrains.kotlin.ir.symbols.IrClassSymbol
import org.jetbrains.kotlin.ir.util.getPropertyGetter
import org.jetbrains.kotlin.ir.util.getSimpleFunction
import org.jetbrains.kotlin.ir.util.hasShape

class PrimitiveContainerMemberCallTransformer(private val context: JsIrBackendContext) : CallsTransformer {
    private val intrinsics = context.intrinsics

    private val symbolToTransformer: SymbolToTransformer = hashMapOf()

    init {
        symbolToTransformer.run {
            // Arrays
            add(context.intrinsics.array.sizeProperty, context.intrinsics.jsArrayLength)
            add(context.intrinsics.array.getFunction, context.intrinsics.jsArrayGet)
            add(context.intrinsics.array.setFunction, context.intrinsics.jsArraySet)
            add(context.intrinsics.array.iterator, context.intrinsics.jsArrayIteratorFunction)
            for ((key, elementType) in context.intrinsics.primitiveArrays) {
                add(key.sizeProperty, context.intrinsics.jsArrayLength)
                add(key.getFunction, context.intrinsics.jsArrayGet)
                add(key.setFunction, context.intrinsics.jsArraySet)
                add(key.iterator, context.intrinsics.jsPrimitiveArrayIteratorFunctions[elementType]!!)

                // TODO irCall?
                add(key.sizeConstructor) { call ->
                    IrCallImpl(
                        call.startOffset,
                        call.endOffset,
                        call.type,
                        context.intrinsics.primitiveToSizeConstructor[elementType]!!,
                        typeArgumentsCount = 0
                    ).apply {
                        arguments[0] = call.arguments[0]
                    }
                }
            }

            add(context.irBuiltIns.stringClass.hashCodeFunction, intrinsics.jsGetStringHashCode)
            add(context.irBuiltIns.stringClass.lengthProperty, context.intrinsics.jsArrayLength)
            add(context.irBuiltIns.stringClass.getFunction, intrinsics.jsCharCodeAt)
            add(context.irBuiltIns.stringClass.subSequence, context.symbols.subStringFunction)
            add(intrinsics.charSequenceLengthPropertyGetterSymbol, intrinsics.jsCharSequenceLength)
            add(intrinsics.charSequenceGetFunctionSymbol, intrinsics.jsCharSequenceGet)
            add(intrinsics.charSequenceSubSequenceFunctionSymbol, intrinsics.jsCharSequenceSubSequence)
            add(context.irBuiltIns.dataClassArrayMemberHashCodeSymbol, context.intrinsics.jsHashCode)
            add(context.irBuiltIns.dataClassArrayMemberToStringSymbol, context.intrinsics.jsToString)
        }
    }

    override fun transformFunctionAccess(call: IrFunctionAccessExpression, doNotIntrinsify: Boolean): IrExpression {
        if (doNotIntrinsify) return call
        symbolToTransformer[call.symbol]?.let {
            return it(call)
        }

        return call
    }
}

private val IrClassSymbol.sizeProperty
    get() = getPropertyGetter("size")!!

private val IrClassSymbol.getFunction
    get() = getSimpleFunction("get")!!

private val IrClassSymbol.setFunction
    get() = getSimpleFunction("set")!!

private val IrClassSymbol.iterator
    get() = getSimpleFunction("iterator")!!

private val IrClassSymbol.sizeConstructor
    get() = owner.declarations.asSequence().filterIsInstance<IrConstructor>().first { it.hasShape(regularParameters = 1) }.symbol

private val IrClassSymbol.lengthProperty
    get() = getPropertyGetter("length")!!

private val IrClassSymbol.subSequence
    get() = getSimpleFunction("subSequence")!!

private val IrClassSymbol.hashCodeFunction
    get() = getSimpleFunction("hashCode")!!
