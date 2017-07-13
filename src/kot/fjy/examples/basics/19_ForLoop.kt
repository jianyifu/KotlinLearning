package kot.fjy.examples.basics

/**
 * Created by fujianyi on 2017/7/12.
 */
//As mentioned before, for iterates through anything that provides an iterator, i.e.
//
//has a member- or extension-function iterator(), whose return type
//has a member- or extension-function next(), and
//has a member- or extension-function hasNext() that returns Boolean.
//All of these three functions need to be marked as operator.

//A for loop over an array is compiled to an index-based loop that does not create an iterator object.
fun main(args: Array<String>) {
    val list = listOf(1, 2, 3)
    for (it in list) println(it)

//If you want to iterate through an array or a list with an index, you can do it this way:
    val items = listOf("haha", "heihie", "heheh")
    for (index in items.indices) {
        println("index $index  is ${items[index]}")
    }
//Alternatively, you can use the withIndex library function:
    for ((index, value) in items.withIndex()) {
        println("the element at $index is $value")
    }
}