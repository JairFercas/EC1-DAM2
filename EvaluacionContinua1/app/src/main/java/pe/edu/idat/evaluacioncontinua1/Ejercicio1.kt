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
fun Pregunta1(){
    //componente1
    Box(
        Modifier
            .fillMaxSize()
            .padding(top = 30.dp)){

        var precio by rememberSaveable {
            mutableStateOf("")
        }
        var cantidad by rememberSaveable {
            mutableStateOf("")
        }
        var resultado by rememberSaveable {
            mutableStateOf("")
        }

        //Componente1.1
        Column {
            //Componente1.1.1
            Text(text = "Calculo de Valor a Pagar", textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
            //Componente1.1.2
            espacio(tamanio = 10)
            //Componente1.1.3
            OutlinedTextField(value = precio, onValueChange = {precio=it}, modifier = Modifier.fillMaxWidth(), label = { Text(text = "Ingrese el precio") }, maxLines = 1, singleLine = true, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
            //Componente1.1.4
            espacio(tamanio = 10)
            //Componente1.1.5
            OutlinedTextField(value = cantidad, onValueChange = {cantidad=it}, modifier = Modifier.fillMaxWidth(), label = { Text(text = "Ingrese la cantidad") }, maxLines = 1, singleLine = true, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
            //Componente1.1.6
            espacio(tamanio = 10)
            //Componente1.1.7
            Button(onClick = {resultado = calcularValor(precio.toDouble(),cantidad.toDouble())}, modifier = Modifier.fillMaxWidth()) {
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

fun calcularValor(precio: Double, cantidad: Double): String {
    var valorpago= precio*cantidad
    var nuevovalor=0.0
    if (valorpago>200){
        nuevovalor=valorpago-(precio*0.2)
        return "Valor a pagar = $nuevovalor"
    }
    return "Valor a pagar = $valorpago"
}