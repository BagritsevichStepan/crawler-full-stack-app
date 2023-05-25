package pages

import Pages
import components.common.Carousel
import components.Header
import components.Statistics
import csstype.*
import emotion.react.css
import entities.MenuLinks
import entities.Theme
import entities.ThemeProps
import entities.inverseTheme
import react.FC
import react.Props
import react.dom.html.ReactHTML.img
import react.dom.html.ReactHTML.br
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.h1
import react.dom.html.ReactHTML.header
import react.dom.html.ReactHTML.main
import react.dom.html.ReactHTML.p
import react.dom.html.ReactHTML.a


val HomePage = FC<StatisticsPageProps> { props ->
    header  {
        css {
            height = 100.vh
            width = 100.vw
            backgroundColor = props.theme.backgroundColor
            color = props.theme.fontColor
        }

        div {
            css(ClassName("container")) {}

            Header {
                currentPage = MenuLinks.HOME.menuLink
                menuLinks = Pages
            }

            h1 {
                id = "main-header"
                css {
                    textTransform = TextTransform.uppercase
                    textAlign = TextAlign.right
                    letterSpacing = 0.02.em
                    marginTop = 10.pct
                    fontSize = 900.pct
                }

                +"Collect Pages Statistics"
            }

            p {
                css {
                    fontSize = 130.pct
                    marginTop = (-4).em
                    fontWeight = FontWeight.lighter
                    lineHeight = 1.5.em
                }
                +"Crawler finds the most common words and downloads all"
                br()
                +"pictures from users' posts."
            }
        }

        Carousel {
            imgs = (1..5).map { it -> "/static/img/$it.jpg" }.toList()
        }

        GetStarted()
    }

    val mainTheme: Theme = inverseTheme(props.theme)

    main {
        id = "statistics-anchor-id"
        css {
            height = 100.vh
            backgroundColor = mainTheme.backgroundColor
            color = mainTheme.fontColor
        }

        Statistics {
            theme = mainTheme
            words = props.words
            displayHeader = false
        }
    }
}

private val GetStarted = FC<Props> {
    a {
        id = "get-started"
        href = "#statistics-anchor-id"
        css {
            position = Position.absolute
            left = 50.pct
            transform = translatex((-50).pct)
            bottom = 3.pct
            filter = opacity(0.8)
            p {
                fontSize = 0.9.em
            }
            img {
                marginTop = 0.5.em
                width = 32.pct
                display = Display.block
            }
        }
        p {
            +"Get Started"
        }
        img {
            src = "/static/img/arrow.svg"
        }
    }
}