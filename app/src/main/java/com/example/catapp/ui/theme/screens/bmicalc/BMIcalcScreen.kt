package com.example.catapp.ui.theme.screens.bmicalc

import com.example.catapp.Navigation.ROUTE_BMICALC
import com.example.catapp.Navigation.ROUTE_CALCULATOR
import com.example.catapp.Navigation.ROUTE_HOME
import com.example.catapp.Navigation.ROUTE_INTENTS
import com.example.catapp.ui.theme.CatAppTheme
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.catapp.R

import com.example.catapp.ui.theme.CatAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BMIcalcScreen(navController: NavController){


    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Column (
            modifier = Modifier.padding(15.dp)
        ){
            Text(text = "BMI Calculator",
                fontSize = 40.sp ,
                modifier = Modifier.padding(start = 20.dp, top = 20.dp),
                color = Color.Magenta,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Cursive,
                textAlign = TextAlign.Center)
            FontWeight.Bold
        }

        Column (
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            var firstNumber by remember {
                mutableStateOf("")
            }
            OutlinedTextField(value = firstNumber, onValueChange = {firstNumber = it},
                label = { Text(text = "Enter your weight(kg)")},
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(top = 30.dp),
                shape = RoundedCornerShape(20.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            var secondNumber by remember {
                mutableStateOf("")
            }
            OutlinedTextField(value = secondNumber, onValueChange = {secondNumber = it},
                label = { Text(text = "Enter your height(m)")},
                modifier = Modifier.fillMaxWidth(0.9f),
                shape = RoundedCornerShape(20.dp)
            )

            var result by remember {
                mutableStateOf("0")
            }
            Button(onClick = {
                val num1 = firstNumber.toDoubleOrNull() ?: 0.0
                val num2 = secondNumber.toDoubleOrNull() ?: 0.0
                result = (num1 / (num2 * num2)).toString()
            },
                border = BorderStroke(1.dp, Color.Magenta),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Red),
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(top = 15.dp)
            ) {
                Text(text = "CALCULATE BMI")
            }



            Text(text = "result: $result")
            if (result<= 19.toString() ){
                Text(text = "You are underweight")
            }else if (result<= 25.toString()){
                Text(text = "You are normal weight")
            }else if (result<= (25..30).toString()) {
                Text(text = "You are overweight")
            } else if (result<= (30..40).toString()) {
                Text(text = "You are obese")
            } else{
                Text(text = "Try Again")
            }






            BottomAppBar(
                modifier = Modifier
                    .background(Color.Transparent)
                    .fillMaxWidth()
                    .padding(top = 90.dp)


            ) {
                IconButton(
                    onClick = {
                        navController.navigate(ROUTE_HOME)
                    },
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_4g_mobiledata_24),
                        contentDescription = "home"
                    )
//            Icon(imageVector = Icons.Default.home, contentDescription = )
                    Text(
                        text = "Home",
                        modifier = Modifier.padding(top = 35.dp, bottom = 1.dp)
                    )
                }
                IconButton(
                    onClick = {
                        navController.navigate(ROUTE_CALCULATOR)
                    },
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_4g_mobiledata_24),
                        contentDescription = "calculator"
                    )
                    Text(
                        text = "calculator",
                        modifier = Modifier.padding(top = 35.dp, bottom = 1.dp)
                    )
                }
                IconButton(
                    onClick = {
                        navController.navigate(ROUTE_INTENTS)
                    },
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_4g_mobiledata_24),
                        contentDescription = "intents"
                    )
                    Text(
                        text = "intents",
                        modifier = Modifier.padding(top = 40.dp, bottom = 1.dp)
                    )
                }
                IconButton(
                    onClick = {
                        navController.navigate(ROUTE_BMICALC)
                    },
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_4g_mobiledata_24),
                        contentDescription = "BMI calc"
                    )
                    Text(
                        text = "BMI calc",
                        modifier = Modifier.padding(top = 35.dp, bottom = 1.dp)
                    )
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun BMIcalcScreenPreview(){
    CatAppTheme {
        BMIcalcScreen(rememberNavController())
    }
}