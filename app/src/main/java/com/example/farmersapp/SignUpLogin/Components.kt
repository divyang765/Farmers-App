package com.example.farmersapp.SignUpLogin

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
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

@Composable
fun HeadingTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier.fillMaxWidth(),
        style = TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            textAlign = TextAlign.Center, fontStyle = FontStyle.Italic
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
            .clip(RoundedCornerShape(5.dp))
            .padding(5.dp),
        value = textValue.value,
        label = { Text(text = labelValue, fontSize = 17.sp, fontWeight = FontWeight.Black) },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,

            focusedIndicatorColor = Color(255, 234, 0, 255),

            ),
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
            .padding(5.dp),
        value = password.value,
        onValueChange = {
            password.value = it
            onTextSelected(it)
        },
        label = { Text(text = labelValue, fontSize = 17.sp, fontWeight = FontWeight.Black) },
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
fun ButtonComponent(value: String) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp), colors = ButtonDefaults.buttonColors(Color(98, 0, 234, 255)),
        onClick = { }) {
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
            color = Color.Black,
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