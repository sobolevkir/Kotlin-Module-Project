class NotesData(val notesMap: MutableMap<String, String>) {

    fun makeNote() {
        print("Введите заголовок заметки: ")
        val noteName = input.next()
        println("Введите текст заметки: ")
        val noteText = input.next()
        notesMap[noteName] = noteText
    }

}

class ArchiveData(val archiveMap: MutableMap<String, NotesData>) {

    fun makeArchive() {
        print("Введите название архива: ")
        val archiveName = input.next()
        archiveMap[archiveName] = NotesData(mutableMapOf())
        println("Архив создан!")
    }

}