package lections.functional


fun lection13() {
	//filter
	val listOfNumbers = mutableListOf<Int>()
	for (i in 0..99) {
		listOfNumbers.add(i)
	}
	val listOfEvenNumbers = listOfNumbers.filter({ number: Int -> number % 2 == 0 })
	val listOfEvenNumbers2 = listOfNumbers.filter { it % 2 == 0 }
	listOfEvenNumbers.forEach(::println)
	listOfEvenNumbers2.forEach(::println)

	val listOfNames = mutableListOf<String>("Ivan", "Andrew", "Kiriill", "Vladimir", "Anton", "Alexey")
	val listOfNamesWhichStartsFromA = listOfNames.filter { it.startsWith("A") }
	listOfNamesWhichStartsFromA.forEach(::println)
	//map
	val nums = (0..100).toList()
	val employees = nums.map { "Employee №$it"}
	val numsIncreaseTwo = nums.map { it.times(2) }
	numsIncreaseTwo.forEach(::println)
	println("\n" + numsIncreaseTwo.count())
	employees.forEach(::println)

	val array = arrayOf(8, 213, 23 ,3 ,0)
	val sortedArray = array.sorted()
	sortedArray.forEach(::println)

	//homework
	var randomNums = mutableListOf<Int>()
	for (i in 0..999) {
		randomNums.add((0..1000).random())
	}
	val filteredList = randomNums.filter { it % 3 == 0 || it % 5 == 0 }
	val squareNums = filteredList.map {it * it}
	val sortedMap = squareNums.sortedDescending()
	val stringMap = sortedMap.map { "$it" }
	stringMap.forEach(::println)
	println(stringMap.count())

	val radn = mutableListOf<Int>()
	for (i in 0 until 1000) {
		radn.add((Math.random() * 1000).toInt())
	}
	val result = radn.filter { it % 3 == 0 || it % 5 == 0 }.map { it * it }.sortedDescending().map{"$it"}
	result.forEach(::println)
}

fun lection14() {
	val array = (0..1000).toList()
	val employee = array.map { "Employee №$it" }
	val first30 = employee.take(30)
	first30.forEach(::println)
	val last30 = employee.takeLast(30)
	last30.forEach(::println)
	val dropfirst30 = employee.drop(30)
	dropfirst30.forEach(::println)
	val droplast30 = employee.dropLast(30)
	droplast30.forEach(::println)

	//lazy intialize
	val seqArray = generateSequence(0) { it + 2 }
	val evenList = seqArray.take(100)
	evenList.forEach{ println(it)}

	//homework
	val seqEmpArray = generateSequence(1) {it + 1}
	val empArr = seqEmpArray.map { "Employee $it" }.take(100).forEach { println(it) }
}

fun lection15() {
	//zip
	val names = mutableListOf<String>()
	val phones = mutableListOf<Long>()
	for (i in 0..1000) {
		names.add("Имя $i")
		phones.add(79_000_000_000 + (Math.random() * 1_000_000_000).toLong())
	}
	val users = names.zip(phones)
	for (user in users) {
		println("Name: ${user.first} Phone: ${user.second}")
	}

	//homework
	val fullNames = mutableListOf<String>()
	for (i in 0..1000) {
		fullNames.add("Name$i Family$i")
	}
	val name = fullNames.map { it.substringBefore(" ") }
	val lastName = fullNames.map { it.substringAfter(" ") }
	name.forEach(::println)
	lastName.forEach(::println)
	val resNames = name.zip(lastName)
	for (n in resNames) {
		println("Result Name: ${n.second} ${n.first}")
	}

	val anotherNames = fullNames.map { Pair(it.substringBefore(" "), it.substringAfter(" ")) }
	anotherNames.forEach(::println)
}

fun lection16() {
	//FlatMap
	val revenueByWeek = listOf(
		listOf(8,3,4,6,3),
		listOf(4,6,3,2,2),
		listOf(1,3,4,1,3),
		listOf(9,3,4,7,2)
	)
	println(revenueByWeek.flatMap { it }.average())
	println(revenueByWeek.flatten().average())

	val data = mapOf(
		"file1" to listOf(1,2,4),
		"file2" to  listOf(4,-22,4),
		"file3" to listOf(6,3,4)
	)
	println(data.flatMap { it.value }.average())
	val avg = data.filter { it.value.all { it > 0 } }.flatMap { it.value }.average()
	val avg2 = data.filterNot { it.value.any { it < 0 } }.flatMap { it.value }.average()
	println("$avg == $avg2")

}

fun printDataInfo(data: Map<String, List<Int>>) {
	val validData = data.filter { it.value.all { it >= 0 } }
	val avgForWeek = validData.flatMap { it.value }.average()
	val listOfSums = validData.map { it.value.sum() }
	val avgForMonth = listOfSums.average()

	val maxRevenueForMonth = listOfSums.max()
	val maxAtMonth = validData.filter { it.value.sum() == maxRevenueForMonth }.keys
	val minRevenueForMonth = listOfSums.min()
	val minAtMonth = validData.filter { it.value.sum() == minRevenueForMonth }.keys
	val errorsAtMonth = data.filter { it.value.any { it < 0 } }.keys

	println("Average revenue for week: $avgForWeek")
	println("Average revenue for month: $avgForMonth")
	println("Max revenue for month: $maxRevenueForMonth")
	println("Was at next months: $maxAtMonth") // Probably need to use for(){} cycle
	println("Min revenue for month: $minRevenueForMonth")
	println("Was at next months: $minAtMonth") // Probably need to use for(){} cycle
	println("Errors was at next months: $errorsAtMonth")
}

fun lection17() {
	val data = mapOf(
		"January" to listOf(100, 100, 100, 100),
		"February" to listOf(200, 200, -190, 200),
		"March" to listOf(300, 180, 300, 100),
		"April" to listOf(250, -250, 100, 300),
		"May" to listOf(200, 100, 400, 300),
		"June" to listOf(200, 100, 300, 300)
	)
	printDataInfo(data)
}

var name: String? = "asd"
var name2: String? = null

val withList: MutableList<Int>? = mutableListOf()

fun lection18() {

	name?.let {
		if (it.length > 2)
			println("gates")
	}
	name2?.let {
		if (it.length > 2)
			println("stub gates")
	}

	val list = mutableListOf<Int>()
	for (i in 0..1000) {
		list.add(i)
	}
	with(list) {
		println(sum())
		println(average())
		println(max())
		println(min())
	}

	withList?.let {
		with(withList) {
			for (i in 0 until 1000) {
				add((Math.random() * 1000).toInt())
			}
			val result = filter { it % 2 == 0 }.take(100)
			for (i in result) {
				println(i)
			}
		}
	}
}