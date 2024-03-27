import kotlin.random.Random

fun gerarSenhaSegura(tamanho: Int): String {
    val letrasMaiusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    val letrasMinusculas = letrasMaiusculas.toLowerCase()
    val numeros = "0123456789"
    val caracteresEspeciais = "!@#\$%^&*()_-+=<>?/[]{},."

    val caracteres = letrasMaiusculas + letrasMinusculas + numeros + caracteresEspeciais

    return (1..tamanho)
        .map { caracteres[Random.nextInt(caracteres.length)] }
        .joinToString("")
}

fun main() {
    var tamanhoSenha: Int
    do {
        print("Digite o tamanho da senha que deseja gerar: ")
        tamanhoSenha = readLine()?.toIntOrNull() ?: 0
    } while (tamanhoSenha <= 0)

    val senhaGerada = gerarSenhaSegura(tamanhoSenha)
    println("Senha gerada: $senhaGerada")
}