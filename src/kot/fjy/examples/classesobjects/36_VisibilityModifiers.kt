package kot.fjy.examples.classesobjects

/**
 * Created by fujianyi on 2017/7/13.
 */
/**
 * Classes, objects, interfaces, constructors, functions, properties and their setters can have visibility modifiers.
 * (Getters always have the same visibility as the property.)
 * There are four visibility modifiers in Kotlin:
 *         private, protected, internal and public.
 * The default visibility, used if there is no explicit modifier, is public.
 */

/**
 * Functions, properties and classes, objects and interfaces can be declared on the "top-level"
 */

fun baz() {}//If you do not specify any visibility modifier,public is used by default, which means that your declarations will be visible everywhere;

class Bar {}//public by default

private fun fooFoo() {}//If you mark a declaration private, it will only be visible inside the file containing the declaration;
public var bar: Int = 5 // property is visible everywhere
    private set         // setter is visible only in 36_VisibilityModifiers.kt
internal val baz = 6    // visible inside the same module,there is not module concept here.

/**
 * For members declared inside a class:
private means visible inside this class only (including all its members);
protected — same as private + visible in subclasses too;
internal — any client inside this module who sees the declaring class sees its internal members;
public — any client who sees the declaring class sees its public members.

NOTE for Java users: outer class does not see private members of its inner classes in Kotlin.
If you override a protected member and do not specify the visibility explicitly,
the overriding member will also have protected visibility.
 */

open class Outer {
    private var a = "a" // a is invisible to derived class
    protected open val b = "b"
    internal var c = "c"
    val d = "d"

    private class NestedOne {// not visible to subclasses
        private var a = "a1"
        protected val b = "b1"
        internal var c = "c1"
        val d="d1"
    }
     protected open class NestedTwo{
        private var a = "a2"
        protected  var b = "b2"
        internal var c = "c2"
        var d = "d2"
    }
    override fun toString(): String {
        return "Outer a is $a, b is $b,c is $c,d is $d"
    }
}

class DerivedFromOuter:Outer(){
    override val b = "b3"
    override fun toString(): String {
        val derivedFromNested = DerivedFromNested()
        return "DerivedFromOuter b is $b,c is $c,d is $d,$derivedFromNested"
    }
    protected class DerivedFromNested:NestedTwo(){

        override fun toString(): String {
            b = "b4"
            c = "c4"
            d = "d4"
            return "DerivedFromNested b is $b,c is $c,d is $d"
        }
    }
}
class Unrelated(o: Outer) {
    // o.a, o.b are not visible
    // o.c and o.d are visible (same module)
    // Outer.Nested is not visible, and Nested::e is not visible either
}

fun main(args: Array<String>) {
    println(DerivedFromOuter())
}