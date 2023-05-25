package pages

import components.*
import components.statistics.WordsStatisticsProps
import csstype.*
import emotion.react.css
import entities.ThemeProps
import react.FC
import react.dom.html.ReactHTML.header

external interface StatisticsPageProps: WordsStatisticsProps, ThemeProps

val StatisticsPage = FC<StatisticsPageProps> { props ->
    header {
        css {
            height = 100.vh
            width = 100.vw
            backgroundColor = props.theme.backgroundColor
            color = props.theme.fontColor
        }

        Statistics {
            theme = props.theme
            words = props.words
            displayHeader = true
        }
    }
}