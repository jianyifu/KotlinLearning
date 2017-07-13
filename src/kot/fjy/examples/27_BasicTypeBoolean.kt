package kot.fjy.examples

/**
 * Created by fujianyi on 2017/7/12.
 */
//The type Boolean represents booleans, and has two values: true and false.
//Booleans are boxed if a nullable reference is needed.
//Built-in operations on booleans include
//
//|| – lazy disjunction
//&& – lazy conjunction
//! - negation
fun main(args: Array<String>) {
    val x: Boolean = true
    var y: Boolean? = null

    if (x && y ?: false) {
        println("both of x and y is true")
    }else{
        println("x is $x,y is $y")
    }
}