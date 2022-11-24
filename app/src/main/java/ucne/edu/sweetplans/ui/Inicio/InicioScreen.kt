package ucne.edu.sweetplans.ui.Inicio

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import ucne.edu.sweetplans.R
import ucne.edu.sweetplans.ui.Login.RegistroUsiario

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun IncioScreen( navController: NavHostController){


    val imagen = painterResource(id = R.drawable.sweetplans)

    Scaffold() {
        // Screen content
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter){

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White), contentAlignment = Alignment.TopCenter
            ) {

                Image(
                    painter = imagen,
                    contentDescription = null
                )
            }

            Text(text = "$")

        }
    }

}
