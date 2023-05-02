fun main() {

    println("Добро пожаловать в программу \"ЗАМЕТКИ!\"")

    val archiveData = ArchiveData(mutableMapOf())
    val menu = Menu()

    var currentMenuSection = MenuSection.ArchiveMenu
    var reply: Any? = ""
    var receivedName = ""

    do {
        when (currentMenuSection) {
            MenuSection.ArchiveMenu -> {
                reply = menu.createMenu(currentMenuSection, archiveData, receivedName)
                if (archiveData.archiveMap.contains(reply)) {
                    currentMenuSection = MenuSection.NoteMenu
                    println("Выбран архив \"$reply\"")
                    receivedName = reply.toString()
                }
            }
            MenuSection.NoteMenu -> {
                reply = menu.createMenu(currentMenuSection, archiveData, receivedName)
                when (reply) {
                    "Back" -> currentMenuSection = MenuSection.ArchiveMenu
                    "noteCreated" -> println("Заметка создана!")
                    else -> {
                        println("Текст заметки \"$reply\": ")
                        println(archiveData.archiveMap[receivedName]?.notesMap?.get(reply).toString())
                        println("0. Назад")
                        menu.checkPoint(0)
                    }
                }
            }
        }
    } while (reply != "Exit")


    println("Вы вышли из программы. До встречи!")

}