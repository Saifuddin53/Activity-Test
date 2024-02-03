package com.littlelemon.activitytest

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun FirstActivity() {

    var count by remember {
        mutableStateOf(0)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
    ){
        TopAppBar(count, onValueChange = {count = count + 1})
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Red)
        ) {
            Button(
                onClick = { count++ },
//                modifier = Modifier.background(Color(0xFF00FF00))
                ) {
                Text(text = "Increment")
                ButtonDefaults.buttonColors(Color(0xff00ff00))
            }
            Text(text = "Hello " + count)
//this is the change
        }
    }
}

@Composable
fun TopAppBar(
    count: Int,
    onValueChange: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color(0xFF00FF00))
    ) {
        IconButton(onClick = onValueChange) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_arrow_drop_down_24),
                contentDescription = "Navigation drawer",
            )
        }
        Text(
            text = stringResource(id = R.string.app_name) + " " + count,
            fontSize = 24.sp
        )
        IconButton(onClick = onValueChange) {
            Icon(
                painter = painterResource(id = R.drawable.share_24px),
                contentDescription = "Share"
            )
        }
    }
}
