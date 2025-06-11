package generic

import java.util.LinkedList
import java.util.Queue

class Generic06 {
    interface Animal

    class Dog: Animal {
        fun bark() {
            println("Woof!")
        }
    }
    class Cat: Animal {
        fun meow() {
            println("Meow!")
        }
    }

    class AnimalShelter<out T: Animal> {
        private val animals: Queue<T> = LinkedList()

//        fun addAnimal(animal: T) {
//            animals.add(animal)
//        }

        fun adoptAnimal(): T? {
            return if (animals.isNotEmpty()) animals.poll() else null
        }
    }

    class AnimalPrison<in T: Animal> {
        private val animals: Queue<T> = LinkedList()

        fun addAnimal(animal: T) {
            animals.add(animal)
        }

//        fun releaseAnimal(): T? {
//            return if (animals.isNotEmpty()) animals.poll() else null
//        }
    }

}

fun main() {
    val dogShelter: Generic06.AnimalShelter<Generic06.Dog> = Generic06.AnimalShelter()
    val animalShelter: Generic06.AnimalShelter<Generic06.Animal> = dogShelter

    val dogPrision: Generic06.AnimalPrison<Generic06.Dog> = Generic06.AnimalPrison()
//    val animalPrison: Generic06.AnimalPrison<Generic06.Animal> = dogPrision as Generic06.AnimalPrison<Generic06.Animal>
}