package kot.fjy.examples

/**
 * Created by fujianyi on 2017/7/12.
 */

fun main(args: Array<String>) {
    //Check a number is within a range using "in" operator
    val x = 10
    val y = 9
    if (x in 1..y + 1) {
        println("fits the range")
    }
    //Check if a number is out of range:
    if( 5 !in y..y+1){
        println("5 is out of the range")
    }
    //Iterating over a range
    for(i in 1..5){
        println(i)
    }
    //over a progression
    for (x in 1..10 step 2) {
        print("x is $x   ")
    }
    println()
    for (x in 9 downTo 0 step 3) {
        print("x is $x   ")
    }
}