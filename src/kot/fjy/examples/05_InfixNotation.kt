package kot.fjy.examples

/**
 * Created by fujia on 2017/7/11.
 */
//Functions can also be called using infix notations when
//
//They are member functions or extension functions
//They have a single parameter
//They are marked with the infix keyword

// Define extension to Int
infix fun Int.myShl(x: Int):Int{
  return   (this*Math.pow(2.0, x.toDouble())).toInt()
}

fun main(args: Array<String>) {
    println(3 myShl  2)
    println(3.myShl(1) )
}