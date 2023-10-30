// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(var nome: String, val idade: Int)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60, val nivel: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {
    
    val inscritos = mutableSetOf<Usuario>()
    
    fun matricular(usuario: Usuario): String {
        return if (inscritos.add(usuario)) {
            "Usuário ${usuario.nome} matriculado com sucesso na formação ${this.nome}."
        } else {
            "Usuário ${usuario.nome} já está inscrito na formação ${this.nome}."
        }
    }
    
    fun listarUsuarios() {
        println("Lista de usuários inscritos na formação $nome:")
        inscritos.forEach { usuario ->
            println("Nome: ${usuario.nome}, Idade: ${usuario.idade}")
        }
    }
    
     fun desmatricular(usuario: Usuario): String {
        return if (inscritos.remove(usuario)) {
            "Usuário ${usuario.nome} foi desmatriculado da formação ${this.nome}."
        } else {
            "Usuário ${usuario.nome} não se encontra inscrito na formação ${this.nome}."
        }
    }
}

fun main() {
    val formacao = Formacao(
        "Curso de Programação", 
        listOf(
            ConteudoEducacional("Introdução ao Kotlin", nivel = Nivel.BASICO),
            ConteudoEducacional("Estruturas de Dados", nivel = Nivel.INTERMEDIARIO)
        )
    )
    var usuario = Usuario("Tulio", 20)
        println(formacao.matricular(usuario))
        usuario = Usuario("Caio", 23)
        println(formacao.matricular(usuario))
        println(formacao.matricular(usuario) + "\n")
        formacao.listarUsuarios()
        
        println("\n" + formacao.desmatricular(usuario))
        println(formacao.desmatricular(usuario) + "\n")
        formacao.listarUsuarios()
}



