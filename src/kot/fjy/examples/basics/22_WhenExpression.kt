package kot.fjy.examples.basics

/**
 * Created by fujianyi on 2017/7/12.
 */
//when replaces the switch operator of C-like languages. In the simplest form it looks like this
//when matches its argument against all branches sequentially until some branch condition is satisfied
//when can be used either as an expression or as a statement.
//If it is used as an expression, the value of the satisfied branch becomes the value of the overall expression.
//If it is used as a statement, the values of individual branches are ignored.
//(Just like with if, each branch can be a block, and its value is the value of the last expression in the block.)
fun describe(obj: Any) =
        when (obj) {//when is an expression here
            1 -> "one"
            "hello" -> "greeting"
            is Long -> "long"
            !is String -> "not a string"
            else -> "unknown"//The else branch is evaluated if none of the other branch conditions are satisfied.
        }
//If when is used as an expression, the else branch is mandatory,
//unless the compiler can prove that all possible cases are covered with branch conditions.

fun main(args: Array<String>) {
    println(describe(1))
    println(describe("hello"))
    println(describe(200L))
    println(describe(100))
    println(describe(listOf(1)))
    var x = 1
    when (x) {
    //If many cases should be handled in the same way, the branch conditions may be combined with a comma:
        0, 1 -> print("x == 0 or x == 1")
        else -> print("otherwise")
    }
    println()
    val s ="1"
    //We can use arbitrary expressions (not only constants) as branch conditions
    when (x) {
        parseInt(s) -> print("s encodes x")
        else -> print("s does not encode x")
    }
    println()
    //We can also check a value for being in or !in a range or a collection:
    val validNumbers = Array<Int>(4){i -> i+6 }//to create an intArray[6,7,8,9]
    x = 6
    when (x) {
        in 1..5 -> print("x is in the range")
        in validNumbers -> print("x is valid")//validNumbers is an intArray[6,7,8,9]
        !in 10..20 -> print("x is outside the range")
        else -> print("none of the above")
    }
    println()
    //Another possibility is to check that a value is or !is of a particular type.
    //Note that, due to smart casts, you can access the methods and properties of the type without any extra checks.
    fun hasPrefix(x: Any?) = when(x) {
        is String -> x.startsWith("prefix")//You dont need to cast x to String due to the smart cast
        else -> false
    }
    println(hasPrefix("prefixString"))//true
    println(hasPrefix(null))//false
    println(hasPrefix(""))//false

    //when can also be used as a replacement for an if-else if chain.
    //If no argument is supplied, the branch conditions are simply boolean expressions,
    //and a branch is executed when its condition is true:
    when {
        x.isOdd() -> print("x is odd")
        x.isEven() -> print("x is even")
        else -> print("x is funny")
    }
}

private fun Int.isEven(): Boolean {
    return true
}

private fun Int.isOdd(): Boolean {
    return false
}
