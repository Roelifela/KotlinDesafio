package desafio01

class Curso(val nome: String, val codigoCurso: Int, var maximoAlunos: Int) {

    var professorTitular: ProfessorTitular? = null
    var professorAdjunto: ProfessorAdjunto? = null
    var alunos: MutableList<Aluno> = mutableListOf<Aluno>()

    /*
    Overriding equals to reach requirement different Curso can´t have
    same codigoCurso.
     */

    override fun equals(other: Any?): Boolean {

        val cursoDiferente = other as? Curso

        return when (other) {
            is Curso -> {
                this.codigoCurso == cursoDiferente?.codigoCurso
            }
            else -> {
                return super.equals(other)
            }
        }
    }

    override fun hashCode(): Int {
        var result = nome.hashCode()
        result = 31 * result + codigoCurso
        return result
    }

    fun adicionarUmAluno(aluno: Aluno): Boolean {

        /*
        Check against maximoAlunos
        return True if Curso is still available
        return False if it´s full
         */

        if (this.alunos.size >= this.maximoAlunos) {
            return false
        } else if (this.alunos.equals(aluno)) {
            /*
            Call function equals to check
            if aluno already exist.
            */
            println("Aluno já existe no Curso")
            return false
        } else {
            alunos.add(aluno)
            println("Aluno adicionado com sucesso")
            return true
        }
    }

    fun excluirAluno(aluno: Aluno) {
        alunos.remove(aluno)
    }
}