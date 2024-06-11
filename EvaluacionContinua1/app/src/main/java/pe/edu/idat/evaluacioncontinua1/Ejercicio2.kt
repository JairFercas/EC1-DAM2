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
fun Pregunta2(){
    //componente1
    Box(
        Modifier
            .fillMaxSize()
            .padding(top = 30.dp)){

        var prestamo by rememberSaveable {
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
            OutlinedTextField(value = prestamo, onValueChange = {prestamo=it}, modifier = Modifier.fillMaxWidth(), label = { Text(text = "Ingrese el monto a prestar") }, maxLines = 1, singleLine = true, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
            //Componente1.1.4
            espacio(tamanio = 10)
            //Componente1.1.5
            Button(onClick = {resultado = calcularCuotas(prestamo.toDouble())}, modifier = Modifier.fillMaxWidth()) {
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

fun calcularCuotas(prestamo: Double): String {
    var numcuotas=0
    var interes=0.0
    var deudatotal=0.0
    var valorcuota=0.0

    if (prestamo>5000){
        numcuotas=3
        interes=prestamo*0.10
        deudatotal=prestamo+interes
        valorcuota=deudatotal/numcuotas
        return "Cuotas a pagar: $numcuotas\nValor de cuota:$valorcuota"
    }else if(prestamo in 2000.0..3000.0){
        numcuotas=2
        interes=prestamo*0.12
        deudatotal=prestamo+interes
        valorcuota=deudatotal/numcuotas
        return "Cuotas a pagar: $numcuotas\nValor de cuota:$valorcuota"
    } else if (prestamo<1000){
        numcuotas=1
        interes=prestamo*0.12
        deudatotal=prestamo+interes
        valorcuota=deudatotal/numcuotas
        return "Cuotas a pagar: $numcuotas\nValor de cuota:$valorcuota"
    } else {
        numcuotas=5
        if (prestamo<4000){
            interes=prestamo*0.12
            deudatotal=prestamo+interes
            valorcuota=deudatotal/numcuotas
            return "Cuotas a pagar: $numcuotas\nValor de cuota:$valorcuota"
        } else {
            interes=prestamo*0.10
            deudatotal=prestamo+interes
            valorcuota=deudatotal/numcuotas
            return "Cuotas a pagar: $numcuotas\nValor de cuota:$valorcuota"
        }
    }

}