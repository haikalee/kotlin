@file:kotlin.jvm.JvmMultifileClass
@file:kotlin.jvm.JvmName("SetsKt")
@file:kotlin.jvm.JvmVersion

package kotlin.collections

//
// NOTE THIS FILE IS AUTO-GENERATED by the GenerateStandardLib.kt
// See: https://github.com/JetBrains/kotlin/tree/master/libraries/stdlib
//

import kotlin.*
import kotlin.text.*
import kotlin.comparisons.*

/**
 * Returns a set containing all elements of the original set except the given [element].
 * 
 * The returned set preserves the element iteration order of the original set.
 */
public operator fun <T> Set<T>.minus(element: T): Set<T> {
    val result = LinkedHashSet<T>(mapCapacity(size))
    var removed = false
    return this.filterTo(result) { if (!removed && it == element) { removed = true; false } else true }
}

/**
 * Returns a set containing all elements of the original set except the elements contained in the given [elements] array.
 * 
 * The returned set preserves the element iteration order of the original set.
 */
public operator fun <T> Set<T>.minus(elements: Array<out T>): Set<T> {
    val result = LinkedHashSet<T>(this)
    result.removeAll(elements)
    return result
}

/**
 * Returns a set containing all elements of the original set except the elements contained in the given [elements] collection.
 * 
 * The returned set preserves the element iteration order of the original set.
 */
public operator fun <T> Set<T>.minus(elements: Iterable<T>): Set<T> {
    val other = elements.convertToSetForSetOperationWith(this)
    if (other.isEmpty())
        return this.toSet()
    if (other is Set)
        return this.filterNotTo(LinkedHashSet<T>()) { it in other }
    val result = LinkedHashSet<T>(this)
    result.removeAll(other)
    return result
}

/**
 * Returns a set containing all elements of the original set except the elements contained in the given [elements] sequence.
 * 
 * The returned set preserves the element iteration order of the original set.
 */
public operator fun <T> Set<T>.minus(elements: Sequence<T>): Set<T> {
    val result = LinkedHashSet<T>(this)
    result.removeAll(elements)
    return result
}

/**
 * Returns a set containing all elements of the original set except the given [element].
 * 
 * The returned set preserves the element iteration order of the original set.
 */
@kotlin.internal.InlineOnly
public inline fun <T> Set<T>.minusElement(element: T): Set<T> {
    return minus(element)
}

/**
 * Returns a set containing all elements of the original set and then the given [element] if it isn't already in this set.
 * 
 * The returned set preserves the element iteration order of the original set.
 */
public operator fun <T> Set<T>.plus(element: T): Set<T> {
    val result = LinkedHashSet<T>(mapCapacity(size + 1))
    result.addAll(this)
    result.add(element)
    return result
}

/**
 * Returns a set containing all elements of the original set and the given [elements] array,
 * which aren't already in this set.
 * 
 * The returned set preserves the element iteration order of the original set.
 */
public operator fun <T> Set<T>.plus(elements: Array<out T>): Set<T> {
    val result = LinkedHashSet<T>(mapCapacity(this.size + elements.size))
    result.addAll(this)
    result.addAll(elements)
    return result
}

/**
 * Returns a set containing all elements of the original set and the given [elements] collection,
 * which aren't already in this set.
 * The returned set preserves the element iteration order of the original set.
 */
public operator fun <T> Set<T>.plus(elements: Iterable<T>): Set<T> {
    val result = LinkedHashSet<T>(mapCapacity(elements.collectionSizeOrNull()?.let { this.size + it } ?: this.size * 2))
    result.addAll(this)
    result.addAll(elements)
    return result
}

/**
 * Returns a set containing all elements of the original set and the given [elements] sequence,
 * which aren't already in this set.
 * 
 * The returned set preserves the element iteration order of the original set.
 */
public operator fun <T> Set<T>.plus(elements: Sequence<T>): Set<T> {
    val result = LinkedHashSet<T>(mapCapacity(this.size * 2))
    result.addAll(this)
    result.addAll(elements)
    return result
}

/**
 * Returns a set containing all elements of the original set and then the given [element] if it isn't already in this set.
 * 
 * The returned set preserves the element iteration order of the original set.
 */
@kotlin.internal.InlineOnly
public inline fun <T> Set<T>.plusElement(element: T): Set<T> {
    return plus(element)
}

