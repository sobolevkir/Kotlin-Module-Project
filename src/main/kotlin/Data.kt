import java.util.Scanner

val input = Scanner(System.`in`)

class NotesData(val notesMap: MutableMap<String, String>) {

    fun makeNote() {
        print("Введите заголовок заметки: ")
        val noteName = input.nextLine()
        print("Введите текст заметки: ")
        val noteText = input.nextLine()
        notesMap[noteName] = noteText
    }

}

class ArchiveData(val archiveMap: MutableMap<String, NotesData>) {

    fun makeArchive() {
        print("Введите название архива: ")
        val archiveName = input.nextLine()
        archiveMap[archiveName] = NotesData(mutableMapOf())
        println("Архив создан!")
    }

}