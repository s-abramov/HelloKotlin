package lections.syntax

import java.lang.Exception



fun lection12() {
    val getSum = {a: Int, b:Int -> a + b}
    val getSum2: (Int, Int) -> Int = {a, b -> a + b}
    val getSquare: (Int) -> Int = {a -> a * a}
    val getSquare2: (Int) -> Int = {it * it}
    println(getSquare(2))
    println(getSquare2(4))
    println(getSum(2, 6))
    println(getSum2(6, 6))
    //1
    val getPerimetr: (Int, Int) -> Int = {a, b -> (a + b) * 2}
    //2
    val sayHello:(String) -> Unit = {println("Hi, $it")}
    //3
    val suedeSort:(Array<Int>) -> Array<Int> = {
        for (i in it.size - 2 downTo 0) {
            for (j in 0..i) {
                if (it[j] < it[j + 1]) {
                    val tmp = it[j]
                    it[j] = it[j + 1]
                    it[j + 1] = tmp
                }
            }
         }
        it
    }
    val sorted = suedeSort(arrayOf(2,2,5,2,6,7,8))
    println()
    sorted.forEach { println(it)}
}

//--------------------------//
fun lection4(){
    val aa: String? = null
    //println(aa!!.length) //exception!!!
    val a: String? = null
    val b: String? = "Avc"
    val c: String? = ""
    val result = (a?.length?:0) + (b?.length?:0) + (c?.length?:0)
}

fun lection6() {
    val tempOfWater = 14
    println(when {
        tempOfWater <= 0 -> "Твердое"
        tempOfWater < 100 -> "Жидкое"
        else -> "Газообразное"
    })
}

fun lection8() {
    var array = arrayOfNulls<Int?>(101)
    for (i in 0 until array.size) {
        array[i] = i
    }
    for (i in array) {
        println(i)
    }
    println()
    for ((index, i) in array.withIndex()) {
        array[index] = i?.times(2)
    }
    for (i in array) {
        println(i)
    }
    println()
    var range = arrayOfNulls<Int?>(601 - 300)

    for ((index, i) in (300..600).withIndex()) {
        range[index] = i
    }
    for (i in range.size - 1 downTo 0 step 5) {
        println(range[i])
    }
}

fun lection9() {
    println()
    println(myMax(2, 3))
    println(anotherMax(2, 4))
    println(myCrop("qwerty"))
    println(mySum(1, 2, 3, 4, 5, 6, 2, 54))
    println()
    var mutableList = mutableListOf<Int>(2, 4, 3532, 3, 2, 2, 7, 7, 2)
    mutableList.forEach(::println)
    val list = myCollectionSort(mutableList)
    println()
    list.forEach(::println)


}

fun myMax(a: Int, b: Int): Int {
    return if (a > b) {
        a
    } else {
        b
    }
}

fun anotherMax(a: Int, b: Int) = if (a > b) a else b

fun myCrop(s: String) = s.substring(0, Math.min(5, s.length))

fun mySum(vararg numbers: Int) : Int {
    var sum = 0;

    for (i in numbers) {
        sum += i;
    }
    return sum
}

fun myCollectionSort(numbers: MutableList<Int>): List<Int> {
    for (i in 0..numbers.size - 2) {
        for (j in 0..numbers.size - i - 2) {
            if (numbers[j] > numbers[j + 1]) {
                val tmp = numbers[j];
                numbers[j] = numbers[j + 1];
                numbers[j + 1] = tmp;
            }
        }
    }
    return numbers
}

fun myCollectionSort(numbers: Array<Int>) = myCollectionSort(numbers.toMutableList())
fun myCollectionSort(vararg numbers: Int) = myCollectionSort(numbers.toMutableList())

fun lection10() {
    printInfo("Ivanov", "Ivan", "")
    printInfo("BB", "King")
    printInfo("", "Sting")
    printInfo(patronymic = "Middle")

    println(volumeOfFigure(13))
    println(volumeOfFigure(12, 7))
    println(volumeOfFigure(12, 7, 2))
}

fun printInfo(lastname: String = "", name: String = "", patronymic: String = "") {
    if (lastname.isNotEmpty())
        println("Фамилия $lastname")
    if (name.isNotEmpty())
        println("Имя $name")
    if (!patronymic.isEmpty())
        println("Отчество $patronymic")
}

//fun lections.syntax.printInfo(lastname: String, name: String) = lections.syntax.printInfo(lastname, name, "")

fun volumeOfFigure(a: Int, b: Int = a, c: Int = a)  = a * b * c

fun lection11() {
    println(sum11("12", "2"))
    println(sum111("12", "a"))
    println(sum111("12", "4"))
}

fun sum11(a: String, b: String): Int {
    val numA = a.toInt()
    val numB = b.toInt()
    return numA + numB
}
fun sum111(a: String, b: String): Int {
    val res = try {
        val numB = b.toInt()
        val numA = a.toInt()
        numA + numB
    } catch (e: Exception) {
        return -1;
    }
    println("$res!")
    return res
}