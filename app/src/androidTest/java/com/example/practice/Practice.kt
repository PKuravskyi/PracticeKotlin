package com.example.practice

import java.util.ArrayDeque
import java.util.LinkedList
import java.util.PriorityQueue
import kotlin.system.measureTimeMillis

class PracticeArrays {
    // 1. Find the maximum element:
    // Write a function that takes an array of integers as input
    // and returns the maximum element in the array.
    fun findMaxElement(arr: IntArray) = arr.max()

    // 2. Reverse array:
    // Write a function that takes an array of strings as input
    // and returns a new array with the elements reversed.
    fun reverseArray(arr: Array<String>) = arr.reversedArray()

    // 3. Sum of elements:
    // Write a function that takes an array of doubles as input
    // and returns the sum of all elements in the array.
    fun sumOfArrayElements(arr: DoubleArray) = arr.sum()

    // 4. Count occurrences:
    // Write a function that takes an array of integers and a target integer as input,
    // and returns the number of occurrences of the target integer in the array.
    fun countOccurrences(arr: IntArray, num: Int) = arr.count { it == num }

    // 5. Merge arrays:
    // Write a function that takes two arrays of integers as input
    // and returns a new array that merges the elements of both arrays, maintaining the order.
    fun mergeArrays(arr1: IntArray, arr2: IntArray) = arr1 + arr2

    // 6. Remove duplicates:
    // Write a function that takes an array of strings as input
    // and returns a new array with duplicates removed.
    fun removeDuplicatesFrom(arr: Array<String>) = arr.toSet().toTypedArray()

    // 7. Rotate array:
    // Write a function that takes an array of integers and a number k as input,
    // and rotates the array to the right by k positions.
    fun rotateToRight(arr: IntArray, k: Int): IntArray {
        val newArr = arr.copyOf()

        for (i in 1..k) {
            val lastEl = newArr.last()
            for (j in newArr.size - 1 downTo 1) {
                // Given        [5, 4, 3, 2, 1] iterations will go as follows:
                // Indexes:      0  1  2  3  4
                // 1. j 4 = 3   [5, 4, 3, 2, 2]
                // 2. j 3 = 2   [5, 4, 3, 3, 2]
                // 3. j 2 = 1   [5, 4, 4, 3, 2]
                // 4. j 1 = 0   [5, 5, 4, 3, 2]
                newArr[j] = newArr[j - 1]
            }
            newArr[0] = lastEl
        }

        return newArr
    }

    // 8. Find missing number:
    // Write a function that takes an array of integers from 1 to n (with one missing number) as input
    // and returns the missing number.
    fun findMissingNum(arr: IntArray): Int? {
        var missingNum: Int? = null

        for (i in 1 until arr.size) {
            if (arr[i] - arr[i - 1] != 1) {
                missingNum = arr[i] - 1
            }
        }

        return missingNum
    }

    // 9. Sort array:
    // Write a function that takes an array of integers as input
    // and returns a new array with the elements sorted in ascending order.
    fun sortAsc(arr: IntArray): IntArray {
        val copiedArr = arr.copyOf()
        var swapped: Boolean

        for (i in arr.indices) {
            swapped = false
            for (j in 1 until arr.size) {
                val firstEl = copiedArr[j - 1]
                val secondEl = copiedArr[j]

                if (firstEl > secondEl) {
                    copiedArr[j - 1] = secondEl
                    copiedArr[j] = firstEl
                    swapped = true
                }
            }

            if (!swapped) {
                break
            }
        }
        return copiedArr
    }

    // 10. Find common elements:
    // Write a function that takes two arrays of integers as input
    // and returns a new array containing the common elements between the two arrays.
    fun findCommon(arr1: IntArray, arr2: IntArray): IntArray {
        if (arr1.contentEquals(arr2)) {
            return arr1
        }

        val commonSet: MutableSet<Int> = mutableSetOf()
        for (i in arr1.indices) {
            for (j in arr2.indices) {
                if (arr1[i] == arr2[j]) {
                    commonSet.add(arr1[i])
                }
            }
        }
        return commonSet.toIntArray()
    }
}

