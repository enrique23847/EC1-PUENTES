package app.edu.idat.ec_1_puentes

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
fun CalcularSuma() {
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(top = 25.dp)) {

        var result by remember { mutableStateOf("") }

        Column {
            Text(text = "SUMA DE LOS NÚMEROS DEL 23 AL 99",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 30.sp)
            )
            MySpace4(espacio = 16)
            Button(onClick = {
                result = calcularSuma()
            }, modifier = Modifier.fillMaxWidth()) {
                Text(text = "CALCULAR")
            }
            MySpace4(16)
            Text(
                text = result,
                style = TextStyle(fontWeight = FontWeight.Bold, color = Color.DarkGray)
            )
        }
    }
}

@Composable
fun MySpace4(espacio: Int){
    Spacer(modifier = Modifier.size(espacio.dp))
}

fun calcularSuma(): String {
    val N = 99 - 23 + 1
    val n = 99
    val suma = (N * (n + 1)) / 2
    return "La suma de los números desde 23 hasta 99 es: $suma"
}