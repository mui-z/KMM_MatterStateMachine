package studio.sekai.matterstatemachine

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform