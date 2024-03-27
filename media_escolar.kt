import java.util.Scanner

fun calcularMedia(notas: List<Double>): Double {
    val quantidadeNotas = notas.size
    val somaNotas = notas.sum()
    return somaNotas / quantidadeNotas
}

fun main() {
    val scanner = Scanner(System.`in`)
    print("Digite a quantidade de notas: ")
    var quantidade = scanner.nextInt()

    while (quantidade <= 0) {
        println("A quantidade de notas deve ser um número inteiro positivo.")
        print("Digite a quantidade de notas: ")
        quantidade = scanner.nextInt()
    }

    val notas = mutableListOf<Double>()
    for (i in 1..quantidade) {
        print("Digite a nota $i: ")
        notas.add(scanner.nextDouble())
    }

    val media = calcularMedia(notas)
    println("A média das notas é: %.2f".format(media))
}
