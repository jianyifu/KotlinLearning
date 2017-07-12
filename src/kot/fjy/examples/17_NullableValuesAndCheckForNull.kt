package kot.fjy.examples

/**
 * Created by fujianyi on 2017/7/12.
 */
//A reference must be explicitly marked as nullable when null value is possible.

fun parseInt(str: String): Int? {
    return str.toIntOrNull()
}

fun printProduct(arg1: String, arg2: String) {
    val a = parseInt(arg1);
    val b = parseInt(arg2);
    if (a != null && b != null) {
        println(a * b)
    } else {
        println("Either arg1 $arg1 is NaN or arg2 $arg2 is NaN")
    }
}

fun main(args: Array<String>) {
    printProduct("3", "4")
    printProduct("a", "4")
    printProduct("2", "b")
}