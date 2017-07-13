package kot.fjy.examples

/**
 * Created by fujianyi on 2017/7/12.
 */

fun main(args: Array<String>) {
    //Iterating over a collection:
    val items = listOf("apple", "banana", "kiwi","banana", "avocado", "apple", "kiwi")
    for (item in items) {
        println(item)
    }
    //Checking if a collection contains an object using in operator
    when {
        "orange" in items -> println("juicy")
        "apple" in items -> println("apple is fine too")
    }
    //Using lambda expressions to filter and map collections:
    items.filter { it.startsWith("a") }
            .sortedBy { it }
            .map { it.toUpperCase() }
            .forEach{println(it)}
}