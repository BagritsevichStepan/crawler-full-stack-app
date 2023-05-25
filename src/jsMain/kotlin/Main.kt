import web.dom.document
import react.createElement
import react.dom.client.createRoot


fun main() {
    val container = document.getElementById("root") ?: error("Couldn't find container!")
    createRoot(container).render(createElement(App))
}