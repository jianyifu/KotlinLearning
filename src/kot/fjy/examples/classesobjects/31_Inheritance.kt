package kot.fjy.examples.classesobjects

/**
 * Created by fujianyi on 2017/7/13.
 */
//All classes in Kotlin have a common superclass Any,
// that is a default super for a class with no supertypes declared:
//Any is not java.lang.Object;
//in particular, it does not have any members other than equals(), hashCode() and toString().
class Example // Implicitly inherits from Any

//To declare an explicit supertype, we place the type after a colon in the class header:
open class Base(p: Int)

//If the class has a primary constructor, the base type can (and must) be initialized right there,
//using the parameters of the primary constructor.
class Derived(p: Int) : Base(p)

//If the class has no primary constructor,
//then each secondary constructor has to initialize the base type using the super keyword, or to delegate to another constructor which does that.
//Note that in this case different secondary constructors can call different constructors of the base type:
open class BaseOne(p: Int) {
    init {
        println("BaseOne primary constructor is called p is $p")
    }

    constructor(p: Int, q: Int) : this(p) {
        println("BaseOne secondary constructor is called p is $p,q is $q")
    }
}

class DerivedOne : BaseOne {
    constructor(p: Int) : super(p) {
        println("DerivedOne secondary constructor is called p is $p")
    }

    constructor(p: Int, q: Int) : super(p, q) {
        println("DerivedOne secondary constructor is called p is $p,q is $q")
    }
}
//The open annotation on a class is the opposite of Java's final:
//it allows others to inherit from this class. By default, all classes in Kotlin are final

//Overriding Methods
open class BaseTwo {
    open fun v() {}
    fun nv() {}// with no open annotion
}

class DerivedTwo : BaseTwo() {
    //    A member marked override is itself open, i.e. it may be overridden in subclasses.
//    If you want to prohibit re-overriding, use final:
    final override fun v() {//The override annotation is required for Derived.v(). If it were missing, the compiler would complain.

    }
    //If there is no open annotation on a function, like Base.nv(),
    //declaring a method with the same signature in a subclass is illegal, either with override or without it.
//    fun nv(){}//illegal,couldnt combile
}

//Overriding Properties
//Overriding properties works in a similar way to overriding methods;
//Each declared property can be overridden by a property with an initializer or by a property with a getter method
open class BaseThree {
    open val x: Int get() {
        return 0
    }
    open val y: Int = 100
}

class DerivedThree : BaseThree() {
    override val x: Int = super.x + 1
    //You can also override a val property with a var property, but not vice versa.
//    This is allowed because a val property essentially declares a getter method,
//    and overriding it as a var additionally declares a setter method in the derived class.
    override var y: Int = super.y + 100
}
//Note that you can use the override keyword as part of the property declaration in a primary constructor.
class DerivedThreeAnother(override val x:Int): BaseThree()


//Overriding Rules

//In Kotlin, implementation inheritance is regulated by the following rule:
//if a class inherits many implementations of the same member from its immediate superclasses,
//it must override this member and provide its own implementation (perhaps, using one of the inherited ones).
//To denote the supertype from which the inherited implementation is taken,
//we use super qualified by the supertype name in angle brackets, e.g. super<Base>:
open class BaseFour{
    open fun base(){
        println("BaseFour.base()")
    }
    fun four(){
        println("BaseFour.four()")
    }
}
interface BaseFourInterface{
    fun base(){
        println("BaseFourInterface.base()")
    }
    fun fourInterface(){
        println("BaseFourInterface.fourInterface()")
    }
}
class DerivedFour:BaseFour(),BaseFourInterface{
    override fun base() {
        super<BaseFour>.base()
        super<BaseFourInterface>.base()
    }
}

//Abstract Classes
//A class and some of its members may be declared abstract.
//An abstract member does not have an implementation in its class.
//Note that we do not need to annotate an abstract class or function with open – it goes without saying.
open class BaseFive{
    open fun base(){}
}
abstract class DerivedFive:BaseFive(){
    abstract override fun base()//Dont need to explicit open
}
class DerivedFromDerivedFive:DerivedFive(){
    override fun base() {
        println("DerivedFromDerivedFive is called")
    }
}
fun main(args: Array<String>) {
//    val baseOne = BaseOne(5)
//    val baseOne1 = BaseOne(7, 8)
//    val derivedOne = DerivedOne(6)
//    val derivedOne1 = DerivedOne(8, 9)
//    val derivedThree = DerivedThree()
//    println(derivedThree.x)
    DerivedFour().base()
}