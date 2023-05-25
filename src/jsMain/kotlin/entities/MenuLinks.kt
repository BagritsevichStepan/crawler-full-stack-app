package entities

interface MenuLink {
    val href: String
    val text: String
}

enum class MenuLinks(val menuLink: MenuLink) {
    HOME(object : MenuLink {
        override val href = "/"
        override val text = "Home"
    }),

    POSTS(object : MenuLink {
        override val href = "/posts"
        override val text = "Posts"
    }),

    STATISTICS(object : MenuLink {
        override val href = "/statistics"
        override val text = "Statistics"
    }),

    SIGN_IN(object : MenuLink {
        override val href = "/sign-in"
        override val text = "Sign in"
    }),

    SIGN_UP(object : MenuLink {
        override val href = "/sign-up"
        override val text = "Sign up"
    })
}