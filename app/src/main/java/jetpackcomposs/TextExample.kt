package jetpackcomposs

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//showSystemUi = true -> this is the part of preview
@Preview(showBackground = true)
@Composable
fun TextExample() {
    Text(
        text = "hello world",
        color = Color.Blue,
        fontSize = 10.sp,
        fontWeight = FontWeight.Bold,
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TextFieldExample() {
//    remember -> remembers the last value
//    mutableStateOf -> it updates say's compose to update the UI whenever it's value got update
    var name by remember {
        mutableStateOf("")
    }

    TextField(
        value = name,
//        1. normal method
//        onValueChange = { newValue ->
//            name = newValue
//        }

//        2. lambda function method
        onValueChange = { name = it },

//        label = { Text(text = "Enter your name") },

        placeholder = { Text(text = "Enter your name") },

        leadingIcon = {
            Text(
                text = "*",
                color = Color.Red,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        },

        trailingIcon = {
            Text(
                text = "#",
                color = Color.Red,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp
            )
        },

        singleLine = true,

//        shape = CircleShape,
        shape = RoundedCornerShape(50.dp),

        colors = TextFieldDefaults.colors(
            unfocusedTextColor = Color.Red,
            focusedTextColor = Color.Green
        )

    )
}


//      similar to TextFieldExample
@Preview(showSystemUi = true)
@Composable
fun OutlineExample() {

    var name by remember {
        mutableStateOf(value = "")
    }

    OutlinedTextField(
        value = name,
        onValueChange = {
            name = it
        },

//        label = { Text(text = "Username")},

        placeholder = { Text(
            text = "Enter your username",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        ) },

        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = Color.Blue,
            focusedBorderColor = Color.Red
        ),

    )
}