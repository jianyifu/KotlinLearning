package kot.fjy.examples

//When a function returns a single expression, the curly braces can be omitted and the body is specified after a = symbol
fun double(x:Int):Int = x*2
//Explicitly declaring the return type is optional when this can be inferred by the compiler
fun doubleOne(x:Int) = x*2
fun main(args: Array<String>) {
    println(double(100))
    println(doubleOne(200))
}