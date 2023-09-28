package com.example.appalarmas

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.TimePicker
import androidx.appcompat.app.AppCompatActivity

import com.example.appalarmas.databinding.ActivityAlarmaDetalleBinding

class AlarmaDetalleActivity : AppCompatActivity() {

    private lateinit var alarmaBinding: ActivityAlarmaDetalleBinding
    private lateinit var eliminarButton: Button
    private lateinit var backButton: ImageButton
    private lateinit var picker: TimePicker
    private lateinit var alarma: Alarma
    private lateinit var nombre: TextView
    private lateinit var tono: TextView
    private lateinit var reto: TextView
    private lateinit var probar : TextView
    private lateinit var titulo: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        alarmaBinding = ActivityAlarmaDetalleBinding.inflate(layoutInflater)
        setContentView(alarmaBinding.root)

        alarma = intent.getSerializableExtra("ALARMA") as Alarma

        picker = alarmaBinding.timePicker
        picker.setIs24HourView(true)
        picker.isEnabled = false
        picker.hour = alarma.hora?.split(':')?.get(0)?.toInt() ?: 0
        picker.minute = alarma.hora?.split(':')?.get(1)?.toInt() ?: 0

        nombre = alarmaBinding.alarmaSelectedNombre
        nombre.text = alarma.name

        tono = alarmaBinding.alarmaSelectedTono
        tono.text = alarma.tono

        reto = alarmaBinding.alarmaSelectedReto
        reto.text = alarma.reto

        titulo = alarmaBinding.AlarmaTitulo
        titulo.text = alarma.name

        backButton = alarmaBinding.detalleAlarmaBack
        backButton.setOnClickListener {
            finish()
        }

        eliminarButton = alarmaBinding.alarmaEliminar
        eliminarButton.setOnClickListener {
            finish()
        }

        probar = alarmaBinding.probarAlarma
        //probar.setOnClickListener {
        //
        //}

    }
}