class PracticeArrayLists {

    // 1. ArrayList Operations:
    // Create an ArrayList of strings and add some elements to it.
    // Remove an element at a specific index.
    // Check if a certain element exists in the ArrayList.
    // Iterate over the ArrayList and print each element.
    fun arrayListOperations() {
        val arr: ArrayList<String> = arrayListOf("1. Buy milk", "2. Do homework")
        arr.add("3. Watch movie")
        arr.add("4. Clean room")
        arr.removeAt(1)
        if (arr.contains("2. Do homework")) {
            println("\"2. Do homework\" exists in ArrayList")
        } else println("\"2. Do homework\" item was not found")

        for (i in arr) {
            println(i)
        }
    }

    // 2. Combine ArrayList and LinkedList:
    // Create an ArrayList and add some elements to it.
    // Convert the ArrayList to a LinkedList.
    // Perform some operations (adding, removing, accessing elements) on both the ArrayList
    // and LinkedList and observe the differences in performance.
    fun arrayListAndLinkedListOperations() {
        val arrayList: ArrayList<Int> = arrayListOf(1, 2, 3, 4)
        val linkedList = LinkedList<Int>()

        for (i in arrayList) {
            linkedList.add(i)
        }

        val newArrList = ArrayList<Int>()
        val arrayListTime = measureTimeMillis {
            for (i in 1..1000000) {
                newArrList.add(i)
            }
        }
        val newLinkedList = LinkedList<Int>()
        val linkedListTime = measureTimeMillis {
            for (i in 1..1000000) {
                newLinkedList.add(i)
            }
        }

        println("Added 1000000 items to ArrayList, time: $arrayListTime ms")
        println("Added 1000000 items to LinkedList, time: $linkedListTime ms")
    }
}

class PracticeLinkedLists {

    // 1. LinkedList Operations:
    // Create a LinkedList of integers and add elements to it.
    // Remove the first and last elements from the LinkedList.
    // Insert an element at the beginning and end of the LinkedList.
    // Print the elements of the LinkedList in reverse order.
    fun linkedListOperations() {
        val linkedList: LinkedList<Int> = LinkedList()
        linkedList.add(1)
        linkedList.add(2)
        linkedList.add(3)
        linkedList.add(1, 4)
        linkedList.removeFirst()
        linkedList.removeLast()

        for (i in linkedList) {
            println(i)
        }
    }
}

class PracticeHashMaps {
    // 1. HashMap Operations:
    // Create a HashMap to store the population of several cities.
    // Use the city name as the key and the population as the value.
    // Add at least 5 cities and their populations to the map.
    // Retrieve the population of a specific city using its name.
    // Check if a city exists in the map.
    // Iterate over the map and print each city along with its population.
    fun hashMapOperations() {
        val hashMap = hashMapOf<String, Int>()

        hashMap["Kyiv"] = 3_020_000
        hashMap["Tokyo"] = 37_115_000
        hashMap["Seoul"] = 10_005_000
        hashMap["New-York"] = 7_931_147
        hashMap["London"] = 9_748_000

        println("Population of Kyiv is ${hashMap["Kyiv"]}")
        println("Do we have Moscow in this hash map? - ${hashMap.contains("Moscow")}")

        for ((k, v) in hashMap) {
            println("$k has population of $v million people.")
        }
    }

    // 2. Manipulating Data:
    // Create a HashMap to store the inventory of a store.
    // Add items along with their prices to the map.
    // Update the prices of some items.
    // Remove items that are no longer in stock.
    // Calculate the total value of the remaining inventory.
    fun hashMapManipulating() {
        val hashMap = hashMapOf(
            "Bread" to 15.5f,
            "Eggs" to 3.3f,
            "Milk" to 30.7f,
            "Tomatoes" to 68.0f
        )

        hashMap["Eggs"] = 3.6f
        hashMap.remove("Tomatoes")
        println("HashMap: ${hashMap}. Total value of items: %.2f".format(hashMap.values.sum()))
    }
}

