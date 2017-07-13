package kot.fjy.examples.basics

/**
 * Created by fujia on 2017/7/11.
 */
fun sum(a:Int,b:Int):Int{
    return a+b
}
fun sumOne(a:Int,b:Int)=a+b
fun printSum(a:Int,b:Int):Unit{
    println("sum of $a and $b is $(a+b)")
}
fun printSumOne(a: Int, b: Int) {
    println("sumOne of $a and $b is ${a + b}")
}
fun main(args: Array<String>) {
    println(sum(3, 5))
    println(sumOne(4, 6))
    printSum(2, 3)
    printSumOne(4, 5)
}