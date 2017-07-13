package kot.fjy.examples

/**
 * Created by fujianyi on 2017/7/12.
 */

fun maxOf(a:Int,b:Int):Int{
    if(a>b){
        return a
    }else{
        return b
    }
}
fun maxOfClone(a:Int,b:Int):Int = if(a>b)a else b
fun main(args: Array<String>) {
    println("max of 0 and 42 is ${maxOf(0, 42)}")
    println("max of 0 and 42 is ${maxOfClone(0, 42)}")
}