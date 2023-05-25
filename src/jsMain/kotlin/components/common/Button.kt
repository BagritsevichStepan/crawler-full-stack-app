package components.common

import csstype.*
import react.FC
import react.Props
import emotion.react.css
import entities.DarkTheme
import entities.ThemeProps
import react.dom.html.ReactHTML.a
import react.dom.html.ReactHTML.hr
import react.dom.html.ReactHTML.img
import react.dom.html.ReactHTML.li
import react.dom.html.ReactHTML.p
import react.router.useNavigate

external interface ButtonProps: ThemeProps, TextProps

val Button = FC<ButtonProps> { props ->
    a {
        css {
            img {
                height = 0.7.em
                verticalAlign = VerticalAlign.middle
            }
            p {
                display = Display.inline
                marginLeft = 0.5.em
                borderBottom = Border(1.px, LineStyle.solid)
                paddingBottom = 0.05.em
                whiteSpace = WhiteSpace.nowrap
            }
        }
        img {
            src = "/static/img/hor_arrow_${
                if (props.theme == DarkTheme) "white" else "dark"
            }.svg"
        }
        p {
            +props.text
        }
    }
}

external interface MenuButtonProps: ButtonProps {
    var href: String
    var display: Boolean
    var addHr: Boolean
}

val MenuButton = FC<MenuButtonProps> { props ->
    val navigate = useNavigate()
    li {
        a {
            +props.text

            if (props.display) {
                css(ClassName("display")) {}
            }

            onClick = {
                navigate(props.href)
            }
        }

        if (props.addHr) {
            hr()
        }
    }
}