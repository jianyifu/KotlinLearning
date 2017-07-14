package kot.fjy.examples.classesobjects

/**
 * Created by fujianyi on 2017/7/13.
 */

//Declaring Properties
//Classes in Kotlin can have properties.
//These can be declared as mutable using the var keyword or read-only using the val keyword.
class Address {
    var name: String = "NoName"
    var street: String = "NoStreet"
    var city: String = "NoCity"
    var state: String = "NoState"
    var zip: String = "NoZip"
    override fun toString(): String {
        return "name is $name,street is $street,city is $city,state is $state,zip is$zip"
    }
}

//Getters and Setters
class GetAndSet {
    //    var setterCalledCount: Int?  // error: explicit initializer required, default getter and setter implied
    var setterCalledCount: Int? = 0 // ok:
    var initialized = 1 // has type Int, default getter and setter
    val size: Int = 10
    val isEmpty get() = this.size == 0//Since Kotlin 1.1, you can omit the property type if it can be inferred from the getter:
    var description: String ="default"
//        get() = toString()
        set(value) {
            //description = value //will recursively call the setter and cause stackoverflow error in the end
            //Backing Fields
            //The field identifier can only be used in the accessors of the property.
            field = value //use backfield here
            increaseSetterCount()
        }

    var setterVisibility: String = "abc"
        private set // the setter is private and has the default implementation

    private fun increaseSetterCount() {
        setterCalledCount = setterCalledCount?.plus(1)
    }
    //Backing Properties
    //uf you want to do something that does not fit into this "implicit backing field" scheme,
    // you can always fall back to having a backing property:
    private var _table: Map<String, Int>? = null
    public val table: Map<String, Int>
        get() {
            if (_table == null) {
                _table = HashMap() // Type parameters are inferred
            }
            return _table ?: throw AssertionError("Set to null by another thread")
        }

    override fun toString(): String {
        return "isEmpty is $isEmpty,size is $size,setterCalledCount is $setterCalledCount"
    }
}

//Compile-Time Constants


/*  Properties the value of which is known at compile time can be marked as compile time constants using the const modifier.

    Such properties need to fulfil the following requirements:
        Top-level or member of an object
        Initialized with a value of type String or a primitive type
        No custom getter
        */
const val SUBSYSTEM_DEPRECATED: String = "This subsystem is deprecated"

//Such properties can be used in annotations:
@Deprecated(SUBSYSTEM_DEPRECATED) fun foo() {  }


//Late-Initialized Properties


/*
    The modifier can only be used on var properties declared inside the body of a class (not in the primary constructor),
    and only when the property does not have a custom getter or setter.
    The type of the property must be non-null,
    and it must not be a primitive type.

    Accessing a lateinit property before it has been initialized
     throws a special exception that clearly identifies the property being accessed and
     the fact that it hasn't been initialized.
 */

class TestSubject {
    fun method() {
        println("method is called in TestSubject")
    }
}

class MyTest {
    lateinit var subject: TestSubject

    fun setup():MyTest {
        subject = TestSubject()
        return this
    }

    fun test() {
        subject.method()  // dereference directly
    }
}

//Overriding Properties
//see examples in 31_Inheritance.kt


fun main(args: Array<String>) {
//    val address = Address()
//    address.city = "Beijing"
//    println(address)
//    val getAndSetInstance = GetAndSet()
//    println(getAndSetInstance)
//    getAndSetInstance.description = "not default"//implicit call the setter method
//    println(getAndSetInstance)
//    println(getAndSetInstance.description)
    try {
        MyTest().test()//kotlin.UninitializedPropertyAccessException: lateinit property subject has not been initialized
    }catch (e:Exception){
       println("Exception has happened:e=$e")
    }finally {
        MyTest().setup().test()
    }

}