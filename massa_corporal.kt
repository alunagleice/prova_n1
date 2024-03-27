import java.util.Scanner

fun calcularIMC(peso: Double, altura: Double): Double {
    return peso / (altura * altura)
}

fun interpretarResultadoIMC(imc: Double, genero: Char) {
    val resultado = when {
        genero == 'M' && imc < 20.7 -> "Abaixo do peso"
        genero == 'M' && imc >= 20.7 && imc < 26.4 -> "Normal"
        genero == 'M' && imc >= 26.4 && imc < 27.8 -> "Sobrepeso"
        genero == 'M' && imc >= 27.8 && imc < 31.1 -> "Obesidade"
        genero == 'M' && imc >= 31.1 -> "Obesidade Mórbida"
        genero == 'F' && imc < 19.1 -> "Abaixo do peso"
        genero == 'F' && imc >= 19.1 && imc < 25.8 -> "Normal"
        genero == 'F' && imc >= 25.8 && imc < 27.3 -> "Sobrepeso"
        genero == 'F' && imc >= 27.3 && imc < 32.3 -> "Obesidade"
        genero == 'F' && imc >= 32.3 -> "Obesidade Mórbida"
        else -> "Valores inválidos"
    }

    println("IMC: %.2f, $resultado".format(imc))
}

fun main() {
    val scanner = Scanner(System.`in`)

    print("Digite o gênero (M ou F): ")
    val genero = scanner.next().toUpperCase()[0]

    print("Digite a altura em metros: ")
    val altura = scanner.nextDouble()

    print("Digite o peso em quilogramas: ")
    val peso = scanner.nextDouble()

    val imc = calcularIMC(peso, altura)
    interpretarResultadoIMC(imc, genero)
}