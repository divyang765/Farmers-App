package com.example.farmersapp.NewsApp.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.apmcprices.DataClass.ApmcRecords
import com.example.farmersapp.ApmcPrices.ApmcViewModel


@Composable
fun ApmcScreen(viewModel: ApmcViewModel) {

    viewModel.ApmcData.value.let {
        ShowApmcData(it, viewModel)

    }
}

@Composable
fun ShowApmcData(apmcRecords: List<ApmcRecords>, viewModel: ApmcViewModel) {


    Column {
        DropDown(viewModel)

        LazyColumn {
            items(apmcRecords) {
                Row {
                    Text(text = it.state, style = TextStyle(fontSize = 12.sp))
                    Text(text = it.district, style = TextStyle(fontSize = 12.sp))
                    Text(text = it.commodity, style = TextStyle(fontSize = 12.sp))
                    Text(text = it.min_price, style = TextStyle(fontSize = 12.sp))

                }

            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun DropDown(viewModel: ApmcViewModel) {


    val list = listOf(

        "Chandigarh",
        "Chattisgarh",
        "Gujarat",
        "Hariyana",
        "Himachal Pradesh",
        "Jammu & Kashmir",
        "Jharkhand",
        "Karnataka",
        "Kerala",
        "Madhya Pradesh",
        "Maharashtra",
        "Odisha",
        "Pudu Cherry",
        "Punjab",
        "Rajasthan",
        "Tamil Nadu",
        "Telangana",
        "Uttar Pradesh",
        "Uttarakhand",
        "West Bengal"
    )
    var selectedText by remember {
        mutableStateOf(list[2])
    }
    var isExpanded by remember {
        mutableStateOf(false)
    }
    val context = LocalContext.current
    viewModel.FetchapmcData(context, selectedText)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ExposedDropdownMenuBox(expanded = isExpanded, onExpandedChange = {
            isExpanded = !isExpanded
        }) {
            TextField(
                modifier = Modifier.menuAnchor(),
                value = selectedText,
                onValueChange = {},
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(
                        expanded = isExpanded
                    )
                },
                enabled = false,
                textStyle = TextStyle(fontWeight = FontWeight.Bold)


            )
            ExposedDropdownMenu(expanded = isExpanded, onDismissRequest = { isExpanded = false }) {
                list.forEachIndexed { index, text ->
                    DropdownMenuItem(
                        text = { Text(text = text) },
                        onClick = {
                            selectedText = list[index]
                            isExpanded = false
                        },
                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                    )

                }
            }
        }
        Text(text = "CurrentlySelected: $selectedText")
    }
}