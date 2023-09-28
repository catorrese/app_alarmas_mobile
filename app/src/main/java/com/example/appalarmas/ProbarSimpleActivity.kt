package com.example.appalarmas

import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.appalarmas.databinding.ActivityAlarmaDetalleBinding
import com.example.appalarmas.databinding.ActivityProbarSimpleBinding

class ProbarSimpleActivity : AppCompatActivity(){

    private lateinit var probarSimpleBinding: ActivityProbarSimpleBinding
    private lateinit var detenerButton: Button
    private lateinit var titulo: TextView
    private lateinit var hora: TextView
    private lateinit var alarma: Alarma
    private lateinit var mMediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        probarSimpleBinding = ActivityProbarSimpleBinding.inflate(layoutInflater)
        setContentView(probarSimpleBinding.root)

        mMediaPlayer = MediaPlayer();
        mMediaPlayer = MediaPlayer.create(this, R.raw.radar);
        mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mMediaPlayer.isLooping = true;
        mMediaPlayer.start();

        alarma = intent.getSerializableExtra("ALARMA") as Alarma

        titulo = probarSimpleBinding.ProbarSimpleTitulo
        titulo.text = alarma.name

        hora = probarSimpleBinding.ProbarSimpleHora
        hora.text = alarma.hora

        detenerButton = probarSimpleBinding.detenerSimple
        detenerButton.setOnClickListener {
            mMediaPlayer.stop()
            mMediaPlayer.release()
            finish()
        }

    }
}

