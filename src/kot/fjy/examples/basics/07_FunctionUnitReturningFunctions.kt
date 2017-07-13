package kot.fjy.examples.basics

/**
 * Created by fujia on 2017/7/11.
 */
//If a function does not return any useful value, its return type is Unit.
//Unit is a type with only one value - Unit.
//This value does not have to be returned explicitly
fun printHello(name: String?): Unit {
    if (name != null)
        println("Hello ${name}")
    else
        println("Hi there!")
    // `return Unit` or `return` is optional
}
//fun printHello(name: String?) {
//    if (name != null)
//        println("Hello ${name}")
//    else
//        println("Hi there!")
//    // `return Unit` or `return` is optional
//}
fun main(args: Array<String>) {
    printHello(null)
    printHello("")
    printHello("haha")
}