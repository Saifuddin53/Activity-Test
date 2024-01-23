package com.littlelemon.activitytest

import android.app.ListActivity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.littlelemon.activitytest.model.Affirmation
import com.littlelemon.activitytest.model.DataSource


@Composable
fun ListActivity() {
    val listAffirmation: List<Affirmation> = DataSource().loadAffirmations()
    LazyColumn(modifier = Modifier) {
        items(listAffirmation) { affirmation ->
            ListComponent(affirmation = affirmation,
                modifier = Modifier.padding(8.dp))
        }
    }
}
@Composable
fun ListComponent(affirmation: Affirmation, modifier: Modifier) {
    Card(
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = modifier
    ) {
        Column {
            Text(
                text = affirmation.string,
                fontSize = 48.sp,
                color = Color(0xff89f21f0),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp)
                    .border(width = 2.dp, color = Color(0xff00ff00))
                    .background(color = Color(0xff00f10e0))
                )
            Text(
                text = (affirmation.id).toString(),
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(16.dp)
            )
        }
    }
}

@Preview
@Composable
fun ListComponentPreview() {
    ListComponent(affirmation = Affirmation("First", 2), modifier = Modifier)
}

