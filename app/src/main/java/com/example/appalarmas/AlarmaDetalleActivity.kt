package com.example.appalarmas

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.TimePicker
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.fragment.app.DialogFragment
import com.example.appalarmas.databinding.ActivityAlarmaDetalleBinding


class AlarmaDetalleActivity : AppCompatActivity(), EliminarDialog.NoticeDialogListener {

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
            val newFragment = EliminarDialog()
            val args = Bundle()
            args.putString("Nombre", alarma.name)
            newFragment.arguments = args
            newFragment.show(supportFragmentManager, alarma.name)
        }

        probar = alarmaBinding.probarAlarma
        probar.setOnClickListener {
            try {
                val intent = Intent(this, ProbarSimpleActivity::class.java)
                intent.putExtra("ALARMA", alarma)
                ActivityCompat.startActivity(this, intent, null)

            } catch (e: ActivityNotFoundException) {
                // display error state to the user
            }
        }

    }

    override fun onDialogPositiveClick(dialog: DialogFragment) {
        finish()
    }
}