class PracticeLinkedHashMaps {
    // 1. LinkedHashMap Insertion Order:
    // Create a LinkedHashMap to store student names and their corresponding grades.
    // Add several students and their grades to the map.
    // Print the list of students along with their grades. Notice how the insertion order is preserved.
    fun linkedHashMapsOperations() {
        val linkedHash = LinkedHashMap<String, ArrayList<Int>>(100)

        linkedHash["Pavlo"] = arrayListOf(100, 99, 100, 100)
        linkedHash["Yurii"] = arrayListOf(99, 99, 99, 100)
        linkedHash["Denys"] = arrayListOf(5, 6, 5, 68)
        linkedHash["Daryna"] = arrayListOf(100, 100, 100, 99)

        for ((k, v) in linkedHash) {
            println("Student - $k. Grades: $v")
        }
    }

    // 2. LinkedHashMap Access Order:
    // Create a LinkedHashMap with access order enabled.
    // Simulate access to several elements in the map by retrieving their values.
    // Iterate over the map and observe how the iteration order reflects the access order.
    fun linkedHashMapsOperationsAccessOrder() {
        val linkedHashAccess = LinkedHashMap<String, ArrayList<Int>>(100, 0.75f, true)

        linkedHashAccess["Pavlo"] = arrayListOf(100, 99, 100, 100)
        linkedHashAccess["Yurii"] = arrayListOf(99, 99, 99, 100)
        linkedHashAccess["Denys"] = arrayListOf(5, 6, 5, 68)
        linkedHashAccess["Daryna"] = arrayListOf(100, 100, 100, 99)

        println(
            "Daryna and Pavlo have best grades. ${linkedHashAccess["Daryna"]} for Daryna " +
                    "and ${linkedHashAccess["Pavlo"]} for Pavlo"
        )

        for ((k, v) in linkedHashAccess) {
            println("Student - $k. Grades: $v")
        }
    }
}

class PracticeHashSet {
    // 1. HashSet Operations:
    // Create a HashSet to store the names of countries.
    // Add at least 5 country names to the set.
    // Check if a specific country exists in the set.
    // Remove a country from the set.
    // Iterate over the set and print each country name.
    fun hashSetOperations() {
        val hashSet = HashSet<String>()

        hashSet.addAll(listOf("Ukraine", "Japan", "South Korea", "Egypt", "Iceland", "Sweden"))
        println("Is Russia is our hashSet? - ${hashSet.contains("Russia")}")
        hashSet.remove("Egypt")

        for (i in hashSet) {
            println(i)
        }
    }

    // 2. Set Intersection and Union:
    // Create two HashSets to store sets of integers.
    // Add some integers to each set.
    // Find and print the intersection (common elements) of the two sets.
    // Find and print the union (combined elements) of the two sets.
    fun hashSetUnion() {
        val hashSet1 = HashSet<Int>()
        val hashSet2 = HashSet<Int>()

        hashSet1.addAll(listOf(1, 2, 3, 4, 5))
        hashSet2.addAll(listOf(6, 7, 8, 9, 3, 4, 10))

        println("Common elements of $hashSet1 and $hashSet2 are: ${hashSet1.intersect(hashSet2)}")
        println("$hashSet1 + $hashSet2 in union gives us: ${hashSet1.union(hashSet2)}")
    }
}

class PracticeLinkedHashSet {
    // 1. LinkedHashSet Insertion Order:
    // Create a LinkedHashSet to store the names of books.
    // Add several book titles to the set.
    // Print the list of books to observe the insertion order preservation.
    fun linkedHashSetOperations() {
        val linkedHashSet = LinkedHashSet<String>()

        linkedHashSet.addAll(listOf("Life loves you", "Witcher", "Assassin", "Fight Club"))

        for (i in linkedHashSet) {
            println(i)
        }
    }

