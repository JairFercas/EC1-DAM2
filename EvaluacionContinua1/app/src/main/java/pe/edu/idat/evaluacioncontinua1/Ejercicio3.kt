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
fun Pregunta3(){
    //componente1
    Box(
        Modifier
            .fillMaxSize()
            .padding(top = 30.dp)){

        var entero by rememberSaveable {
            mutableStateOf("")
        }

        var resultado by rememberSaveable {
            mutableStateOf("")
        }

        //Componente1.1
        Column {
            //Componente1.1.1
            Text(text = "Letras por Numero", textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
            //Componente1.1.2
            espacio(tamanio = 10)
            //Componente1.1.3
            OutlinedTextField(value = entero, onValueChange = {entero=it}, modifier = Modifier.fillMaxWidth(), label = { Text(text = "Ingrese un numero entero") }, maxLines = 1, singleLine = true, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
            //Componente1.1.4
            espacio(tamanio = 10)
            //Componente1.1.5
            Button(onClick = {resultado = calcularVocal(entero.toInt())}, modifier = Modifier.fillMaxWidth()) {
                //Componente1.1.5.1
                Text(text = "CALCULAR")
            }
            //Componente1.1.6
            espacio(tamanio = 10)
            //Componente1.1.7
            Text(text = resultado)
        }
    }
}

fun calcularVocal(entero: Int): String {
    return when (entero) {
        1 -> "La vocal es A"
        2 -> "La vocal es E"
        3 -> "La vocal es I"
        4 -> "La vocal es O"
        5 -> "La vocal es U"
        else -> "$entero esta fuera de rango"
    }
}