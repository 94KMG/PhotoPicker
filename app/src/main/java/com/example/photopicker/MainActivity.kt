package com.example.photopicker

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.photopicker.ui.theme.PhotoPickerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PhotoPickerTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally


    ) {
        var imageId by remember {
            mutableStateOf(R.drawable.istp)
        }
        var imageUri by remember {
            mutableStateOf<Uri?>(null)
        }
        //save

        Image(
            modifier = modifier.height(300.dp),
//            painter = rememberAsyncImagePainter(imageUri),
            painter = painterResource(id = imageId),
            contentDescription = "ISTP"
        )
        Button(onClick = {
//            pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
            when (imageId) {
                R.drawable.istp -> imageId = R.drawable.entj
                R.drawable.entj -> imageId = R.drawable.entp
                R.drawable.entp -> imageId = R.drawable.estp
                R.drawable.estp -> imageId = R.drawable.entj
            }


        }) {
            Text(text = "변경")

        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PhotoPickerTheme {
        MainScreen()
    }
}