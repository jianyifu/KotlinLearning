package kot.fjy.examples.classesobjects

import kotlin.test.todo

/**
 * Created by fujianyi on 2017/7/13.
 */

//In Kotlin, unlike Java or C#, classes do not have static methods.
//In most cases, it's recommended to simply use package-level functions instead.

//If you need to write a function that can be called without having a class instance
//but needs access to the internals of a class (for example, a factory method),
//you can write it as a member of an object declaration inside that class.

//Even more specifically, if you declare a companion object inside your class,
//you'll be able to call its members with the same syntax as calling static methods in Java/C#,
//using only the class name as a qualifier.
fun main(args: Array<String>) {
    todo { "need details" }
}