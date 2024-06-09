package app.edu.idat.ec_1_puentes

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CalcularMes() {
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(top = 25.dp)) {

        var numeroMes by rememberSaveable { mutableStateOf("") }
        var nombreMes by rememberSaveable { mutableStateOf("") }

        Column {
            Text(
                text = "INGRESE NÚMERO DE MES (1-12)",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 30.sp)
            )
            MySpace2(16)
            OutlinedTextField(
                value = numeroMes,
                onValueChange = { numeroMes = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Número de mes") },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            MySpace2(16)
            Button(onClick = {
                val num = numeroMes.toIntOrNull()
                if (num != null && num in 1..12) {
                    nombreMes = ConvertidorNumeroaMes(num)
                } else {
                    nombreMes = "Número de mes inválido."
                }
            }, modifier = Modifier.fillMaxWidth()) {
                Text(text = "MOSTRAR MES")
            }
            MySpace2(16)
            Text(
                text = "Mes: $nombreMes",
                style = TextStyle(fontWeight = FontWeight.Bold, color = Color.DarkGray)
            )
        }
    }
}

@Composable
fun MySpace2(espacio: Int) {
    Spacer(modifier = Modifier.size(espacio.dp))
}

fun ConvertidorNumeroaMes(numeroMes: Int): String {
    val nombresMeses = arrayOf(
        "Enero",
        "Febrero",
        "Marzo",
        "Abril",
        "Mayo",
        "Junio",
        "Julio",
        "Agosto",
        "Septiembre",
        "Octubre",
        "Noviembre",
        "Diciembre"
    )
    return nombresMeses[numeroMes - 1]
}