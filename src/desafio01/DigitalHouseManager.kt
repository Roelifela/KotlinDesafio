package desafio01

class DigitalHouseManager() {
    var listaAlunos = mutableListOf<Aluno>()
    var listaProfessores = mutableListOf<Professor>()
    var listaCursos = mutableListOf<Curso>()
    var listaMatricula = mutableListOf<Matricula>()

    fun registrarCurso(nome: String, codigoCurso: Int, quantidadeMaximaDeAlunos: Int) {
        val cursoRegistro = Curso(nome, codigoCurso, quantidadeMaximaDeAlunos)

        /*
        Checking if Curso already exists. Adding only
        if Curso is a new one.
         */

        if (listaCursos.contains(cursoRegistro)) {
            println("Curso já existente")
        } else {
            listaCursos.add(cursoRegistro)
            println("Curso - $nome ($codigoCurso) - registrado com sucesso!!!")
        }
    }

    fun excluirCurso(codigoCurso: Int) {

        var cursoExclusao: Curso? = listaCursos.find { it.codigoCurso == codigoCurso }
        if (cursoExclusao != null) {
            listaCursos.remove(cursoExclusao)
            println("Curso $codigoCurso removido com sucesso!!!")
        } else {
            println("Curso $codigoCurso não encontrado!!!")
        }
    }

    fun registrarProfessorAdjunto(
        nome: String,
        sobrenome: String,
        codigoProfessor: Int,
        tempoCasa: Int,
        horasMonitoria: Int
    ) {
        var professorAdjunto = ProfessorAdjunto(nome, sobrenome, tempoCasa, codigoProfessor, horasMonitoria)

        /*
        Checking if Professor Adjunto already exists. Adding only
        if Professor Adjunto is a new one.
         */

        if (listaProfessores.contains(professorAdjunto)) {
            println("Professor existente")
        } else {
            listaProfessores.add(professorAdjunto)
            println("Professor Adjunto ($codigoProfessor - $nome) - Registrado com sucesso!!!")
        }
    }

    fun registrarProfessorTitular(
        nome: String,
        sobrenome: String,
        tempoCasa: Int,
        codigoProfessor: Int,
        especialidade: String
    ) {
        var professorTitular = ProfessorTitular(nome, sobrenome, tempoCasa, codigoProfessor, especialidade)

        /*
        Checking if Professor Adjunto already exists. Adding only
        if Professor Adjunto is a new one.
         */

        if (listaProfessores.contains(professorTitular)) {
            println("Professor existente")
        } else {
            listaProfessores.add(professorTitular)
            println("Professor Titular ($codigoProfessor - $nome) - Registrado com sucesso!!!")
        }
    }

    fun excluirProfessor(codigoProfessor: Int) {
        var professorExclusao: Professor? = listaProfessores.find { it.codigoProfessor == codigoProfessor }
        if (professorExclusao != null) {
            listaProfessores.remove(professorExclusao)
            println("Professor excluido com sucesso")
        } else {
            println("Codigo Professor não encontrado")
        }
    }

    fun registrarAluno(nome: String, sobrenome: String, codigoAluno: Int) {
        var alunoRegistro = Aluno(nome, sobrenome, codigoAluno)

        /*
        Checking if Aluno already exists. Adding only
        if Aluno is a new one.
         */

        if (listaAlunos.contains(alunoRegistro)) {
            println("Aluno existente")
        } else {
            listaAlunos.add(alunoRegistro)
            println("Aluno ($nome - $codigoAluno) - Registrado com sucesso!!!")
        }
    }

    fun matricularAluno(codigoAluno: Int, codigoCurso: Int) {

        /*
        Finding Aluno and Matricula
        if found, add to listaMatricula
         */

        var alunoMatricula = listaAlunos.find { it.codigoAluno == codigoAluno }
        var cursoMatricula = listaCursos.find { it.codigoCurso == codigoCurso }

        if (alunoMatricula != null && cursoMatricula != null) {
            var teste = cursoMatricula.adicionarUmAluno(alunoMatricula)
            if (teste == true) {
                listaMatricula.add(Matricula(alunoMatricula, cursoMatricula))
                println("Matricula efetuada com sucesso - Aluno $codigoAluno")

            } else {
                println("Estourou o limite de alunos no curso")
            }

        } else {
            println("Não foi possivel efetuar a matricula")
        }
    }

    fun alocarProfessores(
        codigoCurso: Int,
        codigoProfessorTitular: Int,
        codigoProfessorAdjunto: Int
    ) {

        /*
        Checking if Curso and professores exists.
         */


        var cursoAlocar = listaCursos.find { it.codigoCurso == codigoCurso }
        var professorTitularAlocar =
            listaProfessores.find { it is ProfessorTitular && it.codigoProfessor == codigoProfessorTitular }
        var professorAdjuntoAlocar =
            listaProfessores.find { it is ProfessorAdjunto && it.codigoProfessor == codigoProfessorAdjunto }

        /*
        Doing some basic validations against ProfessorAdjunto and ProfessorTitular

         */

        if (professorAdjuntoAlocar != null && professorTitularAlocar != null) {

            if (cursoAlocar != null) {
                cursoAlocar.professorTitular = professorTitularAlocar as ProfessorTitular
                println("Professor titular alocado com sucesso - Curso $codigoCurso ")
            } else {
                println("Curso não encontrado - Curso $codigoCurso ")
            }

            if (cursoAlocar != null) {
                cursoAlocar.professorAdjunto = professorAdjuntoAlocar as ProfessorAdjunto
                println("Professor Adjunto alocado com sucesso - Curso $codigoCurso ")
            } else {
                println("Curso não encontrado - Curso $codigoCurso ")
            }

        }

    }

    fun consultarCursosMatriculado(codigoAluno: Int) {

        /*
        Checking if given Aluno exists
         */

        val aluno = listaAlunos.find { it.codigoAluno == codigoAluno }

        /*
        Doing some basic validations and displaying if found.
         */

        if (aluno == null) {
            println("Aluno não está registrado")
        }
        val alunoMatricula = listaMatricula.find { it.aluno.codigoAluno == codigoAluno }
        if (alunoMatricula == null) {
            println("Aluno não está registrado em nenhum curso")
        } else {
            println("Aluno matriculado no curso ${alunoMatricula.curso.nome} - Cod. ${alunoMatricula.curso.codigoCurso}")
        }
    }
}