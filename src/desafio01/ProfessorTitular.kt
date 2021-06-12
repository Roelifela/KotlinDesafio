package desafio01

class ProfessorTitular(
    override var nome: String,
    override var sobrenome: String,
    override var tempoCasa: Int,
    override var codigoProfessor: Int,
    var especialidade: String
) : Professor(nome, sobrenome, tempoCasa, codigoProfessor) {

}