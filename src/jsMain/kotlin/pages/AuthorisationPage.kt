package pages

import Pages
import colors.Colors
import components.Header
import components.common.Form
import components.common.InputData
import components.common.PageHeader
import components.common.TextProps
import csstype.*
import emotion.react.css
import entities.*
import react.FC
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.header

external interface AuthorisationPageProps: ThemeProps, TextProps {
    var currentPage: MenuLink
    var inputs: List<InputData>
}

private val AuthorisationPage = FC<AuthorisationPageProps> {props ->


    header {
        css {
            height = 100.vh
            width = 100.vw
            backgroundColor = props.theme.backgroundColor
            color = props.theme.fontColor
        }

        div {
            css(ClassName("container")) {}

            Header {
                currentPage = props.currentPage
                menuLinks = Pages
            }

            PageHeader {
                text = props.currentPage.text
            }

            div {
                css {
                    marginTop = 4.pct
                    width = 25.pct
                    if (props.theme == DarkTheme) {
                        fontWeight = FontWeight.lighter
                    }
                }
                Form {
                    inputs = props.inputs
                    text = props.text
                    theme = props.theme
                }
            }
        }
    }
}

val SignInPage = FC<ThemeProps> { props ->
    AuthorisationPage {
        currentPage = MenuLinks.SIGN_IN.menuLink
        inputs = listOf(
            InputData("E-Mail"),
            InputData("Password")
        )
        text = "Sign In"
        theme = props.theme
    }
}

val SignUpPage = FC<ThemeProps> { props ->
    AuthorisationPage {
        currentPage = MenuLinks.SIGN_UP.menuLink
        inputs = listOf(
            InputData("E-Mail"),
            InputData("Password")
        )
        text = "Create Account"
        theme = props.theme
    }
}