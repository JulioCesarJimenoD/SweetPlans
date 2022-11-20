package ucne.edu.sweetplans.ui.Login

import android.provider.ContactsContract.CommonDataKinds.Email
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import ucne.edu.sweetplans.R
import ucne.edu.sweetplans.ui.navegation.Screen


@OptIn(ExperimentalUnitApi::class)
@Composable
fun RegistroUsiario(
    navHostController: NavHostController,
    usuarioViewModel: UsuarioViewModel = hiltViewModel()
) {

    val image = painterResource(id = R.drawable.registro)

    val nameValue = remember { mutableStateOf("") }
    val emailValue = remember { mutableStateOf("") }
    val phoneValue = remember { mutableStateOf("") }
    val passwordValue = remember { mutableStateOf("") }
    val confirmPasswordValue = remember { mutableStateOf("") }

    val passwordVisibility = remember { mutableStateOf(false) }
    val confirmPasswordVisibility = remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
                contentAlignment = Alignment.TopCenter
        ) {
            Image(
                painter = image,
                contentDescription = null
            )
        }


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.70f)
                .clip(RoundedCornerShape(30.dp, 30.dp))
                .background(Color.White)
                .verticalScroll(rememberScrollState())
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

                Text(
                    text = "Registrate", fontSize = TextUnit(30F, TextUnitType.Sp),
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        letterSpacing = TextUnit(2F, TextUnitType.Sp)
                    )
                )
                Spacer(modifier = Modifier.padding(20.dp))
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    OutlinedTextField(
                        value = nameValue.value,
                        onValueChange = { nameValue.value = it },
                        label = { Text(text = "Nombre") },
                        placeholder = { Text(text = "Nombre") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.8f)
                    )

                    OutlinedTextField(
                        value = emailValue.value,
                        onValueChange = { emailValue.value = it },
                        label = { Text(text = "Email") },
                        placeholder = { Text(text = "Email") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.8f)
                    )

                    OutlinedTextField(
                        value = phoneValue.value,
                        onValueChange = { phoneValue.value = it },
                        label = { Text(text = "Tel.") },
                        placeholder = { Text(text = "Tel.") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.8f),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
                    )

                    OutlinedTextField(
                        value = passwordValue.value,
                        onValueChange = { passwordValue.value = it },
                        label = { Text(text = "Password") },
                        placeholder = { Text(text = "Password") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.8f),
                        trailingIcon = {
                            IconButton(onClick = {
                                passwordVisibility.value = !passwordVisibility.value
                            }) {
                                Icon(
                                    painter = painterResource(id = R.drawable.password_eye_foreground), contentDescription = null,
                                    tint = if (passwordVisibility.value) MaterialTheme.colors.primary else Color.Gray
                                )
                            }
                        },
                        visualTransformation = if (passwordVisibility.value) VisualTransformation.None
                        else PasswordVisualTransformation()
                    )

                    OutlinedTextField(
                        value = confirmPasswordValue.value,
                        onValueChange = { confirmPasswordValue.value = it },
                        label = { Text(text = "Confirmar Contraseña") },
                        placeholder = { Text(text = "Confirmar Contraseña") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.8f),
                        trailingIcon = {
                            IconButton(onClick = {
                                confirmPasswordVisibility.value = !confirmPasswordVisibility.value
                            }) {
                                Icon(
                                    painter = painterResource(id = R.drawable.password_eye_foreground), contentDescription = null,
                                    tint = if (confirmPasswordVisibility.value) MaterialTheme.colors.primary else Color.Gray
                                )
                            }
                        },
                        visualTransformation = if (confirmPasswordVisibility.value) VisualTransformation.None
                        else PasswordVisualTransformation()
                    )
                    Spacer(modifier = Modifier.padding(10.dp))

                    Button(onClick = { }, modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .height(50.dp)) {
                        Text(text = "Registrar", fontSize =  TextUnit(20F, TextUnitType.Sp))
                    }

                    Text(
                        text = "Login",
                        modifier = Modifier.clickable(onClick = {
                            navHostController.navigate(Screen.LoginScreen.route)
                        })
                    )
                    Spacer(modifier = Modifier.padding(20.dp))



                }
        }
    }
}

