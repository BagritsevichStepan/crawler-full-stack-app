package components.common

import csstype.*
import react.FC
import emotion.react.css
import entities.ThemeProps
import react.dom.html.ReactHTML.div


external interface FormProps: ThemeProps, TextProps {
    var inputs: List<InputData>
}

val Form = FC<FormProps> { props ->
    div {
        css {
            fontSize = 1.4.em
            div {
                marginTop = 1.em
                firstChild {
                    marginTop = 0.px
                }
                lastChild {
                    marginTop = 1.3.em
                    fontSize = 0.8.em
                }
            }
        }

        for (input in props.inputs) {
            Input {
                text = input.text
                placeholder = input.placeHolder
                theme = props.theme
            }
        }

        div {
            Button {
                text = props.text
                theme = props.theme
            }
        }
    }
}
