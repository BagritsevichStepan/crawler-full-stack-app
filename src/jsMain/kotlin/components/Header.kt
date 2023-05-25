package components

import components.common.Menu
import components.common.MenuProps
import csstype.*
import emotion.react.css
import react.FC
import react.Props
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.h1

val Header = FC<MenuProps> { props ->
    div {
        css {
            marginTop = 3.0.em
        }

        Logo()
        Menu {
            currentPage = props.currentPage
            menuLinks = props.menuLinks
        }
    }
}

val Logo = FC<Props> {
    h1 {
        css {
            display = Display.inline
        }
        +"Web Crawler"
    }
}