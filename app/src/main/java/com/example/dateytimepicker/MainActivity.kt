package com.example.dateytimepicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DateFormat

//recuerda agregar en el gradle module el id kotlin-android-extensions
//esto nos ayudara a conectar y encontrar los ids sin el findViewById

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //una vez creado le ponemos el listener y le mandamos la funcion
        //cada vez que se pulse llamara al metodo
        etDate.setOnClickListener{showDatePickerDialog()}
        etTime.setOnClickListener { showTimePickerDialog() }
    }

    private fun showDatePickerDialog(){
        //aqui se manda a llamar el fragment con los parametros pedidos y creara el date picker

        val datePicker= DatePickerFragment{day, month, year ->  onDateSelected(day, month, year)}
        datePicker.show(supportFragmentManager,"datepicker")
    }

    fun onDateSelected(day:Int, month:Int, year:Int){
        etDate.setText("Has seleccionado el dia $day del mes $month del año $year")
    }

    private fun showTimePickerDialog() {
        val timePicker = TimePickerFragment { onTimeSelected(it) }
        timePicker.show(supportFragmentManager, "timePicker")
    }

    private fun onTimeSelected(time: String) {
        etTime.setText("Has seleccionado las:  $time")
    }



}