package com.example.app30dias

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.app30dias.ui.theme.App30diasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App30diasTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Aux(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Aux( modifier: Modifier = Modifier) {
    Column (modifier=modifier){
    Text(
        text =  "30 Days of random things",
        style = MaterialTheme.typography.titleMedium,
    )
    var count = 1

    LazyColumn (
        modifier = modifier.fillMaxSize(),

        ) {
        items(DataSource.topics.size) { index ->
            Card(
                modifier = Modifier
                    .padding(end = 30.dp, start = 30.dp, top = 15.dp, bottom = 15.dp)
//                    .wrapContentHeight()
                    .fillMaxSize(),
                shape = RoundedCornerShape(12.dp),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {

                Column (
                    modifier = Modifier.fillMaxWidth()
//                        .height(68.dp)
                    ,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,

                    ) {
                    Text(
                        text =  "Day ${count++}",
                        style = MaterialTheme.typography.bodyMedium,
                    )
                    Text(
                        text =  DataSource.topics[index].idea,
                        style = MaterialTheme.typography.bodyMedium,
                    )
                    Image(
                        painter = painterResource(id = DataSource.topics[index].jpeg),
                        contentDescription = null,
                        modifier = Modifier.fillMaxWidth()
//                            .size(68.dp)
                            .clip(RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Crop
                    )

                    Spacer(modifier = Modifier.width(16.dp))

                    Text(
                        text = DataSource.topics[index].description,
                        style = MaterialTheme.typography.bodyMedium
                    )


                }
            }
        }
    }
    }

}