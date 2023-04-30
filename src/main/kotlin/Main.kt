fun main(args: Array<String>) {

    println("Добро пожаловать в программу \"ЗАМЕТКИ!\"")

    val archiveData = ArchiveData(mutableMapOf())
    val menu = Menu()
    var currentMenuSection = MenuSection.ArchiveMenu

    var reply: Any? = ""

    do {
        if (currentMenuSection == MenuSection.ArchiveMenu) {
            reply = menu.createMenu(currentMenuSection, archiveData)
            if (archiveData.archiveMap.contains(reply)) {
                currentMenuSection = MenuSection.NoteMenu
                println("Выбран архив \"$reply\"")
            }
        }
        val receivedName = reply.toString()

        if (currentMenuSection == MenuSection.NoteMenu)
            when (val reply = menu.createMenu(currentMenuSection, archiveData, receivedName)) {
                "Back" -> {
                    currentMenuSection = MenuSection.ArchiveMenu
                }

                "noteCreated" -> {
                    println("Заметка создана!")
                }

                else -> {
                    println("Текст заметки \"$reply\": ")
                    println(archiveData.archiveMap[receivedName]?.notesMap?.get(reply).toString())
                    println("0. Назад")
                    menu.checkPoint(0)
                }
            }

    } while (reply != "Exit")

    println("Вы вышли из программы. До встречи!")


    println("Hello World!")

}