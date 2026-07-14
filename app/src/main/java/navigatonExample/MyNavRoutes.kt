package navigatonExample

import kotlinx.serialization.Serializable

// Sealed class creates a restricted hierarchy
// So it's sub-class can only be defined inside the same file

// Each sealed class has it's own data and behaviour
// Data class is used to pass the values from one route to another
@Serializable
sealed class MyNavRoutes {
    @Serializable
    object LoginScreenUI : MyNavRoutes()

    @Serializable
    object HomeScreenUI : MyNavRoutes()

    @Serializable
    data class WellcomeScreen(var userName: String) : MyNavRoutes()
}