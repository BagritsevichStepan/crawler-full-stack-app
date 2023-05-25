package components

import Pages
import components.common.Slider
import components.common.Form
import components.common.InputData
import components.common.PageHeader
import components.statistics.WordsFrame
import components.statistics.WordsStatisticsProps
import csstype.*
import emotion.react.css
import entities.DarkTheme
import entities.MenuLinks
import entities.ThemeProps
import react.FC
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.h1

external interface StatisticsProps: WordsStatisticsProps, ThemeProps {
    var displayHeader: Boolean
}

val Imgs = arrayListOf("/static/img/something.jpg")

val Statistics = FC<StatisticsProps> {props ->
    div {
        css(ClassName("container")) {
            height = 100.pct
            overflow = Overflow.hidden
        }

        if (props.displayHeader) {
            Header {
                currentPage = MenuLinks.STATISTICS.menuLink
                menuLinks = Pages
            }
        }

        PageHeader {
            text = "Collect Statistics"
        }

        div {
            css {
                display = Display.inlineFlex
                marginTop = 4.pct
                width = 100.pct
            }

            Form {
                inputs = listOf(
                    InputData("Start from post", "Link to post"),
                    InputData("Search depth")
                )
                text = "Get Statistics"
                theme = props.theme
            }

            WordsFrame {
                words = props.words
            }
        }

        Slider {
            theme = DarkTheme
            imgs = Imgs
        }
    }
}