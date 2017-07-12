package kot.fjy.examples

/**
 * Created by fujia on 2017/7/11.
 */
//Named Arguments,just see how the function is called in the main function.
//Note that the named argument syntax cannot be used when calling Java functions,
//because Java bytecode does not always preserve names of function parameters.

fun reformat(str: String,
             normalizeCase: Boolean = true,
             upperCaseFirstLetter: Boolean = true,
             divideByCamelHumps: Boolean = false,
             wordSeparator: Char = ' ') {
    println("str is $str,normalizeCase is $normalizeCase,upperCaseFirstLetter is $upperCaseFirstLetter,divideByCamelHumps is $divideByCamelHumps,wordSeparator is $wordSeparator")
}
fun main(args: Array<String>) {
    val str = "heihei"
    reformat(str)
    reformat(str, true, true, false, '_')
    reformat(str,
            normalizeCase = true,
            upperCaseFirstLetter = true,
            divideByCamelHumps = false,
            wordSeparator = '_'
    )
    reformat(str, wordSeparator = '_')
    reformat(str, divideByCamelHumps =true)
}

