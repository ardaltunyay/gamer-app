package net.altunyay.gamerapp.data.domain

data class Game(
    var id : Long,
    var category : Int,
    var name : String,
    var summary : String,
    var screenshoots : MutableList<Long>
)