package fr.tears.customView

data class MagicCircle(val maxX: Int, val maxY: Int)
{
    var cx= 50f
    var cy= 50f
    val rad= 40F
    var color = App.sColors[App.sColors.indices.random()]
    companion object{
        const val DELTA = 9
    }
    var dx = DELTA
    var dy = DELTA

    fun move(){
        when
        {
            cx.toInt() !in 0..maxX -> dx = -dx
            cy.toInt() !in 0..maxY -> dy = -dy
        }
        cx+= dx
        cy+= dy
    }

    fun moveTo(x: Float,y:Float){
        cx=x
        cy=y
    }
}