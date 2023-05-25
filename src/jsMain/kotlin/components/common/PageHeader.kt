package components.common

import csstype.TextTransform
import csstype.pct
import emotion.react.css
import react.FC
import react.Props
import react.dom.html.ReactHTML.h1

external interface TextProps: Props {
    var text: String
}

val PageHeader = FC<TextProps> { props ->
    h1 {
        css {
            textTransform = TextTransform.uppercase
            marginTop = 8.pct
            fontSize = 700.pct
        }

        +props.text
    }
}