package kot.fjy.examples

/**
 * Created by fujia on 2017/7/11.
 */

//Inside a function a vararg-parameter of type T is visible as an array of T,
//i.e. the ts variable in the example above has type Array<out T>.
fun <T> myList(vararg ts: T): List<T> {
    val result = ArrayList<T>()
    for (t in ts) // ts is an Array
        result.add(t)
    return result
}
//Only one parameter may be marked as vararg.
//If a vararg parameter is not the last one in the list,
//values for the following parameters can be passed using the named argument syntax, or,
//if the parameter has a function type, by passing a lambda outside parentheses.

// if we already have an array and want to pass its contents to the function, we use the spread operator (prefix the array with *):
fun <T> myListAndLen(vararg ts: T,len:Int=ts.size): Map<List<T>,Int> {
    val result = ArrayList<T>()
    for (t in ts) // ts is an Array
        result.add(t)
    return mapOf(result to len)
}
fun <T> myListAndLastElement(vararg ts: T,last: (array:List<T>) -> T): Map<List<T>,T> {
    val result = ArrayList<T>()
    for (t in ts) // ts is an Array
        result.add(t)
    return mapOf(result to last(result))
}
fun main(args: Array<String>) {
    val list = myList(1, 2, 3)
    val list1 = myListAndLen(1, 2, 3)
    val list2 = myListAndLen(1, 2, 3,4,len = 4)

    val a = arrayOf(1, 2, 3,4,5)
    val list3 = myListAndLastElement(*a){it->it[it.size-1]}
    println(list)
    println(list1)
    println(list2)
    println(list3)
}