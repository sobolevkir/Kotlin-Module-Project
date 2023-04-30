enum class MenuSection(val sectionName: String) {

    ArchiveMenu("РАЗДЕЛ АРХИВЫ"),
    NoteMenu("РАЗДЕЛ ЗАМЕТКИ");

    fun firstPoint(): String {
        return when (this) {
            ArchiveMenu -> "Создать архив"
            NoteMenu -> "Создать заметку"
        }
    }
}
