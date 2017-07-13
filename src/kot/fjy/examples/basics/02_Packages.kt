package kot.fjy.examples.basics
//package specification should be at the top of the source file:
/**
 * Created by fujia on 2017/7/11.
 */
//the full name of baz() is kot.fjy.gettingstarted.baz
fun baz(){}
//the full name of Goo is kot.fjy.gettingstarted.Goo
class Goo{}

//Default Imports
//kotlin.*
//kotlin.annotation.*
//kotlin.collections.*
//kotlin.comparisons.* (since 1.1)
//kotlin.io.*
//kotlin.ranges.*
//kotlin.sequences.*
//kotlin.text.*

//Additional packages are imported depending on the target platform:
//
//JVM:
//java.lang.*
//kotlin.jvm.*
//JS:
//kotlin.js.*


//We can import either a single name, e.g.

//import foo.Bar // Bar is now accessible without qualification


//or all the accessible contents of a scope (package, class, object etc):
//
//import foo.* // everything in 'foo' becomes accessible


//If there is a name clash, we can disambiguate by using as keyword to locally rename the clashing entity:
//
//import foo.Bar // Bar is accessible
//import bar.Bar as bBar // bBar stands for 'bar.Bar'


// Kotlin does not have a separate "import static" syntax