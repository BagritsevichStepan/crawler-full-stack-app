package components.common

import csstype.*
import emotion.react.css
import entities.ThemeProps
import react.FC
import react.Props
import react.dom.html.ReactHTML.img
import react.dom.html.ReactHTML.div

external interface SliderProps: Props {
    var imgs: List<String>
}

external interface ThemeableSliderProps: SliderProps, ThemeProps

val Slider = FC<ThemeableSliderProps> { props ->
    div {
        css {
            marginTop = 3.pct
            width = 100.pct
            height = 60.pct
            backgroundColor = props.theme.backgroundColor

            img {
                width = 100.pct
                height = 100.pct
                objectFit = ObjectFit.cover
                overflow = Overflow.hidden
                filter = opacity(0.7)
            }
        }

        for (img in props.imgs) {
            img {
                src = img
            }
        }
    }
}

val Carousel = FC<SliderProps> { props ->
    div {
        id = "slider"
        css {
            width = 100.vw
            maxHeight = 50.vh
            position = Position.absolute
            bottom = 10.pct
            overflow = Overflow.hidden
            whiteSpace = WhiteSpace.nowrap;
            img {
                filter = opacity(0.3)
                marginLeft = 1.5.pct
                firstChild {
                    marginLeft = 0.px
                }
            }
        }

        for (img in props.imgs) {
            img {
                src = img
            }
        }
    }
}