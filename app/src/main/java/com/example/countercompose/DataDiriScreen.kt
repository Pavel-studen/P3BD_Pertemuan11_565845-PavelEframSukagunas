package com.example.countercompose

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun DataDiriApp(
    onBack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: DataDiriViewModel = viewModel()
){
    val name by viewModel.name
    val age by viewModel.age

    DataDiriScreen(
        name = name,
        age = age,
        onNameChange = { viewModel.onNameChange(it) },
        onAgeChange = { viewModel.onAgeChange(it) },
        onBack = onBack,
        modifier = modifier
    )
}

@Composable
fun DataDiriScreen(
    name: String,
    age: String,
    onNameChange: (String) -> Unit,
    onAgeChange: (String) -> Unit,
    onBack: () -> Unit,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "Identity Data",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(24.dp))

        // Form untuk memasukkan nama
        OutlinedTextField(
            value = name,
            onValueChange = onNameChange,
            label = { Text("Masukkan nama") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Form untuk memasukkan umur
        OutlinedTextField(
            value = age,
            onValueChange = onAgeChange,
            label = { Text("Masukkan umur") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )
        Spacer(modifier = Modifier.height(24.dp))

        // Output atau ringkasan hasil inputan nama dan umur
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant
            )
        ){
            Text(
                text = "Nama saya $name dan umur saya $age tahun, salam kenal!",
                fontSize = 16.sp,
                modifier = Modifier.padding(16.dp)
            )
        }
        Spacer(modifier = Modifier.weight(1f))

        // Tombol untuk mengembalikan halaman data identitas ke halaman counter
        OutlinedButton(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(("KEMBALI"))
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DataDiriScreenPreview(){
    _root_ide_package_.com.example.countercompose.ui.theme.CounterComposeTheme {
        DataDiriScreen(
            name = "X",
            age = "20",
            onNameChange = {},
            onAgeChange = {},
            onBack = {}
        )
    }
}