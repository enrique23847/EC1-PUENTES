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
fun TestsAlcohol() {
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(top = 25.dp)) {

        var indicador by rememberSaveable { mutableStateOf("") }
        var tasaAlcohol by rememberSaveable { mutableStateOf("") }
        var resultado by rememberSaveable { mutableStateOf("") }

        Column {
            Text(
                text = "CONTROL DE ALCOHOLEMIA",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 30.sp)
            )
            MySpace3(16)
            OutlinedTextField(
                value = indicador,
                onValueChange = { indicador = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Ingrese el Indicador de Vehículo") },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )
            MySpace3(16)
            OutlinedTextField(
                value = tasaAlcohol,
                onValueChange = { tasaAlcohol = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Ingrese la Tasa de Alcohol") },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            MySpace3(16)
            Button(onClick = {
                resultado = try {
                    val tasaDouble = tasaAlcohol.toDouble()
                    determinarResultado(indicador, tasaDouble)
                } catch (e: NumberFormatException) {
                    "Por favor, ingrese una tasa de alcohol válida."
                }
            }, modifier = Modifier.fillMaxWidth()) {
                Text(text = "VERIFICAR")
            }
            MySpace3(16)
            Text(
                text = resultado,
                style = TextStyle(fontWeight = FontWeight.Bold, color = Color.DarkGray)
            )
        }
    }
}

@Composable
fun MySpace3(espacio: Int) {
    Spacer(modifier = Modifier.size(espacio.dp))
}

fun determinarResultado(indicador: String, tasa: Double): String {
    val tasaMaxima = when (indicador.uppercase()) {
        "C" -> 0.3
        "A" -> 0.3
        "T" -> 0.5
        "M" -> 0.3
        else -> return "Indicador de vehículo no válido."
    }

    return if (tasa > tasaMaxima) "Da positivo en el control de alcoholemia." else "No da positivo en el control de alcoholemia."
}