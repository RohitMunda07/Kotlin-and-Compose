package jetpackcomposs

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AlertBoxExample() {
    var showDialouge by remember { mutableStateOf(false) }
    var context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 16.dp
            )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Click Me", fontSize = 28.sp)

                IconButton(
                    onClick = { showDialouge = true },
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = Color.DarkGray,
                        contentColor = Color.LightGray
                    )
                ) {
                    Icon(
                        imageVector = Icons.Default.Delete, contentDescription = "Delete",
                        modifier = Modifier.size(35.dp)
                    )
                }
            }
        }

        if (showDialouge) {
            AlertDialog(
                onDismissRequest = { showDialouge = false },
                title = {
                    Text("Delete Item")
                },
                text = {
                    Text("Are you sure to delete this item!")
                },
                confirmButton = {
                    Button(
                        onClick = {
                            Toast.makeText(
                                context,
                                "Item deleted Successfully!",
                                Toast.LENGTH_SHORT
                            ).show()
                            showDialouge = false
                        },
                        colors = ButtonDefaults.buttonColors(
                            contentColor = Color.DarkGray,
                            containerColor = Color.Gray
                        )
                    ) {
                        Text("Delete")
                    }

                },
                dismissButton = {
                    Button(
                        onClick = {
                            showDialouge = false
                        },
                        colors = ButtonDefaults.buttonColors(
                            contentColor = Color.DarkGray,
                            containerColor = Color.LightGray
                        )
                    ) {
                        Text("Cancel")
                    }
                }
            )
        }
    }

}

