package components.common

import csstype.*
import react.FC
import react.Props
import emotion.react.css
import entities.MenuLink
import entities.MenuLinks
import react.dom.html.ReactHTML.a
import react.dom.html.ReactHTML.hr
import react.dom.html.ReactHTML.ul
import react.dom.html.ReactHTML.li

external interface MenuLinksProps: Props {
    var menuLinks: List<MenuLink>
}

external interface MenuProps: MenuLinksProps {
    var currentPage: MenuLink
}

val Menu = FC<MenuProps> { props ->
    ul {
        css {
            float = Float.right
            display = Display.inline

            li {
                display = Display.inlineBlock
                marginLeft = 1.3.em

                firstChild {
                    marginLeft = 0.px
                }

                a {
                    display = Display.inline
                }

                hr {
                    width = 55.pct
                    border = Border(1.px, LineStyle.solid)
                    filter = opacity(0.7)
                    margin = Margin(0.5.em, 0.px, 0.px, 0.px)
                }
            }
        }

        for (menuLink in props.menuLinks) {
            MenuButton {
                href = menuLink.href
                text = menuLink.text
                addHr = menuLink == props.currentPage
                display = addHr || (menuLink == MenuLinks.SIGN_UP.menuLink && props.currentPage != MenuLinks.SIGN_IN.menuLink)
            }
        }
    }
}
