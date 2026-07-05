package jetpackcomposs

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposs_text.R

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ImageExample() {
    Image(
        painter = painterResource(R.drawable.temp_img),
        contentDescription = "This is a sample image",
        modifier = Modifier
            .background(color = Color.Gray)
            .padding(20.dp)
            .size(300.dp)
            .border(width = 8.dp, color = Color.Yellow, shape = (RoundedCornerShape(20.dp)))
            .clip(shape = RoundedCornerShape(20.dp)),
            contentScale = ContentScale.FillBounds // Read more about this property
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
 fun IconsExample() {
     Column(
         modifier = Modifier.fillMaxSize(),
         horizontalAlignment = Alignment.CenterHorizontally,
         verticalArrangement = Arrangement.Center
     ) {

         Icon(
             imageVector = Icons.Default.Person,
             contentDescription = "Person Icon",
             tint = Color.Green,
             modifier = Modifier.size(150.dp)
         )
     }
}