import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val listaDeCompras = mutableListOf<String>()

    loop@ while (true) {
        println("Menu:")
        println("1. Mostrar lista")
        println("2. Adicionar item")
        println("3. Remover item")
        println("0. Sair")
        print("Escolha uma opção: ")

        when (scanner.nextInt()) {
            1 -> mostrarLista(listaDeCompras)
            2 -> adicionarItem(listaDeCompras, scanner)
            3 -> removerItem(listaDeCompras, scanner)
            0 -> break@loop
            else -> println("Opção inválida, tente novamente.")
        }
    }

    println("Saindo do programa.")
}

fun mostrarLista(lista: List<String>) {
    if (lista.isEmpty()) {
        println("A lista está vazia.")
    } else {
        println("Lista de compras:")
        lista.forEachIndexed { index, item ->
            println("${index + 1}. $item")
        }
    }
}

fun adicionarItem(lista: MutableList<String>, scanner: Scanner) {
    print("Digite o item a ser adicionado: ")
    val item = scanner.next()
    if (lista.contains(item)) {
        println("Este item já está na lista.")
    } else {
        lista.add(item)
        println("Item adicionado com sucesso.")
        mostrarLista(lista)
    }
}

fun removerItem(lista: MutableList<String>, scanner: Scanner) {
    if (lista.isEmpty()) {
        println("A lista está vazia, não há itens para remover.")
        return
    }

    mostrarLista(lista)
    print("Digite o número do item a ser removido: ")
    val indice = scanner.nextInt() - 1
    if (indice >= 0 && indice < lista.size) {
        val itemRemovido = lista.removeAt(indice)
        println("Item \"$itemRemovido\" removido com sucesso.")
        mostrarLista(lista)
    } else {
        println("Índice inválido, tente novamente.")
    }
}