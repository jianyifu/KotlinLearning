package kot.fjy.examples.classesobjects

///test for scope of extension
import kot.fjy.other.goo
import kot.fjy.other.Baz
//or
//import kot.fjy.other.*

/**
 * Created by fujianyi on 2017/7/13.
 */
/**
 * Extensions

    Kotlin, similar to C# and Gosu, provides the ability to extend a class with new functionality without having to inherit from the class or use any type of design pattern such as Decorator.
    This is done via special declarations called extensions.
    Kotlin supports extension functions and extension properties.
 */
/**
 * Extension Functions
 * To declare an extension function, we need to prefix its name with a receiver type, i.e.
 * the type being extended.The following adds a swap function to MutableList<Int>:
 */

fun MutableList<Int>.swap(index1:Int,index2:Int){
    val tmp = this[index1] // 'this' corresponds to the list
    this[index1] = this[index2]
    this[index2] = tmp
}
/**
 * Of course, this function makes sense for any MutableList<T>, and we can make it generic:
 */
fun <T> MutableList<T>.swapOne(index1:Int,index2:Int){
    val tmp = this[index1] // 'this' corresponds to the list
    this[index1] = this[index2]
    this[index2] = tmp
}

/**
 * Extensions are resolved statically
 */
open class CC

class DD: CC()

fun CC.foo() = "c"

fun DD.foo() = "d"
/**
 * This example will print "c",
    because the extension function being called depends only on the declared type of the parameter c, which is the C class.
 */

fun printFoo(c: CC) {
    println(c.foo())
}

/**
 * If a class has a member function, and an extension function is defined which has the same receiver type,
 * the same name and is applicable to given arguments, the member always wins.
 */
class C1{
    fun foo(){
         println("C1.member")
    }
}
fun C1.foo(){//If we call c.foo() of any c of type C, it will print "member", not "extension".
    println("C1.extension")
}
/**
 * However, it's perfectly OK for extension functions to overload member functions which have the same name but a different signature:
 */
class C2 {
    fun foo() { println("C2.member") }
}
fun C2.foo(i: Int) { println("C2.extension") }//The call to C().foo(1) will print "extension".
/**
 * Nullable Receiver
 * Note that extensions can be defined with a nullable receiver type.
 * Such extensions can be called on an object variable even if its value is null, and can check for this == null inside the body.
 * This is what allows you to call toString() in Kotlin without checking for null: the check happens inside the extension function.
 */
fun Any?.toString():String {
    if (this == null) return "this is called in extension fun"
    // after the null check, 'this' is autocast to a non-null type, so the toString() below
    // resolves to the member function of the Any class
    return toString()
}

/**
 * Extension Properties
 * Note that, since extensions do not actually insert members into classes,
 * there's no efficient way for an extension property to have a backing field.
 * This is why initializers are not allowed for extension properties.
 * Their behavior can only be defined by explicitly providing getters/setters.
 */
val <T> List<T>.lastIndex: Int
    get() = size - 1
val C2.bar:Int
    get() = 1//Their behavior can only be defined by explicitly providing getters/setters.
//val C2.bar2:Int = 1//Extension property cannot be initialized because it has no backing field.

/**
 * Companion Object Extensions
 * If a class has a companion object defined, you can also define extension functions and properties for the companion object:
 */
class MyClass {
    companion object { }  // will be called "Companion"
}

fun MyClass.Companion.foo() {
    println("MyClass.Companion.foo is called")
}
//Just like regular members of the companion object, they can be called using only the class name as the qualifier:
//MyClass.foo()

/**
 * Scope of Extensions
 * package kot.fjy.other
 * class Baz
 * fun Baz.goo() {
 * println("Baz.goo is called")
 * }
 *
 * import kot.fjy.other.*  or (import kot.fjy.other.goo and import kot.fjy.other.Bar)
 */
fun usage(baz: Baz) {
    baz.goo()
}

fun main(args: Array<String>) {
    val l = mutableListOf(1, 2, 3)
    println(l)
    l.swap(0, 2) // 'this' inside 'swap()' will hold the value of 'l'
    println(l)

    val ll = mutableListOf('1','2','3')
    println(ll)
    ll.swapOne(0,2)
    println(ll)

    printFoo(DD())

    C1().foo()

    C2().foo(1)

    val str = null
    println(str)//it will print  String.valueOf(x) from the implementation of println()
    println(str.toString())// it will call the extension fun toString

    MyClass.foo()

    usage(Baz())//test for scope of extension
}