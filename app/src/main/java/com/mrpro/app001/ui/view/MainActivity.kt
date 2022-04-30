package com.mrpro.app001.ui.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mrpro.app001.R
import com.mrpro.app001.ui.viewmodel.DotaProfileModel

class MainActivity : ComponentActivity() {

    private val quoteViewModel: DotaProfileModel by viewModels()
    //private val id = "211612523"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DefaultPreview()
            //quoteViewModel.onCreate(id)
        }
    }
}

//@Preview(backgroundColor = 0x989a82)
@Composable
fun DefaultPreview(
    //viewModel: DotaProfileModel
) {
    Scaffold(
        floatingActionButton = {
            ExtendedFloatingActionButton(
                //modifier = Modifier.,

                //horizontalAlignment = Alignment.CenterHorizontally,
                onClick = {


                },
                icon = {
                    val painter= painterResource(id = R.drawable.ic_refresh)
                },
                text = { Text("Cargar User") }
            )
        }
    ) {
        //MmrText(mmr = viewModel.dotaProfileModel.value?.SoloRanketMmr.toString())
    }

}

@Composable
fun MmrText(mmr: String) {
    Text(
        text = "Tu DNI dotero $mmr",
        modifier = Modifier.padding(vertical = 2.dp),
        color = Color.Red
    )
}
