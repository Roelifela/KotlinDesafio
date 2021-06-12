package desafio01

    /*
    Making class Professor as abstract as we are going
    to have object only from professorAdjunto and professorTitular
     */

abstract class Professor(
     open var nome: String,
     open var sobrenome: String,
     open var tempoCasa: Int,
     open var codigoProfessor: Int
) {

    /*
    Overriding equals to reach requirement different Curso can´t have
    same codigoCurso.
     */

    override fun equals(other: Any?): Boolean {

        val diferenteProfessor = other as? Professor

        return when (other) {
            is Professor -> {
                this.codigoProfessor == diferenteProfessor?.codigoProfessor
            }
            else -> {
                return super.equals(other)
            }
        }
    }

    override fun hashCode(): Int {
        var result = nome.hashCode()
        result = 31 * result + sobrenome.hashCode()
        result = 31 * result + tempoCasa
        result = 31 * result + codigoProfessor
        return result
    }
}