    // 2. LinkedHashSet Insertion Order:
    // Create a LinkedHashSet to store the names of cities.
    // Add several city names to the set.
    // Access some city names in a specific order (e.g., by printing them).
    // Iterate over the set to observe that the insertion order is still the same
    fun linkedHashSetOrder() {
        val linkedHashSet = LinkedHashSet<String>(100, 0.75f)
        linkedHashSet.addAll(listOf("Kyiv", "Lviv", "Odesa", "Kharkiv", "Ivano-Frankivsk"))

        println("Does \"Lviv\" exist in $linkedHashSet set? - ${linkedHashSet.contains("Kyiv")}")

        for (i in linkedHashSet) {
            println(i)
        }
    }
}

class PracticePriorityQueue {
    // 1. Implement a priority queue using PriorityQueue.
    // Create methods for adding elements with a specified priority
    // and removing the highest-priority element.
    fun priorityQueueOperations() {
        val priorityQueue = PriorityQueue<Int> { a, b ->
            b - a // sort descending
        }

        priorityQueue.offer(5)
        priorityQueue.offer(3)
        priorityQueue.offer(1)
        priorityQueue.offer(2)
        priorityQueue.offer(4)

        while (priorityQueue.isNotEmpty()) {
            println(priorityQueue.poll() ?: "PriorityQueue is empty")
        }
    }
}

class PracticeArrayDeque {
    // 1. Implement a stack using ArrayDeque.
    // Create methods for pushing elements onto the stack, popping elements from the stack,
    // and checking if the stack is empty.
    fun arrayStack() {
        val arrayStack = ArrayDeque<Int>()

        arrayStack.push(5)
        arrayStack.addFirst(4)
        arrayStack.push(3)
        arrayStack.addFirst(2)

        println("Array stack is: $arrayStack")
        arrayStack.pop()
        arrayStack.removeFirst()
        println("Array stack after pop() and removeLast() methods: $arrayStack")
        println("Is array stack empty? - ${arrayStack.isEmpty()}")
    }

    // 2. Implement a queue using ArrayDeque.
    // Create methods for adding elements to the back of the queue (enqueue),
    // removing elements from the front of the queue (dequeue), and checking if the queue is empty.
    fun arrayQueue() {
        val arrayQueue = ArrayDeque<Int>()

        arrayQueue.addLast(5)
        arrayQueue.addLast(4)
        arrayQueue.addLast(3)
        arrayQueue.addLast(2)

        println("Array queue is: $arrayQueue")
        arrayQueue.removeFirst()
        println("Array queue after removeFirst() method: $arrayQueue")
        println("Is array queue empty? - ${arrayQueue.isEmpty()}")
    }

    // 3. Write a program to reverse the elements of an array
    // using a stack implemented with ArrayDeque.
    fun arrayDequeReverse(arr: ArrayDeque<Int>) = arr.reversed()
}

