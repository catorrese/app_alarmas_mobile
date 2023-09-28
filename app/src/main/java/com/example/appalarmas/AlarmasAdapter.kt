package com.example.appalarmas

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.materialswitch.MaterialSwitch
import com.google.android.material.switchmaterial.SwitchMaterial

class AlarmasAdapter(private val contexto: AppCompatActivity) :
    RecyclerView.Adapter<AlarmasAdapter.AlarmaViewHolder>() {
    private var data: ArrayList<Alarma>? = null

    fun setData(list: ArrayList<Alarma>) {
        data = list
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): AlarmaViewHolder {
        return AlarmaViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.alarma_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    override fun onBindViewHolder(holder: AlarmaViewHolder, position: Int) {
        val item = data?.get(position)
        holder.bindView(item,contexto)

    }

    class AlarmaViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        fun bindView(item: Alarma?, contexto: AppCompatActivity) {
            val name: TextView = itemView.findViewById(R.id.alarmaName)
            name.text = item?.name
            val hora: TextView = itemView.findViewById(R.id.alarmaHora)
            hora.text = item?.hora

            val switch: MaterialSwitch = itemView.findViewById(R.id.alarmaSwitch)
            switch.isChecked = true
            val layout: LinearLayout =itemView.findViewById(R.id.alarmaItemLayout)

            layout.setOnClickListener {
                val intent = Intent(contexto, AlarmaDetalleActivity::class.java)
                intent.putExtra("ALARMA", item)
                ActivityCompat.startActivity(contexto, intent, null)
            }
        }
    }
}