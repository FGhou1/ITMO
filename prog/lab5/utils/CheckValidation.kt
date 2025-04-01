package utils

import java.util.*

class CheckValidation {

    fun readYesOrNo(console: StandardConsole): Boolean {
        while (true) {
            val input = console.readln().trim().lowercase()
            when (input) {
                "yes", "y" -> return true
                "no", "n" -> return false
                else -> console.printer("Пожалуйста, введите 'yes' или 'no'.")
            }
        }
    }

    fun checkInt(console: StandardConsole, number: String): Int {
        while (true) {
            try { return number.toInt()
            } catch (e: NumberFormatException) {
                console.printError("Введите целое число.")
                Thread.sleep(100)
            }
        }
    }

    // Функция для проверки принадлежности значения перечислению (Enum)
    fun <T : Enum<T>> checkEnum(console: StandardConsole, enumClass: Class<T>, enumString : String): T {
        while (true) {
            try { return java.lang.Enum.valueOf(enumClass, enumString.trim().uppercase(Locale.getDefault())) }
            catch (e: IllegalArgumentException) {
                console.printError("Введите одно из следующих значений: ${enumClass.enumConstants.joinToString(", ")}.")
                Thread.sleep(100)
            }
        }
    }

    // Функция для проверки на целое принадлежность Int
    fun readInt(console: StandardConsole): Int {
        while (true) {
            try {
                return console.readln().trim().toInt()
            } catch (e: NumberFormatException) {
                console.printError("Введите целое число.")
                Thread.sleep(100)
            }
        }
    }

    // Функция для проверки на целое принадлежность Long
    fun readLong(console: StandardConsole): Long {
        while (true) {
            try {
                return console.readln().trim().toLong()
            } catch (e: NumberFormatException) {
                console.printError("Введите целое число.")
                Thread.sleep(100)
            }
        }
    }

    // Функция для проверки на не отрицательность
    fun readPositiveInt(console: StandardConsole): Int {
        while (true) {
            try {
                val value = console.readln().trim().toInt()
                if (value >= 0) {
                    return value
                } else {
                    console.printError("Введите положительное число.")
                    Thread.sleep(100)
                }
            } catch (e: NumberFormatException) {
                console.printError("Введите целое число.")
                Thread.sleep(100)
            }
        }
    }

    // Функция для проверки строки на пустоту
    fun readNonEmptyString(console: StandardConsole): String {
        while (true) {
            val input = console.readln().trim()
            if (input.isNotEmpty()) {
                return input
            } else {
                console.printError("Cтрока не должна быть пустой.")
                Thread.sleep(100)
            }
        }
    }

    // Функция для проверки принадлежности значения перечислению (Enum)
    fun <T : Enum<T>> readEnum(console: StandardConsole, enumClass: Class<T>): T {
        while (true) {
            try {
                val input = console.readln().trim().uppercase(Locale.getDefault())
                return java.lang.Enum.valueOf(enumClass, input)
            } catch (e: IllegalArgumentException) {
                console.printError("Введите одно из следующих значений: ${enumClass.enumConstants.joinToString(", ")}.")
                Thread.sleep(100)
            }
        }
    }

    // Функция для проверки правильности паспортных данных
    fun readPassportID(console: StandardConsole) : String{
        while (true) {
            try {
                val value = console.readln().trim()
                if (value.length == 6) { return value
                } else { console.printError("Введите число равное 6")
                    Thread.sleep(100)
                }
            } catch (e: NumberFormatException) {
                console.printError("Введите целое число.")
                Thread.sleep(100)
            }
        }
    }
}