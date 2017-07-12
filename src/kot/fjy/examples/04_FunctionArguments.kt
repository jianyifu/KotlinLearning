package kot.fjy.examples

/**
 * Created by fujia on 2017/7/11.
 */
fun printParams(str:String, index: Int = 0, len: Int = str.length) {
    println("str =$str ,index=$index,len=$len")
}
//Overriding methods always use the same default parameter values as the base method.
//When overriding a method with default parameters values,
//the default parameter values must be omitted from the signature:
open class A {
    open fun foo(i: Int = 10) {
        println("foo is called form A ,and i = $i")
    }
}

class B : A() {
    override fun foo(i: Int) {// no default value allowed
        println("foo is called form B ,and i = $i")
    }
}

fun main(args: Array<String>) {
    printParams("hahaha")
    val b = B()
    b.foo()
    b.foo(100)
}
