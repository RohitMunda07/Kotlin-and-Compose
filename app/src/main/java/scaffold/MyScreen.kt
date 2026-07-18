package scaffold

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyScren() {
    Scaffold(
//        if we don't use topBar then the text would have been sticked to the top edges
        topBar = { TopSection() },
        bottomBar = { BottomSection() },
        floatingActionButton = { FAB() }
    ) { innerPadding ->

        LazyColumn( // LazyColumn is itself a list builder
            modifier = Modifier
                .padding(innerPadding)
        ) {
            items(15) {
                MyScreenContent()
            }
        }
    }
}