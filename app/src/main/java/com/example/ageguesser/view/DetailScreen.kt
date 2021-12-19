package com.example.ageguesser.view

import android.annotation.SuppressLint
import androidx.compose.animation.*
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.ageguesser.R
import com.example.ageguesser.navigation.Screen
import com.example.ageguesser.viewmodel.ViewModel

@ExperimentalAnimationApi
@SuppressLint("CoroutineCreationDuringComposition", "UnrememberedMutableState")
@Composable
fun DetailScreen(
    navController: NavController,
    name: String?,
    viewModel: ViewModel = hiltViewModel()
){
    val fontFamily = FontFamily(Font(R.font.roboto_black, FontWeight.Black))
    val resultJoke = viewModel.resultJoke
    val isLoading = viewModel.isLoading
    var run by remember {mutableStateOf(true) }

    if(run){
        viewModel.getData(name!!)
        run = false
    }

    Surface(
        color = colorResource(id = R.color.black),
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp)
        ) {

            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.TopStart
            ){
                Button(
                    onClick = { navController.navigate(Screen.MainScreen.route) },
                    shape = RoundedCornerShape(40.dp),
                    modifier = Modifier
                        .width(97.dp)
                        .height(45.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = colorResource(id = R.color.priColor_Green)
                    )
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "" ,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(60.dp))
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ){

                Loading(toggle = isLoading)

                AnimatedVisibility(
                    visible = !isLoading,
                    enter = slideInHorizontally(
                        {600},
                        animationSpec = spring(Spring.DampingRatioMediumBouncy)
                    )
                ) {
                    Surface(
                        shape = RoundedCornerShape(20.dp),
                        color = colorResource(id = R.color.priColor_Green),
                        modifier = Modifier
                            .width(298.dp)
                            .height(350.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(20.dp)
                        ) {
                            Text(
                                text = resultJoke,
                                fontFamily = fontFamily,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Left,
                                color = colorResource(id = R.color.black),
                                fontSize = 25.sp
                            )
                        }
                    }
                }
            }
        }
    }
}