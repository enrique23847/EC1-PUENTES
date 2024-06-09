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
fun CalcularNumeros() {
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(top = 25.dp)) {

   
    var num1 by remember { mutableStateOf("") }
    var num2 by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Column {
        Text(text = "CALCULAR DOS NUMEROS ",
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 30.sp)
        )
        MySpace1(espacio = 16)
        OutlinedTextField(
            value = num1,
            onValueChange = { num1 = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Ingrese el número 1") },
            maxLines = 1,
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        MySpace1(espacio = 16)
        OutlinedTextField(
            value = num2,
            onValueChange = { num2 = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Ingrese el número 2") },
            maxLines = 1,
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        MySpace1(espacio = 16)
        Button(onClick = {
            result = try {
                val number1 = num1.toInt()
                val number2 = num2.toInt()
                calcularOperacion(number1, number2)
            } catch (e: NumberFormatException) {
                "Por favor, ingrese valores numéricos válidos."
            }
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "CALCULAR")
        }
        MySpace1(16)
        Text(
            text = result,
            style = TextStyle(fontWeight = FontWeight.Bold, color = Color.DarkGray)
        )
    }

        
    }
}
@Composable
fun MySpace1(espacio: Int){
    Spacer(modifier = Modifier.size(espacio.dp))
}
fun calcularOperacion(num1: Int, num2: Int): String {
    return if (num1 == num2) {
        "Los números son iguales. Resultado: ${num1 * num2}"
    } else if (num1 > num2) {
        "El número 1 ($num1) es mayor. Resultado: ${num1 - num2}"
    } else {
        "El número 2 ($num2) es mayor. Resultado: ${num1 + num2}"
    }
}
