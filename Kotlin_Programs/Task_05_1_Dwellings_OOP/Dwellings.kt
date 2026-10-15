package com.example.dwellings

import kotlin.math.PI
import kotlin.math.sqrt

/*
INSTRUCTIONS:
1. Click the green Play arrow ▶ next to fun main() -> click Run 'DwellingsKt'
2. Output displays in the Run console at the bottom
*/

fun main() {
    val squareCabin = SquareCabin(6, 50.0)
    val roundHut = RoundHut(3, 10.0)
    val roundTower = RoundTower(4, 15.5)

    with(squareCabin) {
        println("square cabin")
        println("capacity: $capacity")
        println("Material: $buildingMaterial")
        println("Floor area: ${floorArea()}")
    }

    println()
    with(roundHut) {
        println("Round Hut")
        println("Material: $buildingMaterial")
        println("Capacity: $capacity")
        println("Floor Area: ${floorArea()}")
        println("Has Room? ${hasRoom()}")
        getRoom()
        println("Has room? ${hasRoom()}")
        getRoom()
        println("Carpet size: ${calculateMaxCarpetLength()}")
    }

    println()
    with(roundTower) {
        println("Round tower")
        println("Material: $buildingMaterial")
        println("capacity: $capacity")
        println("Floor area: ${floorArea()}")
        println("carpet length: ${calculateMaxCarpetLength()}")
    }
}

abstract class Dwelling(private var residents: Int) {
    abstract val buildingMaterial: String
    abstract val capacity: Int
    abstract fun floorArea(): Double

    fun hasRoom(): Boolean {
        return residents < capacity
    }

    fun getRoom() {
        if (residents < capacity) {
            residents++
            println("you got a room!")
        } else {
            println("Sorry, at capacity and no rooms left")
        }
    }
}

class SquareCabin(residents: Int, val length: Double) : Dwelling(residents) {
    override val buildingMaterial = "Wood"
    override val capacity = 6
    override fun floorArea(): Double {
        return length * length
    }
}

open class RoundHut(residents: Int, val radius: Double) : Dwelling(residents) {
    override val buildingMaterial = "straw"
    override val capacity = 4
    override fun floorArea(): Double {
        return PI * radius * radius
    }

    fun calculateMaxCarpetLength(): Double {
        return sqrt(2.0) * radius
    }
}

class RoundTower(residents: Int, radius: Double, val floors: Int = 2) : RoundHut(residents, radius) {
    override val buildingMaterial = "Stone"
    override val capacity = 4 * floors
    override fun floorArea(): Double {
        return super.floorArea() * floors
    }
}
