package kot.fjy.examples.classesobjects

/**
 * Created by fujianyi on 2017/7/13.
 */
/**
 * Interfaces in Kotlin are very similar to Java 8.
 *  They can contain declarations of abstract methods, as well as method implementations.
 *  What makes them different from abstract classes is that interfaces cannot store state.
 *  They can have properties but these need to be abstract or to provide accessor implementations.
 */

interface MyInterface {
    fun bar()
    fun foo() {
        // optional body
    }
}

/**
 * Implementing Interfaces
 */
class Child:MyInterface{
    override fun bar() {
       println("fun bar() is implemented.")
    }
}

/**
 * Properties in Interfaces
 *  A property declared in an interface can either be abstract, or it can provide implementations for accessors.
 *  Properties declared in interfaces can't have backing fields, and therefore accessors declared in interfaces can't reference them.
 */
interface MyInterfaceOne {
    var prop: Int // abstract

    var propertyWithImplementation: String//provide implementations for accessors.
        get() = getString()
    set(value) {
        setString(value)
    }
    fun setString(value: String)
    fun getString():String
    fun foo()
}

class ChildOne : MyInterfaceOne {
    override var prop: Int = 0
    override fun getString(): String {
        return "prop is $prop"
    }

    override fun setString(value: String) {
        prop = value.toInt()
    }
    override fun foo() {
        prop = 10
        println(propertyWithImplementation)
        propertyWithImplementation="5"
        print(propertyWithImplementation)
    }
}

/**
 * Resolving overriding conflicts
 */
interface A {
    fun foo() { print("A") }
    fun bar()
}

interface B {
    fun foo() { print("B") }
    fun bar() { print("bar") }
}

class C : A {
    override fun bar() { print("bar") }
}

class D : A, B {
    override fun foo() {
        super<A>.foo()
        super<B>.foo()
    }

    override fun bar() {
        super<B>.bar()
    }
}
fun main(args: Array<String>) {
    Child().bar()
    ChildOne().foo()
    D().bar()
    D().foo()
}