class Menu {

    fun createMenu(menuSection: MenuSection, archiveData: ArchiveData, archiveName: String = ""): Any? {

        println("--------------")
        println(menuSection.sectionName)
        println("--------------")
        println("Выберите пункт меню: ")

        when (menuSection) {

            MenuSection.ArchiveMenu -> {
                var point = 1
                println("0. ${menuSection.firstPoint()}")
                for (archive in archiveData.archiveMap) {
                    println("$point. ${archive.key}")
                    point++
                }
                println("${point}. Выход из программы")
                val pointMenu = checkPoint(point)
                return when (pointMenu) {
                    0 -> {
                        archiveData.makeArchive()
                        "archiveСreated"
                    }
                    point -> "Exit"
                    else -> archiveData.archiveMap.keys.toList()[pointMenu - 1]
                }
            }

            MenuSection.NoteMenu -> {
                var point = 1
                println("0. ${menuSection.firstPoint()}")
                for (note in archiveData.archiveMap[archiveName]!!.notesMap) {
                    println("$point. ${note.key}")
                    point++
                }
                println("${point}. Назад")
                val pointMenu = checkPoint(point)
                return when (pointMenu) {
                    0 -> {
                        archiveData.archiveMap[archiveName]?.makeNote()
                        "noteCreated"
                    }
                    point -> "Back"
                    else -> archiveData.archiveMap[archiveName]?.notesMap?.keys?.toList()?.get(pointMenu - 1)
                }
            }

            else -> return 0

        }

    }

    fun checkPoint(point: Int): Int {
        while (true) {
            if (input.hasNextInt()) {
                val selectPoint = input.nextInt()
                if (selectPoint in 0..point) {
                    return selectPoint
                } else {
                    println("Пункт меню не найден! Введите другое число.")
                }
            } else {
                println("Вы ввели не число! Пожалуйста, введите число.")
                input.next()
            }
        }

    }

}
