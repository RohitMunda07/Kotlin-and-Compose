import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ModifiresExample() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Red)
            .padding(all = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp) // This provides the spaces between the element inside this column
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Yellow)
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,

            ) {
            Text(text = "Apple", fontSize = 25.sp)
            Text(text = "Banana", fontSize = 25.sp)
            Text(text = "Grapes", fontSize = 25.sp)
        }

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
//                .width(150.dp)
//                .height(150.dp)
                .size(150.dp) // this can be used instead of individual height width
                .border(width = 5.dp, color = Color.White, shape = RoundedCornerShape(20.dp))
                .clickable(onClick = {})
                .background(
                    Color.Blue,
                    shape = RoundedCornerShape(20.dp)
                ),

            ) {
            Text(
                text = "Center",
                fontSize = 35.sp,
                color = Color.White
//                instead of aligning the text form inside we can pass contenAlignment Box
//                    .align(Alignment.Center),
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Yellow)
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,

            ) {
            Text(text = "One", fontSize = 25.sp)
            Text(text = "Two", fontSize = 25.sp)
            Text(text = "Three", fontSize = 25.sp)
        }
    }

}