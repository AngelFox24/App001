package com.mrpro.app001.ui.view

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.gson.Gson
import com.mrpro.app001.R
import com.mrpro.app001.ui.viewmodel.DotaProfileViewModel

class MainActivity : ComponentActivity() {

    private val quoteViewModel: DotaProfileViewModel by viewModels()
    private var mmrDotita="No se carga"
    private val id = "211612523"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DefaultPreview(quoteViewModel, id)

            //getProfile()
            setupObservers()
        }
    }

    private fun getProfile(){
        quoteViewModel.getProfile(id)
    }


    private fun setupObservers(){
        quoteViewModel.dotaProfileModel.observe(this){
            if(it==null){
                Log.i("NULL", Gson().toJson(it))
                return@observe
            }

            Log.i("Perfil", Gson().toJson(it))
            mmrDotita = it.SoloRanketMmr.toString()

           setContent {
               MmrText(mmr = mmrDotita)
               DefaultPreview(quoteViewModel, id)
           }
        }
    }
}

//@Preview(backgroundColor = 0x989a82)
@Composable
fun DefaultPreview(
    viewModel: DotaProfileViewModel, id:String
) {
  
    Scaffold(
        floatingActionButton = {
            ExtendedFloatingActionButton(
                //modifier = Modifier.,

                //horizontalAlignment = Alignment.CenterHorizontally,
                onClick = {
                    viewModel.getProfile(id)
                },
                icon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_refresh),
                        contentDescription = null // decorative element
                    )
                },
                text = { Text("Cargar Usuario") }
            )
        }
    ) {
        MmrText(mmr = viewModel.dotaProfileModel.value?.SoloRanketMmr.toString())
    }

}

@Composable
fun MmrText(mmr: String) {
    Text(
        text = "Tu DNI dotero es tmr $mmr",
        modifier = Modifier.padding(vertical = 2.dp),
        color = Color.Red
    )
}
