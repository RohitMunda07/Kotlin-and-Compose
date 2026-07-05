package jetpackcomposs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//@Preview(showSystemUi = true, showBackground = true)
@Composable
fun RowExample() {
//    without using the row property
//    Text(text = "Apple", fontSize = 25.sp)
//    Text(text = "Banana", fontSize = 25.sp)
//    Text(text = "Grapes", fontSize = 25.sp)

//    using row property
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Mac", fontSize = 25.sp)
        Text(text = "Win", fontSize = 25.sp)
        Text(text = "Android", fontSize = 25.sp)
        Text(text = "Ios", fontSize = 25.sp)
    }

}

//Use fillMaxWidth to make a composable occupy the full width of its parent, fillMaxHeight to fill the full height, and fillMaxSize to take up all available space in both dimensions.

//@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ColumnExample() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Cyan),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Book1", fontSize = 30.sp)
        Text(text = "Book2", fontSize = 30.sp)
        Text(text = "Book3", fontSize = 30.sp)
    }
}

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoinExample() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Login Here", fontSize = 30.sp, fontWeight = FontWeight.SemiBold)

        OutlinedTextField(
            value = "",
            onValueChange = {},
            placeholder = {
                Text(text = "Enter Your Username", fontSize = 20.sp)
            }
        )
        OutlinedTextField(
            value = "",
            onValueChange = {},
            placeholder = {
                Text(text = "Enter Your Password", fontSize = 20.sp)
            }
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BoxExample() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ) {
        Text(
            text = "Note 1",
            fontSize = 30.sp,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .background(Color.Yellow)
                .padding(all = 30.dp)
        )
        Text(
            text = "Note 2",
            fontSize = 30.sp,
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .background(Color.Green)
                .padding(all = 30.dp)
        )
        Text(
            text = "Note 3",
            fontSize = 30.sp,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .background(Color.Red)
                .padding(all = 30.dp)
        )
    }
}