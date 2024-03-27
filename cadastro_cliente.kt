import java.util.Scanner

data class Cliente(
    val id: Int,
    var nome: String,
    var dataNascimento: String,
    var sexo: Char,
    var email: String,
    var whatsapp: String,
    var profissao: String
)

class CadastroClientes {
    private var clientes = mutableListOf<Cliente>()
    private var ultimoId = 0

    fun adicionarCliente(nome: String, dataNascimento: String, sexo: Char, email: String, whatsapp: String, profissao: String) {
        ultimoId++
        val cliente = Cliente(ultimoId, nome, dataNascimento, sexo, email, whatsapp, profissao)
        clientes.add(cliente)
    }

    fun listarClientes() {
        if (clientes.isEmpty()) {
            println("Não há clientes cadastrados.")
            return
        }

        println("Lista de Clientes:")
        println("| ID | Nome | Data de Nascimento | Sexo | Email | Whatsapp | Profissão |")
        clientes.forEach {
            println("| ${it.id} | ${it.nome} | ${it.dataNascimento} | ${it.sexo} | ${it.email} | ${it.whatsapp} | ${it.profissao} |")
        }
    }

    fun alterarCliente(id: Int, campo: String, novoValor: String) {
        val cliente = clientes.find { it.id == id }
        cliente?.let {
            when (campo.toLowerCase()) {
                "nome" -> it.nome = novoValor
                "datanascimento" -> it.dataNascimento = novoValor
                "sexo" -> it.sexo = novoValor[0]
                "email" -> it.email = novoValor
                "whatsapp" -> it.whatsapp = novoValor
                "profissao" -> it.profissao = novoValor
                else -> println("Campo inválido.")
            }
        } ?: println("Cliente com ID $id não encontrado.")
    }

    fun removerCliente(id: Int) {
        val clienteRemovido = clientes.removeIf { it.id == id }
        if (clienteRemovido) {
            println("Cliente com ID $id removido com sucesso.")
        } else {
            println("Cliente com ID $id não encontrado.")
        }
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    val cadastroClientes = CadastroClientes()

    while (true) {
        println("\nMenu:")
        println("1. Listar Clientes")
        println("2. Cadastrar Cliente")
        println("3. Alterar Cliente")
        println("4. Remover Cliente")
        println("0. Sair")
        print("Escolha uma opção: ")

        when (scanner.nextInt()) {
            1 -> cadastroClientes.listarClientes()
            2 -> {
                println("Digite os dados do cliente:")
                print("Nome: ")
                val nome = scanner.next()
                print("Data de Nascimento (DD/MM/AAAA): ")
                val dataNascimento = scanner.next()
                print("Sexo (M/F): ")
                val sexo = scanner.next()[0]
                print("Email: ")
                val email = scanner.next()
                print("Whatsapp: ")
                val whatsapp = scanner.next()
                print("Profissão: ")
                val profissao = scanner.next()
                cadastroClientes.adicionarCliente(nome, dataNascimento, sexo, email, whatsapp, profissao)
            }
            3 -> {
                print("Digite o ID do cliente a ser alterado: ")
                val idCliente = scanner.nextInt()
                print("Digite o campo a ser alterado (nome/datadenascimento/sexo/email/whatsapp/profissao): ")
                val campo = scanner.next()
                print("Digite o novo valor: ")
                val novoValor = scanner.next()
                cadastroClientes.alterarCliente(idCliente, campo, novoValor)
            }
            4 -> {
                print("Digite o ID do cliente a ser removido: ")
                val idCliente = scanner.nextInt()
                cadastroClientes.removerCliente(idCliente)
            }
            0 -> {
                println("Saindo do programa.")
                return
            }
            else -> println("Opção inválida, tente novamente.")
        }
    }
}