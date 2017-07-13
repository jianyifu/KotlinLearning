package kot.fjy.examples.basics

/**
 * Created by fujianyi on 2017/7/12.
 */
//Kotlin handles numbers in a way close to Java, but not exactly the same
//Characters are not numbers in Kotlin
//Octal literals are not supported
fun main(args: Array<String>) {
    //    There are no implicit widening conversions for numbers,smaller types are not subtypes of bigger ones
    //    As a consequence, smaller types are NOT implicitly converted to bigger types.
    //    This means that we cannot assign a value of type Byte to an Int variable without an explicit conversion
    val b: Byte = 1 // OK, literals are checked statically
//    val i: Int = b // ERROR
    //    We can use explicit conversions to widen numbers
    val i: Int = b.toInt()//OK,explicitly widened

    //    Underscores in numeric literals (since 1.1)
    val oneMillion = 1_000_000
    val creditCardNumber = 1234_5678_9012_3456L
    val socialSecurityNumber = 999_99_9999L
    val hexBytes = 0xFF_EC_DE_5E
    val bytes = 0b11010010_01101001_10010100_10010010

    //    Note that boxing of numbers does not necessarily preserve identity:
    val a: Int = 10000
    println(a === a) // Prints 'true'
    val boxedA: Int? = a
    val anotherBoxedA: Int? = a
    println(boxedA === anotherBoxedA) // !!!Prints 'false'!!!
    //    On the other hand, it preserves equality:
    println(boxedA == anotherBoxedA)


    //    Kotlin supports the standard set of arithmetical operations over numbers,
    //     which are declared as members of appropriate classes
    //    As of bitwise operations, there're no special characters for them,
    //     but just named functions that can be called in infix form, for example:
    val x = (1 shl 2) and 0x000FF000

//    Here is the complete list of bitwise operations (available for Int and Long only):
//
//    shl(bits) – signed shift left (Java's <<)
//    shr(bits) – signed shift right (Java's >>)
//    ushr(bits) – unsigned shift right (Java's >>>)
//    and(bits) – bitwise and
//    or(bits) – bitwise or
//    xor(bits) – bitwise xor
//    inv() – bitwise inversion
}