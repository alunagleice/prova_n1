import java.util.Scanner

fun converterParaCelsius(temperatura: Double): Double {
    return (temperatura - 32) * 5 / 9
}

fun converterParaFahrenheit(temperatura: Double): Double {
    return temperatura * 9 / 5 + 32
}

fun main() {
    val scanner = Scanner(System.`in`)

    print("Digite a unidade de entrada (C para Celsius ou F para Fahrenheit): ")
    val unidadeEntrada = scanner.next().toUpperCase()[0]

    print("Digite o valor da temperatura: ")
    val valorTemperatura = scanner.nextDouble()

    val temperaturaConvertida = when (unidadeEntrada) {
        'C' -> converterParaFahrenheit(valorTemperatura)
        'F' -> converterParaCelsius(valorTemperatura)
        else -> {
            println("Unidade de entrada inválida.")
            return
        }
    }

    println("Temperatura convertida: %.2f".format(temperaturaConvertida))
}