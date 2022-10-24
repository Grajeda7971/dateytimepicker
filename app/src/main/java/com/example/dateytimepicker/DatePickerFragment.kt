package com.example.dateytimepicker

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import java.time.Month
import java.util.*

//esta funcion recive el listener, y para ejecutarlo hay que mandar 3 parametros
class DatePickerFragment(val listener: (day:Int, month:Int, year:Int) -> Unit): DialogFragment(),
    DatePickerDialog.OnDateSetListener{


    /*DialogFragment: Se trata de la clase padre que tiene todo el código para poder mostrar los datePicker,
    por ello extendemos de esta clase, porque si extendemos ya tenemos todos los métodos que esta tiene.*/

    /*
    DatePickerDialog.OnDateSetListener: Añadir esto hará que podamos implementar una función para saber cuando el
    usuario ha seleccionado una fecha y que valores ha seleccionado
     */


    //Esta función se llamará cuando el usuario seleccione una fecha y nos devolverá los datos seleccionados
    //entonces le ponemos el listener para poder mandar estos datos al mainActivity
    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        listener(dayOfMonth,month,year)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c: Calendar = Calendar.getInstance()
        val day: Int =c.get(Calendar.DAY_OF_MONTH)
        val month: Int = c.get(Calendar.MONTH)
        val year: Int = c.get(Calendar.YEAR)

        val picker= DatePickerDialog(activity as Context, this, year,month,day)
        return picker
    }

}