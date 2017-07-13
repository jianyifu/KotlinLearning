package kot.fjy.examples.basics

import kotlin.test.todo

//A member function is a function that is defined inside a class or object
class Sample(){
    fun foo(){
        print("Foo")
    }
}
fun main(args: Array<String>) {
    Sample().foo()
    todo { "see Classes and Inheritance" }
}