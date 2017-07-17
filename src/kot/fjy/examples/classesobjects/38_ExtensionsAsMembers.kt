package kot.fjy.examples.classesobjects

/**
 * Created by fujianyi on 2017/7/17.
 */
/**
 * Inside a class, you can declare extensions for another class.
 * Inside such an extension, there are multiple implicit receivers -objects members of which can be accessed without a qualifier.
 * The instance of the class in which the extension is declared is called dispatch receiver,
 * and the instance of the receiver type of the extension method is called extension receiver.
 *
 */
//extension receiver
class D3 {

    fun bar() {
        println("D3.bar() is called")
    }

    override fun toString(): String {
        return "this is D3"
    }
}
//dispatch receiver
class C3 {

    fun baz() {
        println("C3.baz() is called")
    }

    fun D3.foo() {
        bar()   // calls D.bar without qualified D.far
        baz()   // calls C.baz
    }

    fun caller(d: D3) {
        d.foo()   // call the extension function
        d.aaa()
    }

    /**
     * In case of a name conflict between the members of the dispatch receiver and the extension receiver
     * the extension receiver takes precedence. To refer to the member of the dispatch receiver you can use the qualified this syntax.
     */
    fun D3.aaa() {
        println(toString())         // calls D3.toString(),D3 is the extension receiver
        println(this@C3.toString()) // calls C3.toString(),use the qualified this syntax
    }

    override fun toString(): String {
        return "this is C3"
    }
}

/**
 * Extensions declared as members can be declared as open and overridden in subclasses.
 * This means that the dispatch of such functions is virtual with regard to the dispatch receiver type,
 * but static with regard to the extension receiver type.
 */
open class D4 {
}

class D5 : D4() {
}

open class C4 {
    open fun D4.foo() {
        println("D4.foo in C4")
    }

    open fun D5.foo() {
        println("D5.foo in C4")
    }

    fun caller(d: D4) {
        d.foo()   // call the extension function
    }
}

class C5 : C4() {
    override fun D4.foo() {
        println("D4.foo in C5")
    }

    override fun D5.foo() {
        println("D5.foo in C5")
    }
}

fun main(args: Array<String>) {
    C3().caller(D3())

    C4().caller(D4())   // prints "D4.foo in C4"
    C5().caller(D4())  // prints "D4.foo in C5" - dispatch receiver is resolved virtually
    C4().caller(D5())  // prints "D4.foo in C4" - extension receiver is resolved statically
}