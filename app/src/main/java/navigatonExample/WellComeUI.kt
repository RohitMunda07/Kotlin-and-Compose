package navigatonExample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

//@Preview(showSystemUi = true, showBackground = true)
@Composable
fun WellComeUI(userName: String, navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("WellCome $userName!!", fontSize = 28.sp, fontWeight = FontWeight.SemiBold)

        Button(
            onClick = {navController.navigate(MyNavRoutes.LoginScreenUI)}
        ) {
            Text("Back to Login Screen")
        }
    }
}