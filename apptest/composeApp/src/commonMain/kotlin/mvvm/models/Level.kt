package mvvm.models

class Level(
    val name:String,
    val discovered  :Boolean=false,
    val cleared:Boolean=false
)

// Background dann in Views?

val kevinsHaus = Level("Kevins Haus", false, false)
val omasHaus = Level("Omas Haus", false, false)
val schule = Level("Schule", false, false)
val justinsHaus = Level("Zuhause", false, false)

