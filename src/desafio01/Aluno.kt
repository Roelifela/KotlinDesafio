package desafio01

class Aluno(val nome: String, val sobrenome: String, val codigoAluno: Int) {

    /*
    Overriding equals to reach requirement different Aluno can´t have
    same codigoAluno.
     */

    override fun equals(other: Any?): Boolean {
        val alunoDiferente = other as? Aluno

        return when (other) {
            is Aluno -> {
                this.codigoAluno == alunoDiferente?.codigoAluno
            }
            else -> {
                return super.equals(other)
            }
        }
    }

    override fun hashCode(): Int {
        var result = nome.hashCode()
        result = 31 * result + sobrenome.hashCode()
        result = 31 * result + codigoAluno.hashCode()
        return result
    }
}