fun main() {
    /*
        Arrays
     */
    // 1
    println("***** Arrays *****")

    val arrays = PracticeArrays()

    val array1 = intArrayOf(5, 4, 10, -10, 0, 2)
    val maxElement = arrays.findMaxElement(array1)
    println("${array1.contentToString()} -----> Max element is: $maxElement")

    // 2
    val array2 = arrayOf("One", "Two", "Three", "Four", "Five")
    val reversedArray = arrays.reverseArray(array2)
    println("${array2.contentToString()} -----> Reversed array: ${reversedArray.contentToString()}")

    // 3
    val array3 = doubleArrayOf(1.5, 2.4, 3.1)
    val sum = arrays.sumOfArrayElements(array3)
    println("${array3.contentToString()} -----> Sum of array is: $sum")

    // 4
    val array4 = intArrayOf(1, 2, 3, 1, 1, 2, 1, 4)
    val count = arrays.countOccurrences(array4, array4[0])
    println("${array4.contentToString()} -----> Number ${array4[0]} occurs: $count times")

    // 5
    val array5One = intArrayOf(9, 8, 7, 6, 5)
    val array5Two = intArrayOf(4, 3, 2, 1)
    val mergedArr = arrays.mergeArrays(array5One, array5Two)
    println(
        "${array5One.contentToString()} & ${array5Two.contentToString()} -----> Merged: " +
                mergedArr.contentToString()
    )

    // 6
    val array6: Array<String> = arrayOf("One", "One", "Two", "Three", "Two", "One")
    val uniqueArr = arrays.removeDuplicatesFrom(array6)
    println("${array6.contentToString()} -----> Unique array: ${uniqueArr.contentToString()}")

    // 7
    val array7 = intArrayOf(5, 4, 3, 2, 1)
    val rotatedArr = arrays.rotateToRight(array7, 3)
    println("${array7.contentToString()} -----> Rotated array: ${rotatedArr.contentToString()}")

    // 8
    val array8 = intArrayOf(1, 2, 3, 5, 6)
    val missingNum = arrays.findMissingNum(array8)
    println("${array8.contentToString()} -----> Missing number is: $missingNum")

    // 9
    val array9 = intArrayOf(3, 1, 4, 5, 2)
    val sortedArr = arrays.sortAsc(array9)
    println("${array9.contentToString()} -----> Sorted array: ${sortedArr.contentToString()}")

    // 10
    val array10One = intArrayOf(1, 2, 3, 4, 5)
    val array10Two = intArrayOf(5, 4, 6, 7, 8)
    val commonArr = arrays.findCommon(array10One, array10Two)
    println(
        "${array10One.contentToString()} & ${array10Two.contentToString()} -----> Array with common items: " +
                commonArr.contentToString()
    )

    /*
        ArrayList
     */
    // 1
    println("\n\n***** ArrayList *****")

    val arrayList = PracticeArrayLists()

    arrayList.arrayListOperations()

    // 2
    println()
    arrayList.arrayListAndLinkedListOperations()

    /*
        LinkedList
    */
    // 1
    println("\n\n***** LinkedList *****")

    val linkedList = PracticeLinkedLists()

    linkedList.linkedListOperations()

    /*
        HashMap
    */
    // 1
    println("\n\n***** HashMap *****")

    val hashMap = PracticeHashMaps()

    hashMap.hashMapOperations()

    // 2
    println()
    hashMap.hashMapManipulating()

    /*
        LinkedHashMap
    */
    // 1
    println("\n\n***** LinkedHashMap *****")

    val linkedHashMap = PracticeLinkedHashMaps()

    linkedHashMap.linkedHashMapsOperations()

    // 2
    println()
    linkedHashMap.linkedHashMapsOperationsAccessOrder()

    /*
        HashSet
    */
    // 1
    println("\n\n***** HashSet *****")

    val hashSet = PracticeHashSet()

    hashSet.hashSetOperations()

    // 2
    println()
    hashSet.hashSetUnion()

    /*
        LinkedHashSet
    */
    // 1
    println("\n\n***** LinkedHashSet *****")

    val linkedHashSet = PracticeLinkedHashSet()

    linkedHashSet.linkedHashSetOperations()

    // 2
    println()
    linkedHashSet.linkedHashSetOrder()

    /*
        PriorityQueue
    */
    // 1
    println("\n\n***** PriorityQueue *****")

    val priorityQueue = PracticePriorityQueue()

    priorityQueue.priorityQueueOperations()

    /*
        ArrayDeque
    */
    // 1
    println("\n\n***** ArrayDeque *****")

    val arrayDeque = PracticeArrayDeque()

    arrayDeque.arrayStack()

    // 2
    println()
    arrayDeque.arrayQueue()

    // 3
    println()
    val dequeArray = ArrayDeque(listOf(4, 5, 6, 7, 8))
    val reversedArr = arrayDeque.arrayDequeReverse(dequeArray)
    println("$dequeArray -----> Reversed queue array: $reversedArr")

}
