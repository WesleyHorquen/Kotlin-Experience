import kotlin.random.Random

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String, val matricula: Int, val nivel: Nivel)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        println("\n > Matriculando ${usuario.nome} na formação $nome...")
        inscritos.add(usuario)
        println("${usuario.nome} matriculado com sucesso!")
        println("Nível: ${usuario.nivel}")
        println("Matrícula: ${usuario.matricula}")
    }

    fun listarInscritos() {
        println("\n > Alunos matriculados em '$nome':")
        if (inscritos.isEmpty()) {
            println("> Nenhum aluno matriculado.")
        } else {
            inscritos.forEachIndexed { i, aluno ->
                println("${i + 1}. ${aluno.nome} - Nível: ${aluno.nivel}")
            }
        }
    }
}

fun gerarMatricula(): Int {
    return Random.nextInt(1000, 10000)
}

fun main() {
    // TODO 1: Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.
    // Criei os seguintes conteúdos educacionais:
    val conteudo1 = ConteudoEducacional(" Introdução à Programação", 40)
    val conteudo2 = ConteudoEducacional(" Lógica de Programação", 60)
    val conteudo3 = ConteudoEducacional(" Estruturas de Dados", 90)

    val listaConteudos = listOf(conteudo1, conteudo2, conteudo3)

    // Criei uma formação
    val formacao = Formacao("Formação em Kotlin", listaConteudos)

    // TODO 2: Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.
    println("\n\t---> TESTE DO SISTEMA <---\n")

    // Criando alguns usuários de teste
    val usuario1 = Usuario("Ana Silva", gerarMatricula(), Nivel.BASICO)
    val usuario2 = Usuario("Carlos Santos", gerarMatricula(), Nivel.INTERMEDIARIO)
    val usuario3 = Usuario("Mariana Oliveira", gerarMatricula(), Nivel.DIFICIL)

    println("> Usuários criados para teste:")
    println("1. ${usuario1.nome} - Nível: ${usuario1.nivel}")
    println("2. ${usuario2.nome} - Nível: ${usuario2.nivel}")
    println("3. ${usuario3.nome} - Nível: ${usuario3.nivel}")

    println("\n\t---> REALIZANDO MATRÍCULAS <---")

    // Testando a matrícula
    formacao.matricular(usuario1)
    formacao.matricular(usuario2)
    formacao.matricular(usuario3)

    println("\n\t---> INFORMAÇÕES DA FORMAÇÃO <---\n")
    println("Nome: ${formacao.nome}")
    println("Total de conteúdos: ${formacao.conteudos.size}")
    println("Conteúdos:")
    formacao.conteudos.forEach { conteudo ->
        println("- ${conteudo.nome} (${conteudo.duracao} minutos)")
    }

    // Listando todos os inscritos
    formacao.listarInscritos()

    println("\n > Total de alunos matriculados: ${formacao.inscritos.size}")
}