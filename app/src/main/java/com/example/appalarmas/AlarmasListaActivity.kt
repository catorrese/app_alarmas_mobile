package com.example.appalarmas

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appalarmas.databinding.ActivityAlarmasListaBinding

class AlarmasListaActivity : AppCompatActivity() {

    private lateinit var alarmasBinding: ActivityAlarmasListaBinding
    private lateinit var adapter: AlarmasAdapter
    private lateinit var recycler: RecyclerView
    private lateinit var anadirButton: ImageButton

    private lateinit var alarmas : ArrayList<Alarma>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        alarmasBinding = ActivityAlarmasListaBinding.inflate(layoutInflater)
        setContentView(alarmasBinding.root)
        recycler = findViewById(R.id.alarmasRecycler)
        adapter = AlarmasAdapter(this)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter
        anadirButton = alarmasBinding.crearAlarma

        //anadirButton.setOnClickListener{
        //    try {
        //        val intent = Intent(this, ::class.java)
        //
        //    } catch (e: ActivityNotFoundException) {
        //        // display error state to the user
        //    }
        //}
        alarmas = ArrayList()
        alarmas.add(Alarma(name = "Alarma 1", hora = "7:00", reto = "Triki", tono = "Radar"))
        alarmas.add(Alarma(name = "Alarma 2", hora = "7:30", reto = "Triki", tono = "Radar"))
        alarmas.add(Alarma(name = "Alarma 3", hora = "8:30", reto = "Triki", tono = "Radar"))
        alarmas.add(Alarma(name = "Alarma 4", hora = "10:30", reto = "Triki", tono = "Radar"))
        alarmas.add(Alarma(name = "Alarma 5", hora = "10:30", reto = "Triki", tono = "Radar"))
        alarmas.add(Alarma(name = "Alarma 6", hora = "11:45", reto = "Triki", tono = "Radar"))
        alarmas.add(Alarma(name = "Alarma 7", hora = "13:30", reto = "Triki", tono = "Radar"))
        alarmas.add(Alarma(name = "Alarma 8", hora = "16:30", reto = "Triki", tono = "Radar"))
        alarmas.add(Alarma(name = "Alarma 9", hora = "19:00", reto = "Triki", tono = "Radar"))
        recycler.visibility = View.VISIBLE
        adapter.setData(alarmas)
    }
}
