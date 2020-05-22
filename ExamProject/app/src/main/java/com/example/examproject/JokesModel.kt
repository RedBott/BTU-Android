package com.example.examproject

class JokesModel {
    var category = ""
    var type = ""
    var setup = ""
    var delivery = ""
    lateinit var flags:MutableList<Flags>
    var id = 0
    var error = false
    class Flags{
        var nsfw = false
        var religious = false
        var political = false
        var racist = false
        var sexist = false
    }

}
