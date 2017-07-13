package kot.fjy.examples

/**
 * Created by fujianyi on 2017/7/12.
 */

//Any expression in Kotlin may be marked with a label.
//Labels have the form of an identifier followed by the @ sign,
//for example: abc@, fooBar@ are valid labels (see the grammar).
//To label an expression, we just put a label in front of it

fun main(args: Array<String>) {


    loopOne@ for (i in 1..100) {
        loopTwo@ for (j in 1..100) {
            if (i == 8) {
                break@loopOne
            }else if(i == 2){
                continue@loopOne
            }
            if (j == 5) {
                break@loopTwo
            }
            println("i is $i ,j is $j")
        }
    }
}