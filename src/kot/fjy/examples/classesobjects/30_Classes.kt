package kot.fjy.examples.classesobjects

/**
 * Created by fujianyi on 2017/7/13.
 */
//Classes in Kotlin are declared using the keyword class:
class Invoice{}

//The class declaration consists of
//the class name,
//the class header (specifying its type parameters, the primary constructor etc.)
//and the class body,
//surrounded by curly braces.
//Both the header and the body are optional; if the class has no body, curly braces can be omitted.
class Empty

//Constructors
//A class in Kotlin can have a primary constructor and one or more secondary constructors.
//The primary constructor is part of the class header: it goes after the class name (and optional type parameters).
open class Person constructor(firstName: String) {
}
//If the primary constructor does not have any annotations or visibility modifiers, the constructor keyword can be omitted:
class PersonOne(firstName: String) {
}

//The primary constructor cannot contain any code.
//Initialization code can be placed in initializer blocks, which are prefixed with the init keyword:
class PersonTwo(firstName: String) {
    init {
       println("PersonTwo initialized with value $firstName")
    }
}
//In fact, for declaring properties and initializing them from the primary constructor, Kotlin has a concise syntax:
class PersonThree(val firstName: String, val lastName: String, var age: Int) {
    val personName = firstName.toUpperCase()
}

//If the constructor has annotations or visibility modifiers, the constructor keyword is required, and the modifiers go before it:
//class Customer public @Inject constructor(name: String) { }
class Customer public constructor(name: String) { }

//Secondary Constructors
//The class can also declare secondary constructors, which are prefixed with constructor:
//If the class has a primary constructor, each secondary constructor needs to delegate to the primary constructor, either directly or indirectly through another secondary constructor(s).
//Delegation to another constructor of the same class is done using the this keyword:
class PersonFour (val firstName: String ){
    init {
        println("PersonFour initialized with firstName = $firstName")
    }
    constructor (firstName: String,lastName: String):this(firstName) {
        println("PersonFour initialized with firstName = $firstName,lastName = $lastName")
    }
    constructor(firstName: String,lastName: String,age:Int) : this(firstName,lastName) {
        println("PersonFour initialized with firstName = $firstName,lastName = $lastName,age = $age")
    }
}
//
//If a non-abstract class does not declare any constructors (primary or secondary),
//it will have a generated primary constructor with no arguments.
//The visibility of the constructor will be public.
//If you do not want your class to have a public constructor,
//you need to declare an empty primary constructor with non-default visibility:
class NotDeclareConstuctor {
    init {
        println("NotDeclareConstuctor")
    }
}
class DontCreateMe private constructor () {
}
//NOTE: On the JVM, if all of the parameters of the primary constructor have default values,
//the compiler will generate an additional parameterless constructor which will use the default values.
class CustomerOne(val customerName: String = "defaultName"){
    init {
        println("CustomerOne name is $customerName")
    }
}
fun main(args: Array<String>) {
//    val personTwo = PersonTwo("FirstPerson")
//    val personFour = PersonFour("fu")
//    val personFourFour = PersonFour("fu","jianyi")
//    val personFourFourFour = PersonFour("fu","jianyi",18)
//    val notDeclareConstuctor = NotDeclareConstuctor()
    val customerOne = CustomerOne()
    val customerOne1 = CustomerOne("NonDefaultName")
}