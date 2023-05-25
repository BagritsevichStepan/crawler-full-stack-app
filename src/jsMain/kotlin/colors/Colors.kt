package colors

import csstype.Color
import csstype.NamedColor
import csstype.rgb

internal enum class Colors(val color: Color) {
    BLACK_GRAY(rgb(32, 32, 32)),
    GRAY(rgb(217, 217, 217)),
    WHITE(NamedColor.white)
}