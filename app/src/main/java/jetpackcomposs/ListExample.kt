package jetpackcomposs

import android.graphics.Paint
import androidx.compose.foundation.background
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ListExample() {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        items(20) { index ->
            Text(
                "Item ${index + 1}",
                fontSize = 28.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .background(
                        color = Color.LightGray,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(16.dp)
            )
        }
    }

}

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LazyRowExample() {
    LazyRow(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        items(20) { index ->
            Text(
                "Item ${index + 1}",
                fontSize = 28.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .background(
                        color = Color.LightGray,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(16.dp)
            )
        }
    }
}

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun NestedRowsAndColumn() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp, vertical = 35.dp),
//        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        items(10) { index ->
            Text(
                "Col ${index + 1}",
                fontSize = 28.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .background(
                        color = Color.LightGray,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(16.dp)
            )

            LazyRow(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),

                ) {
                items(10) { index ->
                    Box(
                        modifier = Modifier
                            .size(120.dp)
                            .background(
                                color = Color.LightGray,
                                shape = RoundedCornerShape(20.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            "Row ${index + 1}",
                            fontSize = 28.sp,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier
                                .background(
                                    color = Color.LightGray,
                                    shape = RoundedCornerShape(16.dp)
                                )
                                .padding(16.dp)
                        )
                    }

                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TypesOfItems() {
    var stud = listOf<String>("A", "b", "C", "D")
    Column {
        Row {
            LazyColumn(modifier = Modifier.padding(horizontal = 20.dp, vertical = 30.dp)) {
                item { Text("Header", fontSize = 30.sp) }
            }
        }

        Row {
            LazyColumn(modifier = Modifier.padding(horizontal = 20.dp, vertical = 30.dp)) {
                items(10) { item ->
                    Text("Col ${item + 1}", fontSize = 30.sp)
                }
            }
        }

        Row {
            LazyColumn(modifier = Modifier.padding(horizontal = 20.dp, vertical = 30.dp)) {
                items(stud) { item ->
                    Text("Stud: ${item}", fontSize = 30.sp)
                }
            }
        }

        Row {
            LazyColumn(modifier = Modifier.padding(horizontal = 20.dp, vertical = 30.dp)) {
                itemsIndexed(stud) { ind, name ->
                    Text("${name}: ${ind}", fontSize = 30.sp)
                }
            }
        }
    }

}