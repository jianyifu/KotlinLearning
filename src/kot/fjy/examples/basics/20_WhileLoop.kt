package kot.fjy.examples.basics

/**
 * Created by fujianyi on 2017/7/12.
 */

fun main(args: Array<String>) {
    val list = listOf(1, 2, 3)
    var index = 0
    while(index< list.size){
        println(list[index])
        index++
    }

    do {
        index--
        println(list[index])
    }while (index>0)
}