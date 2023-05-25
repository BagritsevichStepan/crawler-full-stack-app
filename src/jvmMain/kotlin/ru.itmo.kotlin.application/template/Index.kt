package ru.itmo.kotlin.application.template

import kotlinx.html.*

fun HTML.index() {
    head {
        title("Web Crawler")

        styleLink(url = "/static/css/normalize.css")
        styleLink(url = "/static/css/common.css")
        styleLink(url = "/static/css/font.css")

        link(rel = "preconnect", href = "https://fonts.googleapis.com")
        link(rel = "preconnect", href = "https://fonts.gstatic.com")
        link(href = "https://fonts.googleapis.com/css2?family=Inter:wght@200;300;400&display=swap", rel = "stylesheet")
    }
    body {
        div {
            id = "root"
        }
        script(src = "/static/crawler-full-stack-app.js") {}
    }
}