package com.example.checkbox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.checkbox.ui.theme.CheckboxTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CheckboxTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CheckboxExample()
                }
            }
        }
    }
}

@Composable
fun CheckboxExample() {

    val resultText = remember {
        mutableStateOf("What is your name?")
    }

    val firstCheckBox = remember {
        mutableStateOf(false)
    }

    val secondCheckBox = remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF2196F3)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.size(150.dp))

        Text(
            text = resultText.value,
            fontSize = 25.sp,
            color = Color.White,
            modifier = Modifier
                .width(300.dp)
                .background(Color(0xFFE91E63))
                .padding(top = 15.dp, bottom = 15.dp),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.size(50.dp))

        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = firstCheckBox.value,
                    onCheckedChange = {
                        firstCheckBox.value = it
                        if (firstCheckBox.value) {
                            resultText.value = "Your gender is male"
                            secondCheckBox.value = false
                        } else {
                            resultText.value = "What is your gender?"
                        }

                    }

                )
                Text(text = "Male", fontSize = 20.sp, color = Color.White)
            }

            Spacer(modifier = Modifier.size(20.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = secondCheckBox.value,
                    onCheckedChange = {
                        secondCheckBox.value = it
                        if (secondCheckBox.value) {
                            resultText.value = "Your gender is female"
                            firstCheckBox.value = false
                        } else {
                            resultText.value = "What is your gender?"
                        }

                    }
                )
                Text(text = "Female", fontSize = 20.sp, color = Color.White)
            }


        }


    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CheckboxTheme {
        CheckboxExample()
    }
}