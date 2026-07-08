package jetpackcomposs

import android.content.Context
import android.widget.Space
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Label
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ButtonExample() {
    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
                Toast.makeText(
                    context,
                    "Button Clicked",
                    Toast.LENGTH_SHORT
                ).show()
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 16.dp),

            shape = RoundedCornerShape(8.dp),

// we are having two things in button content and container
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Yellow,
                containerColor = Color.Red
            ),

            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 20.dp,
                pressedElevation = 25.dp,
                focusedElevation = 30.dp,
                hoveredElevation = 50.dp
            ),

            border = BorderStroke(5.dp, Color.Black)

        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Person",
//                    modifier = Modifier.padding(end = 10.dp)
                )
// This can be used to provide the space between the elements
                Spacer(Modifier.width(16.dp))

                Text(text = "Click me", fontSize = 25.sp)
            }
        }
    }
}

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreen() {

    var username by remember { mutableStateOf(value = "") }
    var password by remember { mutableStateOf(value = "") }
    var context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,

        ) {
        Text(text = "Login Here", fontSize = 32.sp, fontWeight = FontWeight.SemiBold)

        Spacer(Modifier.height(15.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = username,
            onValueChange = {
                username = it
            },
            label = { Text(text = "Username") },
        )

        Spacer(Modifier.height(8.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = password,
            onValueChange = {
                password = it
            },
            label = { Text("Password") },
        )

        Spacer(Modifier.height(10.dp))

        Button(
            onClick = {
                Toast.makeText(
                    context,
                    "Login In",
                    Toast.LENGTH_SHORT
                ).show()
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = Color.Black
            ),
            enabled = username.isNotEmpty() && password.isNotEmpty()
        ) {
            Text(text = "Login", fontSize = 20.sp)
        }

    }
}

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun OutlineButtonExample() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedButton(
            onClick = {},
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Color.Black,
            )
        ) {
            Text(text = "Click me", fontSize = 28.sp)
        }
    }
}

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TextButtonExample() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextButton(
            onClick = {},
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Color.Black,
            )
        ) {
            Text(text = "Forget Password", fontSize = 28.sp)
        }

        Spacer(Modifier.height(12.dp))

        Text(
            text = "Clickable Text",
            fontSize = 28.sp,
            modifier = Modifier.clickable(onClick = {})
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun IconButtonExample() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        IconButton(
            onClick = {},
        ) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Menu Button"
            )
        }

//  icon as a button
        Icon(
            imageVector = Icons.Default.Menu,
            contentDescription = "Menu Button",
            modifier = Modifier.clickable {  }
        )
    }
}

