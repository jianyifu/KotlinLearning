package kot.fjy.examples.basics

/**
 * Created by fujianyi on 2017/7/12.
 */

//With function literals, local functions and object expression, functions can be nested in Kotlin.
//Qualified returns allow us to return from an outer function.
//The most important use case is returning from a lambda expression. Recall that when we write this:
fun outerFun() {
    val ints = listOf(1, 2, 3, 4, 5)
    fun foo() {
        ints.forEach {
            if (it == 3) return// nonlocal return from inside lambda directly to the caller of foo()
            println("it is $it from foo foreach")
        }
        println("the last statement is called in foo")
    }

    fun fooOne() {
        ints.forEach lit@ {
            if (it == 3) return@lit// it returns only from the lambda expression
            println("it is $it from fooOne foreach")
        }
        println("the last statement is called in fooOne")
    }
//    it is more convenient to use implicits labels: such a label has the same name as the function to which the lambda is passed.
    fun fooTwo() {
        ints.forEach {
            if (it == 3) return@forEach
            println("it is $it from fooTwo foreach")
        }
        println("the last statement is called in fooTwo")
    }

    //Alternatively, we can replace the lambda expression with an anonymous function.
    //A return statement in an anonymous function will return from the anonymous function itself.
    val strs = listOf("haha", "heihie", "aaaa", "bbbb")
    fun fooThree() {
        strs.forEach(fun(value: String) {
            if (!value.startsWith("h")) {
                println("str is $value")
                return// return from the anonymous function itself,not return from the foreach
            }
        })
        println("the last statement is called in fooThree")
    }
    foo()
    fooOne()
    fooTwo()
    fooThree()
}

fun main(args: Array<String>) {
    outerFun()
}