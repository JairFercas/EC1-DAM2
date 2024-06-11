package pe.edu.idat.evaluacioncontinua1

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun Pregunta4(){
    //componente1
    Box(
        Modifier
            .fillMaxSize()
            .padding(top = 30.dp)){

        var limite by rememberSaveable {
            mutableStateOf("")
        }

        var resultado by rememberSaveable {
            mutableStateOf("")
        }

        //Componente1.1
        Column {
            //Componente1.1.1
            Text(text = "Cubos y Cuartas", textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
            //Componente1.1.2
            espacio(tamanio = 10)
            //Componente1.1.3
            OutlinedTextField(value = limite, onValueChange = {limite=it}, modifier = Modifier.fillMaxWidth(), label = { Text(text = "Ingrese el limite") }, maxLines = 1, singleLine = true, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
            //Componente1.1.6
            espacio(tamanio = 10)
            //Componente1.1.7
            Button(onClick = {resultado = calcularLimite(limite.toInt())}, modifier = Modifier.fillMaxWidth()) {
                //Componente1.1.7.1
                Text(text = "CALCULAR")
            }
            //Componente1.1.8
            espacio(tamanio = 10)
            //Componente1.1.8
            Text(text = resultado)
        }
    }
}

fun calcularLimite(limite: Int): String {
    var cadena=""
    if (limite > 0) {
        for (numero in 1..limite) {

            val cubo = numero * numero * numero
            val cuarta = numero * numero * numero * numero

            cadena += "$numero^3 = $cubo y $numero^4 = $cuarta\n"
        }
        return cadena
    } else {
        return "Error: El límite debe ser un número entero positivo"
    }
}