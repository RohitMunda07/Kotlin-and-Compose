package navigatonExample

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute

// Route controller and Nav Host
@Composable
fun NavGraph() {
//    navController -> handle Navigation
//    rememberNavController -> create & remember navController
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = MyNavRoutes.LoginScreenUI
    ) {
        composable<MyNavRoutes.LoginScreenUI> {
            LoginScreenUI(navController)
        }

        composable<MyNavRoutes.HomeScreenUI> {
            HomeScreenUI(navController)
        }

        composable<MyNavRoutes.WellcomeScreen> { backStackEntry ->

            val data = backStackEntry.toRoute<MyNavRoutes.WellcomeScreen>()

            WellComeUI(data.userName, navController)
        }
    }
}