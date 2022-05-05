package com.mrpro.app001.ui.view

import android.os.Bundle
import android.text.style.BackgroundColorSpan
import android.util.Log
import android.view.Gravity
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.gson.Gson
import com.mrpro.app001.R
import com.mrpro.app001.ui.viewmodel.DotaProfileViewModel
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import coil.compose.rememberAsyncImagePainter

class MainActivity : ComponentActivity() {

    private val quoteViewModel: DotaProfileViewModel by viewModels()
    private var mmrDotita = "No se carga"
    private val id = "410755999"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DefaultPreview(quoteViewModel, id)
            setupObservers()
        }
    }

    private fun setupObservers() {
        quoteViewModel.dotaProfileModel.observe(this) {
            if (it == null) {
                return@observe
            }
            Log.i("Perfil", Gson().toJson(it))
            mmrDotita = it.SoloRanketMmr.toString()

            setContent {
                DefaultPreview(quoteViewModel, id)
            }
        }
    }
}

//@Preview(backgroundColor = 0x989a82)
@Composable
fun DefaultPreview(
    viewModel: DotaProfileViewModel, id: String
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.5.dp, Color.Red)
        ) {
            item() {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier
                            .border(1.5.dp, Color.Red),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        FotoPerfil(
                            imageUrlInput = viewModel.dotaProfileModel.value?.profileDetails?.fotoGrande
                                ?: R.drawable.ic_profiledota.toString()
                        )
                        TextoDebajo(
                            value = viewModel.dotaProfileModel.value?.profileDetails?.apodoDotero.toString()
                                    + " ("
                                    + viewModel.dotaProfileModel.value?.profileDetails?.servidorJuega.toString()
                                    + ")"
                        )
                    }
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        StarMedals(cantidad = viewModel.dotaProfileModel.value?.medalla ?: 11)
                        CargarMedalla(medal = viewModel.dotaProfileModel.value?.medalla ?: 11)
                        TextoDebajo(value = viewModel.dotaProfileModel.value?.SoloRanketMmr.toString())
                    }
                }
            }
        }
        ButtonCharge(viewModel = viewModel, id = id)
    }
}

@Composable
fun FotoPerfil(imageUrlInput: String) {
    var imageUrl = imageUrlInput
    Image(
        painter = rememberAsyncImagePainter(imageUrl),
        contentDescription = "Contact profile picture",
        modifier = Modifier
            .size(150.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colors.secondary)
    )
}

@Composable
fun StarMedals(cantidad: Int = 11) {
    val cantidadEstrellas: Int = cantidad.toString()[1].digitToInt()
    Log.i("NOOOOOOOOOO", cantidadEstrellas.toString())
    LazyRow(
        modifier = Modifier
            .border(1.5.dp, Color.Red),
    ) {
        for (x in 1..cantidadEstrellas) {
            item {
                Image(
                    painter = painterResource(R.drawable.ic_estrella),
                    contentDescription = "Estrellas de la medalla",
                    modifier = Modifier
                        .size(25.dp)
                )
            }
        }
    }
}


@Composable
fun CargarMedalla(medal: Int = 11) {
    val numeroMedalla: Int = medal.toString()[0].digitToInt()
    Image(
        painter = painterResource(BuscarMedallaImagen(numeroMedalla)),
        contentDescription = "Contact profile picture",
        modifier = Modifier
            .border(1.5.dp, Color.Red)
            .size(150.dp)

    )
}

fun BuscarMedallaImagen(clave: Int = 1): Int {
    var llave=clave
    if (llave<=0 || llave>=9  ){
        llave=1
    }
    val medallas: Map<Int, Int> = mapOf(
        1 to R.drawable.heraldo,
        2 to R.drawable.guardian,
        3 to R.drawable.crusado,
        4 to R.drawable.arconte,
        5 to R.drawable.leyenda,
        6 to R.drawable.ancient,
        7 to R.drawable.divine,
        8 to R.drawable.inmortal,
    )
    return medallas[llave] ?: 1
}

//@Preview(name = "Boton")
@Composable
fun ButtonCharge(viewModel: DotaProfileViewModel, id: String) {
    ExtendedFloatingActionButton(
        onClick = {
            viewModel.getProfile(id)
        },
        icon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_refresh),
                contentDescription = null // decorative element
            )
        },
        text = { Text("Cargar Perfil") }
    )
}

//@Preview(name = "Letritas", backgroundColor = 0)
@Composable
fun TextoDebajo(value: String = "0") {
    var valor: String = value
    Card(
        modifier = Modifier
            .padding(10.dp)
            .clip(CircleShape),

        backgroundColor = MaterialTheme.colors.secondary
        //elevation = 10.dp
    ) {
        Text(
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp)
                .background(MaterialTheme.colors.secondary),
            text = valor
        )
    }
}