package entities

import colors.Colors
import csstype.Color
import react.Props

interface Theme {
    val backgroundColor: Color
    val fontColor: Color
}

external interface ThemeProps: Props {
    var theme: Theme
}

val DarkTheme: Theme = object : Theme {
    override val backgroundColor: Color = Colors.BLACK_GRAY.color
    override val fontColor: Color = Colors.WHITE.color
}

val LightTheme: Theme = object : Theme {
    override val backgroundColor: Color = Colors.GRAY.color
    override val fontColor: Color = Colors.BLACK_GRAY.color
}

fun inverseTheme(theme: Theme): Theme {
    return when(theme) {
        DarkTheme -> LightTheme
        LightTheme -> DarkTheme
        else -> throw IllegalArgumentException("The Theme $theme is not supported.")
    }
}