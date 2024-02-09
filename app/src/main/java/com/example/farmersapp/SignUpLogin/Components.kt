package com.example.farmersapp.SignUpLogin

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.farmersapp.App.FarmersAppRouter
import com.example.farmersapp.App.Screen
import com.example.farmersapp.R
import kotlinx.coroutines.launch

@Composable
fun HeadingTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp),
        style = TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            textAlign = TextAlign.Start, fontStyle = FontStyle.Italic
        )
    )
}

@Composable
fun MyTextField(
    labelValue: String,
    imageVector: ImageVector = Icons.Default.Person,
    onTextSelected: (String) -> Unit
) {

    val textValue = remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .padding(horizontal = 15.dp),
        value = textValue.value,

        colors = TextFieldDefaults.colors(
//            focusedContainerColor = Color.White,
//            unfocusedContainerColor = Color.White,
            focusedLabelColor = Color.Black, unfocusedLabelColor = Color.Black


            // focusedIndicatorColor = Color(255, 234, 0, 255),

        ), label = {
            Text(
                text = labelValue,
                fontSize = 17.sp,
                fontWeight = FontWeight.Black,
                color = Color.White


            )
        },
        singleLine = true,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        leadingIcon = {
            Icon(
                imageVector = imageVector,
                contentDescription = null
            )
        },
        onValueChange = {
            textValue.value = it

            onTextSelected(it)
        }
    )
}

@Composable
fun PasswordTextField(
    labelValue: String,
    imageVector: ImageVector = Icons.Default.Lock,
    onTextSelected: (String) -> Unit
) {
    val password = remember {
        mutableStateOf("")
    }
    val passwordVisible = remember {
        mutableStateOf(false)
    }
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
        value = password.value,
        onValueChange = {
            password.value = it
            onTextSelected(it)
        },
        label = {
            Text(
                text = labelValue,
                fontSize = 17.sp,
                fontWeight = FontWeight.Black,
                color = Color.White

            )
        },
        colors = TextFieldDefaults.colors(
//            focusedContainerColor = Color.White,
//            unfocusedContainerColor = Color.White,
            focusedLabelColor = Color.White, unfocusedLabelColor = Color.White,


            ),

        leadingIcon = {
            Icon(
                imageVector = imageVector,
                contentDescription = null
            )
        },
        singleLine = true,
        maxLines = 1,
        trailingIcon = {

            val iconImage = if (passwordVisible.value) {
                Icons.Filled.Visibility
            } else {
                Icons.Filled.VisibilityOff
            }
            val description = if (passwordVisible.value) {
                "Hide Password"
            } else {
                "Show Password"
            }
            IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                Icon(imageVector = iconImage, contentDescription = description)
            }
        },
        visualTransformation = if (passwordVisible.value) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        }
    )

}

@Composable
fun ButtonComponent(value: String, onClicked: () -> Unit) {
    Button(
        modifier = Modifier
            .padding(15.dp)
            .fillMaxWidth()
            .heightIn(58.dp), colors = ButtonDefaults.buttonColors(Color(101, 147, 73, 255)),
        onClick = { onClicked() }) {
        Text(text = value, style = TextStyle(fontWeight = FontWeight.Bold))
    }
}

@Composable
fun ClickableTextComponent(value: AnnotatedString, onTextSelected: (String) -> Unit) {
    ClickableText(
        text = value, onClick = { onTextSelected(it.toString()) }, style = TextStyle(
            fontSize = 20.sp,
            color = Color.Yellow,
            fontWeight = FontWeight.Black
        )
    )
}

@Composable
fun UnderLinedTextComponent(value: String) {
    Text(
        text = value, modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp), style = TextStyle(
            fontSize = 15.sp,
            fontWeight = FontWeight.SemiBold,
            fontStyle = FontStyle.Normal,
            color = Color.White,
            textAlign = TextAlign.Center,
            textDecoration = TextDecoration.Underline
        )
    )
}

@Composable
fun DividerTextComponent() {
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f), color = Color.DarkGray, thickness = 3.dp
        )
        Text(modifier = Modifier.padding(8.dp), text = "Or", fontSize = 18.sp, color = Color.Black)
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f), color = Color.DarkGray, thickness = 3.dp
        )
    }
}

@Composable
fun CircularIndeterminateProgressBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(50.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun SnackbarWithoutScaffold(
    message: String,
    showSb: Boolean,
    openSnackbar: (Boolean) -> Unit
) {

    val snackState = remember { SnackbarHostState() }
    val snackScope = rememberCoroutineScope()

    SnackbarHost(
        modifier = Modifier,
        hostState = snackState
    ) {
        Snackbar(
            snackbarData = it,
            containerColor = Color.Black,
            contentColor = Color.White
        )
    }


    if (showSb) {
        LaunchedEffect(Unit) {
            snackScope.launch { snackState.showSnackbar(message) }
            openSnackbar(false)
        }

    }


}

@Composable
fun HeadingTextBlock(value: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn()
            .clip(RoundedCornerShape(35.dp))
            .heightIn(150.dp)

            .background(Color(6, 53, 37, 255)), contentAlignment = Alignment.CenterStart

    ) {
        Text(
            text = value, color = Color.White, style = TextStyle(
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Start, fontStyle = FontStyle.Italic
            ), modifier = Modifier.padding(start = 10.dp)
        )
    }

}

@Composable
fun TopCard(value: String) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(130.dp)

            .clip(RoundedCornerShape(20.dp)),
        color = Color(6, 53, 37, 255)
    )
    {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = value,
                style = TextStyle(Color.White, fontSize = 25.sp, fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(10.dp)
            )

        }
    }
}


@Composable
fun MainScreenTopCard(value: String) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(130.dp)

            .clip(RoundedCornerShape(20.dp)),
        color = Color(6, 53, 37, 255)
    )
    {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(25.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = value,
                style = TextStyle(Color.White, fontSize = 35.sp, fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(10.dp)
            )
            Image(
                painterResource(id = R.drawable.farmer_woman_svgrepo_com),
                contentDescription = ""
            )
            Text(
                text = "Online Farmers",
                style = TextStyle(Color.White, fontSize = 35.sp, fontWeight = FontWeight.Bold),

                )
            Text(
                text = "App",
                style = TextStyle(Color.White, fontSize = 35.sp, fontWeight = FontWeight.Bold),

                )
        }
    }
}

@Composable
fun TransparentButtonComponent(value: String, onClicked: () -> Unit) {
    Button(
        modifier = Modifier
            .padding(15.dp)
            .fillMaxWidth()
            .heightIn(58.dp),
        colors = ButtonDefaults.buttonColors(Color.Transparent),
        border = BorderStroke(
            3.dp,
            Color(101, 147, 73, 255)
        ),
        onClick = { onClicked() }) {
        Text(
            text = value,
            style = TextStyle(fontWeight = FontWeight.Bold, color = Color(101, 147, 73, 255))
        )
    }
}


