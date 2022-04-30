package com.mrpro.app001.ui.view

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mrpro.app001.data.network.Dota2ApiClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DefaultPreview()
        }
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.opendota.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun searchProfilebyId(query: String): String {
        var x = "Todavia"
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(Dota2ApiClient::class.java).getProfileById("players/$query")
            //val profile = call.body()
            x = "Empieza sleep"
            Log.println( Log.DEBUG,"debug","Empieza el sleep")
            Thread.sleep(2000)
            Log.println( Log.DEBUG,"debug","Termina el sleep")
            x = "Termina sleep"
            runOnUiThread {
                /*if (call.isSuccessful) {
                    //show name
                    val profileDota2User = profile?.SoloRanketMmr
                    x = profileDota2User.toString()

                } else {
                    //Show error
                    showError()
                }*/
                x = "Termina sleep en hilo"
            }
        }
        return x
    }

    private fun showError() {
        Toast.makeText(this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show()
    }


}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val DNIDot = remember {
        mutableStateOf("211612523")
    }
    Scaffold(
        floatingActionButton = {
            ExtendedFloatingActionButton(
                //modifier = Modifier.,

                //horizontalAlignment = Alignment.CenterHorizontally,
                onClick = {
                    val mActivity = MainActivity()
                    DNIDot.value = mActivity.searchProfilebyId(DNIDot.value)
                },
                icon = {

                },
                text = { Text("Cargar User") }
            )
        }
    ) {
        Text(
            text = "Tu DNI dotero ${DNIDot.value}",
            modifier = Modifier.padding(vertical = 2.dp),
            color = Color.Red
        )
    }

}

fun cambiarId(idDot: String): String {
    return idDot
}


//@Composable
/*fun Listita(lista: List<People>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        item {
            for (people in lista) {
                Text(
                    text = "Hola desarrollador ${people.name}!!!",
                    modifier = Modifier.padding(vertical = 2.dp),
                    color = Color.Red
                )
                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    for (skill in people.skills) {

                        item {
                            Text(
                                text = "Skill ${skill}!!!",
                                modifier = Modifier.padding(vertical = 2.dp),
                                color = Color.Blue
                            )
                        }
                    }
                }


            }
        }
    }

}
*/
/*
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Listita(
        listOf(
            People(
                "Angel Pro",
                listOf("Python", "Javita", "sdasda", "sdasda", "sdasda", "sdasda", "Nose")
            ),
            People(
                "Jhon",
                listOf("Python", "Java", "Dota 2", "sdasda", "xd", "sdasda", "Nose")
            ),
            People(
                "Cindy",
                listOf("Python", "Java", "sdasda", "sdasda", "sdasda", "sdasda", "Nose")
            ),
            People(
                "Jhon",
                listOf("Python", "Java", "Dota 2", "sdasda", "xd", "sdasda", "Nose")
            ),
            People(
                "Cindy",
                listOf("Python", "Java", "sdasda", "sdasda", "sdasda", "sdasda", "Nose")
            ),
            People(
                "Jhon",
                listOf("Python", "Java", "Dota 2", "sdasda", "xd", "sdasda", "Nose")
            ),
            People(
                "Cindy",
                listOf("Python", "Java", "sdasda", "sdasda", "sdasda", "sdasda", "Nose")
            ),
            People(
                "Jhon",
                listOf("Python", "Java", "Dota 2", "sdasda", "xd", "sdasda", "Nose")
            ),
            People(
                "Cindy",
                listOf("Python", "Java", "sdasda", "sdasda", "sdasda", "sdasda", "Nose")
            ),
            People(
                "Cindy",
                listOf("Python", "Java", "sdasda", "sdasda", "sdasda", "sdasda", "Nose")
            ),
            People(
                "Jhon",
                listOf("Python", "Java", "Dota 2", "sdasda", "xd", "sdasda", "Nose")
            ),
            People(
                "Cindy",
                listOf("Python", "Java", "sdasda", "sdasda", "sdasda", "sdasda", "Nose")
            ),
            People(
                "Jhon",
                listOf("Python", "Java", "Dota 2", "sdasda", "xd", "sdasda", "Nose")
            ),
            People(
                "Cindy",
                listOf("Python", "Java", "sdasda", "sdasda", "sdasda", "sdasda", "Nose")
            ),
            People(
                "Jhon",
                listOf("Python", "Java", "Dota 2", "sdasda", "xd", "sdasda", "Nose")
            ),
            People(
                "Cindy",
                listOf("Python", "Java", "sdasda", "sdasda", "sdasda", "sdasda", "Nose")
            ),
            People(
                "Cindy",
                listOf("Python", "Java", "sdasda", "sdasda", "sdasda", "sdasda", "Nose")
            ),
            People(
                "Jhon",
                listOf("Python", "Java", "Dota 2", "sdasda", "xd", "sdasda", "Nose")
            ),
            People(
                "Cindy",
                listOf("Python", "Java", "sdasda", "sdasda", "sdasda", "sdasda", "Nose")
            ),
            People(
                "Jhon",
                listOf("Python", "Java", "Dota 2", "sdasda", "xd", "sdasda", "Nose")
            ),
            People(
                "Cindy",
                listOf("Python", "Java", "sdasda", "sdasda", "sdasda", "sdasda", "Nose")
            ),
            People(
                "Jhon",
                listOf("Python", "Java", "Dota 2", "sdasda", "xd", "sdasda", "Nose")
            ),
            People(
                "Cindy",
                listOf("Python", "Java", "sdasda", "sdasda", "sdasda", "sdasda", "Nose")
            )

        )
    )
}

class People(var name: String, var skills: List<String>)
*/
