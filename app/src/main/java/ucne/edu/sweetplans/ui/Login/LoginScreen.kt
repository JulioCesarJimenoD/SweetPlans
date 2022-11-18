package ucne.edu.sweetplans.ui.Login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import ucne.edu.sweetplans.R

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreen(){

    val image = painterResource(id = R.drawable.sweetplans)
    val emailValue = remember { mutableStateOf("") }
    val passwordValue = remember { mutableStateOf("") }

    val passwordVisibility = remember { mutableStateOf(false) }
    val focusRequester = remember { FocusRequester() }


    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White), contentAlignment = Alignment.TopCenter
        ) {

            Image(
                painter = image,
                contentDescription = null
            )
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally){
            OutlinedTextField(
                value = emailValue.value,
                onValueChange = {emailValue.value = it},
                label = {Text(text = "Email")},
                singleLine = true,
                modifier = Modifier.fillMaxWidth(0.8f)


            )

            OutlinedTextField(
                value = passwordValue.value,
                onValueChange = {passwordValue.value = it},
                trailingIcon = {
                    IconButton(onClick = {
                        passwordVisibility.value = !passwordVisibility.value
                    }) {

                    }
                }
            )
        }

    }

}