package kot.fjy.examples

/**
 * Created by fujianyi on 2017/7/12.
 */
fun main(args: Array<String>) {
    var a = 1
    // simple name in template:
    val s1 = "a is $a"
    a = 2
    // arbitrary expression in template:
    val s2 = "${s1.replace("is","was")},now a is $a"
    println(s2)
}