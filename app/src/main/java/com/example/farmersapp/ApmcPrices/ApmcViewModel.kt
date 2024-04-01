package com.example.farmersapp.ApmcPrices

import android.content.Context
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.apmcprices.DataClass.ApmcRecords

class ApmcViewModel : ViewModel() {
    var _ApmcData = mutableStateOf<List<ApmcRecords>>(emptyList())
    var ApmcData: androidx.compose.runtime.State<List<ApmcRecords>> = _ApmcData

    private val API_KEY = "579b464db66ec23bdd000001b06d9e28da6942c8404ba24a54e97a3b"

    fun FetchapmcData(context: Context, stateSelected: String) {
        val apmcList = mutableListOf<ApmcRecords>()
        val url =
            "https://api.data.gov.in/resource/9ef84268-d588-465a-a308-a864a43d0070?api-key=${API_KEY}&format=json&filters%5Bstate%5D=$stateSelected"

        val JsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null, {
                val jsonArray = it.getJSONArray("records")

                for (i in 0 until jsonArray.length()) {
                    val apmcJsonObject = jsonArray.getJSONObject(i)

                    val apmcRecords = ApmcRecords(
                        state = apmcJsonObject.getString("state"),
                        district = apmcJsonObject.getString("district"),
                        market = apmcJsonObject.getString("market"),
                        commodity = apmcJsonObject.getString("commodity"),
                        min_price = apmcJsonObject.getString("min_price"),
                        max_price = apmcJsonObject.getString("max_price"),
                        modal_price = apmcJsonObject.getString("modal_price")
                    )
                    apmcList.add(apmcRecords)
                    _ApmcData.value = apmcList
                    Log.d("taga", ApmcData.toString())
                }

            }, {

            }

        )
        Volley.newRequestQueue(context).add(JsonObjectRequest)

    }
}