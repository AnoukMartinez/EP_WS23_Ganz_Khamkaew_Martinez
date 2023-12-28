class Greeting {
    private val platform = getPlatform()

    fun returnPlatform(): String {
        return platform.name
    }
}