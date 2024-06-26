import org.jetbrains.kotlinx.dataframe.*
import org.jetbrains.kotlinx.dataframe.annotations.*
import org.jetbrains.kotlinx.dataframe.api.*
import org.jetbrains.kotlinx.dataframe.io.*

data class Nested(val d: Double)

data class Record(val a: String, val b: Int, val nested: Nested)

fun box(): String {
    val df = listOf(Record("112", 42, Nested(3.0))).toDataFrame(maxDepth = 1)
    val df1 = df.select { a and nested.d and expr { 42 } }
    df1.a
    df1.d
    df1.untitled
    return "OK"
}
