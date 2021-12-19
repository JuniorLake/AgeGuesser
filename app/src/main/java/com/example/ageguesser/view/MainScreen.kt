package com.example.ageguesser.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.TextFieldDefaults.textFieldColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ageguesser.R
import com.example.ageguesser.navigation.Screen

@Composable
fun MainScreen(
    navController: NavController,
){

    var textName by remember {
        mutableStateOf("")
    }
    var textFieldIsEmpty by remember {
        mutableStateOf(false)
    }
    val fontFamily = FontFamily(Font(R.font.roboto_black, FontWeight.Black))

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = colorResource(id = R.color.priColor_Green)
    ) {
        Surface(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxSize(),
            color = colorResource(id = R.color.secColor_Black),
            shape = RoundedCornerShape(40.dp)
        ){
            Column(
                modifier = Modifier
                    .padding(16.dp),
            ){
                //Name of App
                Row(
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxHeight(0.3f)
                        .fillMaxWidth()
                        .offset(y = 20.dp)
                ) {
                    Text(
                        text = "AgeGuesser",
                        color = colorResource(id = R.color.white),
                        fontSize = 36.sp,
                        textAlign = TextAlign.Center,
                        fontFamily = fontFamily,
                        fontWeight = FontWeight.Bold

                    )
                }
                
                //TextBox for enter name
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxHeight(0.5f)
                        .fillMaxWidth()
                        .offset(y = (-50).dp)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        if (textFieldIsEmpty){
                            Text(
                                text = "Please enter your name....its how the app works.",
                                color = colorResource(id = R.color.white),
                                fontFamily = fontFamily,
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp
                            )
                        }
                        Spacer(modifier = Modifier.padding(vertical = 10.dp))
                        TextField(
                            value = textName,
                            onValueChange = { textName = it },
                            shape = RoundedCornerShape(40.dp),
                            colors = textFieldColors(
                                backgroundColor = colorResource(id = R.color.priColor_Green),
                                cursorColor = colorResource(id = R.color.white),
                                focusedIndicatorColor = Color.Transparent,
                                textColor = colorResource(id = R.color.white)
                            ),
                            modifier = Modifier.height(80.dp),
                            textStyle = TextStyle(
                                fontSize = 30.sp,
                                fontFamily = fontFamily,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center
                            )
                        )
                    }
                }

                Row(
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                ){
                    FloatingActionButton(
                        onClick = {
                            if (textName == ""){
                                textFieldIsEmpty = true
                            } else{
                                navController.navigate(Screen.DetailScreen.route + "?name=${textName}")
                            }
                        },
                        modifier = Modifier
                            .size(70.dp)
                            .offset(y = (-50).dp),
                        backgroundColor = colorResource(id = R.color.priColor_Green)
                    ) {
                        Icon(
                            imageVector = Icons.Default.CheckCircle,
                            contentDescription = "" )
                    }
                }
            }
        }
    }
}