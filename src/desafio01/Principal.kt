package desafio01

fun main() {

    /*
    Initializing DigitalHouseManager
    Running methods according to necessity
     */

    val digitalHouseManager = DigitalHouseManager()

    /*
    Creating objects ProfessorTitular
     */

    digitalHouseManager.registrarProfessorTitular(
        "Arquimedes", "de Siracusa",
        10, 111, "Mobile"
    )

    digitalHouseManager.registrarProfessorTitular(
        "Nicolau", "Copérnico",
        20, 222, "Astronomia"
    )

    /*
   Creating objects ProfessorAdjunto
    */

    digitalHouseManager.registrarProfessorAdjunto(
        "Pitágoras", "de Samo",
        100, 10, 10
    )
    digitalHouseManager.registrarProfessorAdjunto(
        "Isaac", "Newton",
        200, 20, 20
    )

    /*
   Creating objects Curso
    */

    digitalHouseManager.registrarCurso("Full Stack", 20001, 3)
    digitalHouseManager.registrarCurso("Android", 20002, 2)

    /*
   Linking Professores to Curso
    */

    digitalHouseManager.alocarProfessores(20001, 111, 100)
    digitalHouseManager.alocarProfessores(20002, 222, 200)

    /*
   Creating objects Aluno
    */

    digitalHouseManager.registrarAluno("Rodrigo", "Cordeiro", 1000)
    digitalHouseManager.registrarAluno("Eliza", "Tajiri", 2000)
    digitalHouseManager.registrarAluno("Felipe", "Cordeiro", 3000)
    digitalHouseManager.registrarAluno("Larissa", "Cordeiro", 4000)
    digitalHouseManager.registrarAluno("Luby", "Cordeiro", 5000)

    /*
   Linking Alunos to Curso
    */

    digitalHouseManager.matricularAluno(1000, 20001)
    digitalHouseManager.matricularAluno(2000, 20001)

    digitalHouseManager.matricularAluno(3000, 20002)
    digitalHouseManager.matricularAluno(4000, 20002)
    digitalHouseManager.matricularAluno(5000, 20002)

    /*
   Checking if given Codigo Aluno has Matricula
    */

    digitalHouseManager.consultarCursosMatriculado(1000)

}