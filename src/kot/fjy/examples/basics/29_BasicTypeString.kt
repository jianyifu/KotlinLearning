package kot.fjy.examples.basics

/**
 * Created by fujianyi on 2017/7/12.
 */
//Strings are represented by the type String. Strings are immutable.
//Elements of a string are characters that can be accessed by the indexing operation: s[i].
fun main(args: Array<String>) {
//A string can be iterated over with a for-loop:
    val str = "Hello, world!\n"
    for (c in str) {
        print(c+":")
    }

    var text = """
    for (c in "foo")
        print(c)
    """
    print(text)
    text = """
    |Tell me and I forget.
    |Teach me and I remember.
    |Involve me and I learn.
    |(Benjamin Franklin)
    """.trimMargin()

    print(text)

    text = """

    >aaaaaaaaaaaaa.
    >bbbbbbbbbbbbbbbbbb.
    >cccccccccccccccc.
    >dddddddddddddd.
    """.trimMargin(">")
    print(text)

    var price = """
${'$'}9.99
"""
    print(price)
    price="""$9.99"""
    print(price)

}