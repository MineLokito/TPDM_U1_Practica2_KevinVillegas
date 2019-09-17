package mx.edu.ittepic.tpdm_practica2_kevinvillegas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.GridLayout
import android.widget.TextView
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {


    var campoRenglon: TextView?=null
    var campoCelda: TextView?=null
    var grid: GridLayout?=null
    var capturar: Button?=null




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        campoCelda=findViewById(R.id.columna)
        campoRenglon=findViewById(R.id.camprenglon)
        grid = findViewById(R.id.grid)
        capturar = findViewById(R.id.btnCapturar)


        var celda= intent.extras?.getInt("celda")
        var renglon= intent.extras?.getInt("renglon")
       //campoCelda?.setText(celda.toString())
        //campoRenglon?.setText(renglon.toString())

        if (renglon==0) {
            camprenglon.isInvisible=true
            etiquetaRenglon.isInvisible=true
        }
        else{
            camprenglon.isVisible=true
            etiquetaRenglon.isVisible=true
        }

        grid?.columnCount = celda.toString().toInt()
        grid?.rowCount = renglon.toString().toInt()

        btnRegresar.setOnClickListener {
            finish()
        }

        capturar?.setOnClickListener {
            var v = valor?.text.toString()

            var etiqueta = TextView(this)
            etiqueta.setText(v)
            





            grid?.addView(etiqueta)




        }









    }
}
