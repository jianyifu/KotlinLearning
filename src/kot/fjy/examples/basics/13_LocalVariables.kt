package kot.fjy.examples.basics

import kotlin.test.todo

/**
 * Created by fujianyi on 2017/7/12.
 */
fun main(args: Array<String>) {
    //Assign-once (read-only) local variable:val
    val a:Int = 1//immediate assignment
    val b = 2//immediate assignment
    val c: Int  // Type required when no initializer is provided
    c = 3
    println("a = $a, b = $b, c = $c")

    //Mutable variable:var
    var x = 5 // `Int` type is inferred
    x += 1
    println("x = $x")

    todo { "See also Properties And Fields." }
}