package kot.fjy.examples

//In Kotlin functions can be declared at top level in a file,
//meaning you do not need to create a class to hold a function, like languages such as Java, C# or Scala.
//In addition to top level functions, Kotlin functions can also be declared local, as member functions and extension functions.

//Local Functions
//
//Kotlin supports local functions, i.e. a function inside another function

//Local function can access local variables of outer functions (i.e. the closure),
//so in the case above, the visited can be a local variable
fun outer(str:String){
    println("outer function is called ,str outer is $str")
    fun inner(strInner:String){
       println("inner function is called ,str outer is $str")
       println("inner function is called ,str inner is $strInner")
    }
    inner("[This is a string from inner function]")
}
fun main(args: Array<String>) {
    outer("[This is a string from outer function.]")
}