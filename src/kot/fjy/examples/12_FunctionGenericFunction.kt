package kot.fjy.examples

import kotlin.test.todo
//Functions can have generic parameters which are specified using angle brackets before the function name
fun <T> copyList(source: List<T>): List<T> {
    val list = ArrayList<T>()
    for ( t in source) {
        list.add(t )
    }
    return list
}
fun main(args: Array<String>) {
    val numList = listOf(1,2,3,4)
    val listCopy = copyList(numList)
    println(listCopy)
    val strList = listOf("haha","heihei","hehe")
    println(copyList(strList))
    todo { "see Classes and Inheritance" }
}