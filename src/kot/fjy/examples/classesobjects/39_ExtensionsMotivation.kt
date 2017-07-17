package kot.fjy.examples.classesobjects

/**
 * Created by fujianyi on 2017/7/17.
 */
/**
 * In Java, we are used to classes named "*Utils": FileUtils, StringUtils and so on.
 * The famous java.util.Collections belongs to the same breed.
 * And the unpleasant part about these Utils-classes is that the code that uses them looks like this:
 */
// Java
//Collections.swap(list, Collections.binarySearch(list, Collections.max(otherList)), Collections.max(list))
/**
 *Those class names are always getting in the way. We can use static imports and get this:
 *
 */

// Java
//swap(list, binarySearch(list, max(otherList)), max(list))
/**
 * This is a little better, but we have no or little help from the powerful code completion of the IDE.
 * It would be so much better if we could say
 */

// Java
//list.swap(list.binarySearch(otherList.max()), list.max())
/**
 * But we don't want to implement all the possible methods inside the class List, right? This is where extensions help us.
 */

