package kot.fjy.examples

/**
 * Created by fujianyi on 2017/7/12.
 */
//The is operator checks if an expression is an instance of a type.
// If an immutable local variable or property is checked for a specific type, there's no need to cast it explicitly:

fun getStringLength(obj:Any):Int?{
    if(obj is String)
        return obj.length// there is no need to cast obj to String type,it is casted automaticly.
    return null
}
fun getStringLengthOne(obj: Any): Int? {
    if (obj !is String) return null

    // `obj` is automatically cast to `String` in this branch
    return obj.length
}
fun getStringLengthTwo(obj: Any): Int? {
    // `obj` is automatically cast to `String` on the right-hand side of `&&`
    if (obj is String && obj.length > 0) {
        return obj.length
    }

    return null
}
fun main(args: Array<String>) {
    fun printLength(obj:Any){
        println("'$obj' string length is ${getStringLength(obj) ?: "... err, not a string"} ")
    }
    printLength("Incomprehensibilities")
    printLength("")
    printLength(1000)
    printLength(listOf(Any()))
}