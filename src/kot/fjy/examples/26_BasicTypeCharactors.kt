package kot.fjy.examples

/**
 * Created by fujianyi on 2017/7/12.
 */
//Characters are represented by the type Char. They can not be treated directly as numbers
//Character literals go in single quotes: '1'. Special characters can be escaped using a backslash.
//following escape sequences are supported: \t, \b, \n, \r, \', \", \\ and \$.
//To encode any other character, use the Unicode escape sequence syntax: '\uFF00'.
//Like numbers, characters are boxed when a nullable reference is needed.
// Identity is not preserved by the boxing operation.
fun main(args: Array<String>) {
    //We can explicitly convert a character to an Int number:
    fun decimalDigitValue(c: Char): Int {
        if (c !in '0'..'9')
            throw IllegalArgumentException("Out of range")
        return c.toInt() - '0'.toInt() // Explicit conversions to numbers
    }
    println(decimalDigitValue('8'))
}