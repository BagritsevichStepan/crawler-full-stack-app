import entities.DarkTheme
import entities.LightTheme
import entities.MenuLink
import entities.MenuLinks
import model.*
import react.FC
import react.Props
import react.router.Route
import react.router.Routes
import react.router.dom.BrowserRouter
import pages.*
import react.create

val Pages: List<MenuLink> = MenuLinks.values()
    .map { it.menuLink }

val Words: List<WordStatistics> = arrayListOf(
    WordStatistics("something", 534),
    WordStatistics("text", 117),
    WordStatistics("statistics", 98),
    WordStatistics("collect", 77),
    WordStatistics("laptop", 34)
)

val App = FC<Props> {
    BrowserRouter {
        Routes {
            Route {
                path = MenuLinks.HOME.menuLink.href
                element = HomePage.create {
                    theme = DarkTheme
                    words = Words
                }
            }

            Route {
                path = MenuLinks.STATISTICS.menuLink.href
                element = StatisticsPage.create {
                    theme = LightTheme
                    words = Words
                }
            }

            Route {
                path = MenuLinks.SIGN_IN.menuLink.href
                element = SignInPage.create {
                    theme = LightTheme
                }
            }

            Route {
                path = MenuLinks.SIGN_UP.menuLink.href
                element = SignUpPage.create {
                    theme = DarkTheme
                }
            }
        }
    }
}