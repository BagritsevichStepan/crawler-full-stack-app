package components.common

import csstype.*
import emotion.react.css
import entities.ThemeProps
import react.FC
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.label
import react.dom.html.ReactHTML.input

sealed interface InputDesign {
    val text: String
    val placeHolder: String
}

data class InputData(
    override val text: String,
    override val placeHolder: String = "Type here"
): InputDesign

external interface InputProps: ThemeProps, TextProps {
    var placeholder: String
}

val Input = FC<InputProps> { props ->
    div {
        label {
            +props.text
        }

        input {
            css {
                display = Display.block
                border = 0.px
                width = 150.pct
                marginTop = 0.8.em;
                paddingBottom = 0.2.em;

                backgroundColor = props.theme.backgroundColor
                borderBottom = Border(0.01.em, LineStyle.solid, props.theme.fontColor)

                color = props.theme.fontColor
                fontSize = 0.7.em
            }

            placeholder = props.placeholder
        }
    }
}