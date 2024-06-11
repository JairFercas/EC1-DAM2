package pe.edu.idat.evaluacioncontinua1

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun espacio(tamanio: Int){
    Spacer(modifier = Modifier
        .height(tamanio.dp))
}