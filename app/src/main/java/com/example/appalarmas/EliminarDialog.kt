package com.example.appalarmas

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class EliminarDialog : DialogFragment() {

    internal lateinit var listener: NoticeDialogListener

    interface NoticeDialogListener {
        fun onDialogPositiveClick(dialog: DialogFragment)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            listener = context as NoticeDialogListener
        } catch (e: ClassCastException) {
            throw ClassCastException((context.toString() +
                    " must implement NoticeDialogListener"))
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            // Use the Builder class for convenient dialog construction.
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater
            val view = inflater.inflate(R.layout.fragment_eliminar_dialog, null)
            val mArgs = arguments
            val myValue = mArgs!!.getString("Nombre")
            val texto = view.findViewById<TextView>(R.id.eliminarText)
            texto.text = getString(R.string.eliminarContent) + " " + myValue + "?"
            val eliminar = view.findViewById<Button>(R.id.eliminarBtn)
            eliminar.setOnClickListener {
                listener.onDialogPositiveClick(this)
            }
            val cancelar = view.findViewById<Button>(R.id.cancelarBtn)
            cancelar.setOnClickListener {
                dialog?.cancel()
            }
            builder.setView(view)

            // Create the AlertDialog object and return it.
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}
