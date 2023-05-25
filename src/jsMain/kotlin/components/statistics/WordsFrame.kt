package components.statistics

import csstype.*
import react.FC
import react.Props
import emotion.react.css
import model.WordStatistics
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.label
import react.dom.html.ReactHTML.li
import react.dom.html.ReactHTML.p
import react.dom.html.ReactHTML.ul

external interface WordsStatisticsProps: Props {
    var words: List<WordStatistics>
}

val WordsFrame = FC<WordsStatisticsProps> { props ->
    div {
        css {
            fontSize = 1.4.em
            marginLeft = 27.pct

            ul {
                fontSize = 0.7.em
                marginTop = 6.pct
                display = Display.grid

                li {
                    filter = opacity(0.8)
                    marginTop = 10.pct

                    firstChild {
                        marginTop = 0.px
                    }

                    nthChild("2") {
                        marginTop = 0.px
                    }

                    nthChild("even") {
                        marginLeft = 30.pct
                    }

                    p {
                        whiteSpace = WhiteSpace.nowrap
                    }
                }
            }
        }

        label {
            +"Top ${props.words.size} word${if (props.words.size > 1) "s" else ""}"
        }

        ul {
            id = "words-frame"
            for (word in props.words) {
                li {
                    p {
                        +"${word.word} - ${word.statistics} times"
                    }
                }
            }
        }
    }
}