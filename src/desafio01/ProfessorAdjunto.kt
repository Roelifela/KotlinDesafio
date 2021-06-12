package desafio01

class ProfessorAdjunto(
    override var nome: String,
    override var sobrenome: String,
    override var tempoCasa: Int,
    override var codigoProfessor: Int,
    private var horasMonitoria: Int
) : Professor(nome, sobrenome, tempoCasa, codigoProfessor) {


}