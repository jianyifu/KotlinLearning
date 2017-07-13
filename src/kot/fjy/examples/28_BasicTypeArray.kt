package kot.fjy.examples

/**
 * Created by fujianyi on 2017/7/12.
 */

fun main(args: Array<String>) {
    //To create an array
    val array = arrayOf(1, 2, 3)
    for (it in array){
        println(it)
    }

    //the arrayOfNulls() library function can be used to create an array of a given size filled with null elements.
    val strs = arrayOfNulls<String>(5)
    for (i in 0..strs.size-1){
        strs[i]="haha"+i
    }
    println(strs.toList())

    //Another option is to use a factory function that takes the array size and
    //the function that can return the initial value of each array element given its index:
    // Creates an Array<String> with values ["0", "1", "4", "9", "16"]
    val asc = Array(5, { i -> (i * i).toString() })

//    Note: unlike Java, arrays in Kotlin are invariant.
//    This means that Kotlin does not let us assign an Array<String> to an Array<Any>,
//    which prevents a possible runtime failure (but you can use Array<out Any>, see Type Projections).


//    Kotlin also has specialized classes to represent arrays of primitive types without boxing overhead:
//    ByteArray, ShortArray, IntArray and so on.
//    These classes have no inheritance relation to the Array class,
//    but they have the same set of methods and properties.
//    Each of them also has a corresponding factory function:

    val x: IntArray = intArrayOf(1, 2, 3)
    x[0] = x[1] + x[2]
}