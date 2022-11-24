package ucne.edu.sweetplans.ui.Login

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActionScope
import androidx.compose.material.*
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import ucne.edu.sweetplans.R
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import dagger.hilt.android.lifecycle.HiltViewModel
import ucne.edu.sweetplans.ui.navegation.Home
import ucne.edu.sweetplans.ui.navegation.Screen
import ucne.edu.sweetplans.ui.navegation.navegation
import ucne.edu.sweetplans.ui.registroAgenda.ConsultaScreen

@OptIn(ExperimentalUnitApi::class)
//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreen(
    navController: NavController,
    usuarioViewModel: UsuarioViewModel = hiltViewModel(),

    ) {

    var error by rememberSaveable{ mutableStateOf(false) }
    val context = LocalContext.current

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

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.60f)
                .clip(RoundedCornerShape(30.dp, 30.dp))
                .background(Color.White)
                .verticalScroll(rememberScrollState())
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {


            Text(
                text = "Sign In", fontSize = TextUnit(30F, TextUnitType.Sp),
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    letterSpacing = TextUnit(2F, TextUnitType.Sp)
                )
            )
            Spacer(modifier = Modifier.padding(20.dp))

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                OutlinedTextField(
                    value = emailValue.value,
                    onValueChange = { emailValue.value = it },
                    label = { Text(text = "Email") },
                    placeholder = { Text(text = "Email") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(0.8f),
                    /*KeyboardActionScope = { _ , _ ->
                            focusRequester.requestFocus()
                       }*/
                )

                OutlinedTextField(
                    value = passwordValue.value,
                    onValueChange = { passwordValue.value = it },
                    trailingIcon = {
                        IconButton(onClick = {
                            passwordVisibility.value = !passwordVisibility.value
                        }) {
                            Icon(
                                painter = painterResource(id = R.drawable.password_eye_foreground),
                                modifier = Modifier.size(5.dp),
                                contentDescription = null,
                                tint = if (passwordVisibility.value) MaterialTheme.colors.primary else Color.Gray
                            )
                        }
                    },
                    label = { Text("Password") },
                    placeholder = { Text(text = "Password") },
                    singleLine = true,
                    visualTransformation = if (passwordVisibility.value) VisualTransformation.None
                    else PasswordVisualTransformation(),
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .focusRequester(focusRequester = focusRequester),
                    /*onImeActionPerformed = { _, controller ->
                            controller?.hideSoftwareKeyboard()
                        }*/

                )

                Spacer(modifier = Modifier.padding(10.dp))
                OutlinedButton(
                    onClick = {
                        if (!validateEmail(usuarioViewModel.email)) {
                            Toast.makeText(
                                context,
                                "Revise el formato del campo Email",
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                    }
                ) {
                    Button(
                        onClick = {
                                  navController.navigate(Screen.Home.route)
                        }, modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(50.dp)
                    ) {
                        Text(
                            text = "Aceptar",
                            fontSize = TextUnit(20F, TextUnitType.Sp)
                        )

                    }
                }

                Spacer(modifier = Modifier.padding(20.dp))
                Text(
                    text = "Registrar",
                    modifier = Modifier.clickable(
                        onClick = {
                            navController.navigate(Screen.RegistroUsuarios.route)
                        }
                    )
                )
                Spacer(modifier = Modifier.padding(20.dp))
            }

        }

    }
}

fun validateEmail(email: String) : Boolean{
    var patron =  "([a-z0-9]+@[a-z]+\\.[a-z]{2,3})".toRegex()
    return patron.containsMatchIn(email)
}