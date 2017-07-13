package kot.fjy.examples

/**
 * Created by fujianyi on 2017/7/12.
 */
//In Kotlin, if is an expression, i.e. it returns a value
//Therefore there is no ternary operator (condition ? then : else),
// because ordinary if works fine in this role.
fun maxOf(a: Int, b: Int):Int {
    val max = if (a > b) a else b
    return max
}

fun maxOfOne(a: Int, b: Int): Int = if (a > b) a else b
//if branches can be blocks, and the last expression is the value of a block:
fun maxOfTwo(a:Int,b:Int):Int{
    val max = if(a>b){
        print(a)
        a
    }else{
        print(b)
        b
    }
    return max
}
//If you're using if as an expression rather than a statement
//(for example, returning its value or assigning it to a variable),
//the expression is required to have an else branch.
fun main(args: Array<String>) {
    println("max of 0 and 42 is ${maxOf(0, 42)}")
    println("max of 0 and 42 is ${maxOfOne(0, 42)}")
    println("max of 0 and 42 is ${maxOfTwo(0, 42)}")
}