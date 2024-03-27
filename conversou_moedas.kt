import java.util.Scanner

// Função para converter uma quantia de uma moeda para outra
fun converterMoeda(quantia: Double, moedaOrigem: String, moedaDestino: String): Double {
    val taxaConversao = when {
        moedaOrigem == "BRL" && moedaDestino == "USD" -> 4.95
        moedaOrigem == "BRL" && moedaDestino == "EUR" -> 5.38
        moedaOrigem == "USD" && moedaDestino == "BRL" -> 1 / 4.95
        moedaOrigem == "USD" && moedaDestino == "EUR" -> 1.08
        moedaOrigem == "EUR" && moedaDestino == "BRL" -> 1 / 5.38
        moedaOrigem == "EUR" && moedaDestino == "USD" -> 0.92
        else -> 1.0 // Mesma moeda, não há conversão
    }

    return quantia * taxaConversao
}

fun main() {
    val scanner = Scanner(System.`in`)

    // Lista de moedas disponíveis
    val moedas = mapOf("BRL" to "Real", "USD" to "Dollar", "EUR" to "Euro")

    // Mostrar lista de moedas disponíveis
    println("Moedas disponíveis:")
    for ((codigo, descricao) in moedas) {
        println("$codigo - $descricao")
    }

    // Solicitar moeda de origem
    print("Digite a moeda de origem (BRL, USD, EUR): ")
    val moedaOrigem = scanner.next().toUpperCase()

    // Solicitar moeda de destino
    print("Digite a moeda de destino (BRL, USD, EUR): ")
    val moedaDestino = scanner.next().toUpperCase()

    // Solicitar quantia a ser convertida
    print("Digite a quantia a ser convertida: ")
    val quantia = scanner.nextDouble()

    // Verificar se as moedas são válidas e realizar a conversão
    if (moedaOrigem in moedas.keys && moedaDestino in moedas.keys) {
        val valorConvertido = converterMoeda(quantia, moedaOrigem, moedaDestino)
        println("Valor convertido: %.2f $moedaDestino".format(valorConvertido))
    } else {
        println("Moedas inválidas, verifique e tente novamente.")
    }
}