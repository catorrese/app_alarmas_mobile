package com.example.appalarmas

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageButton
import android.widget.Spinner
import android.widget.TextView
import android.widget.TimePicker
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import com.example.appalarmas.databinding.ActivityAlarmaCrearBinding
import com.example.appalarmas.databinding.ActivityAlarmaDetalleBinding


class AlarmaCrearActivity : AppCompatActivity() {

    private lateinit var alarmaBinding: ActivityAlarmaCrearBinding
    private lateinit var aniadirButton: Button
    private lateinit var backButton: ImageButton
    private lateinit var picker: TimePicker
    //private lateinit var alarma: Alarma
    private lateinit var nombre: TextView
    private lateinit var tono: TextView
    private lateinit var reto: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        alarmaBinding = ActivityAlarmaCrearBinding.inflate(layoutInflater)
        setContentView(alarmaBinding.root)

        picker = alarmaBinding.timePicker
        picker.setIs24HourView(true)
        picker.isEnabled = true
        //picker.hour = alarma.hora?.split(':')?.get(0)?.toInt() ?: 0
        //picker.minute = alarma.hora?.split(':')?.get(1)?.toInt() ?: 0

        nombre = alarmaBinding.alarmaSelectedNombre

        val spinner: Spinner = findViewById(R.id.tonos_spinner)
        ArrayAdapter.createFromResource(
            this,
            R.array.tonos,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }

        val spinner2: Spinner = findViewById(R.id.reto_spinner)
        ArrayAdapter.createFromResource(
            this,
            R.array.retos,
            android.R.layout.simple_spinner_item
        ).also { adapter2 ->
            // Specify the layout to use when the list of choices appears
            adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner2.adapter = adapter2
        }

        backButton = alarmaBinding.detalleAlarmaBack
        backButton.setOnClickListener {
            finish()
        }

        aniadirButton = alarmaBinding.alarmaGuardar
        aniadirButton.setOnClickListener {
            finish()
        }


    }

}