package kot.fjy.examples

/**
 * Created by fujianyi on 2017/7/12.
 */
fun describe(obj: Any) =
        when (obj) {
            1 -> "one"
            "hello" -> "greeting"
            is Long -> "long"
            !is String -> "not a string"
            else -> "unknown"
        }


fun main(args: Array<String>) {
    println(describe(1))
    println(describe("hello"))
    println(describe(200L))
    println(describe(100))
    println(describe(listOf(1)))
}