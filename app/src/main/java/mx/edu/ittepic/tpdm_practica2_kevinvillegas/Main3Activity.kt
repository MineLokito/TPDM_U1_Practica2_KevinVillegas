package mx.edu.ittepic.tpdm_practica2_kevinvillegas

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import androidx.appcompat.app.AlertDialog
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Main3Activity : AppCompatActivity() {
    var abrir: Button? = null
    var exportar: Button? = null
    var archivo1: RadioButton? = null
    var archivo2: RadioButton? = null
    var archivo3: RadioButton? = null
    var ecxel = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        abrir = findViewById(R.id.btnAbrir)
        exportar = findViewById(R.id.btnExp)
        archivo1 = findViewById(R.id.abrirA1)
        archivo2 = findViewById(R.id.abrirA2)
        archivo3 = findViewById(R.id.abrirA3)

        abrir?.setOnClickListener {
            ecxel = 0
            if (archivo1?.isChecked == true) {
                abrirA1()
            }
            if (archivo2?.isChecked == true) {
                abrirA2()
            }
            if (archivo3?.isChecked == true) {
                abrirA3()
            }
        }

        exportar?.setOnClickListener {
            ecxel = 1
            if (archivo1?.isChecked == true) {
                abrirA1()
            }
            if (archivo2?.isChecked == true) {
                abrirA2()
            }
            if (archivo3?.isChecked == true) {
                abrirA3()
            }
        }

    }

    fun abrirA1() {
        var cadena = intent.extras?.getString("cadena")
        if (ecxel == 1) {
            val guardarArchivo =
                OutputStreamWriter(openFileOutput("archivo1.csv", Activity.MODE_PRIVATE))
            guardarArchivo.write(cadena)
            guardarArchivo.flush()
            AlertDialog.Builder(this).setTitle("ATENCION")
                .setMessage("SE EXPORTO ARCHIVO 1")
                .setPositiveButton("ACEPTAR") { dialog, which -> }
                .show()
        } else {
            val abrirArchivo = BufferedReader(InputStreamReader(openFileInput("archivo1.txt")))
            var cad = abrirArchivo.readLine()
            AlertDialog.Builder(this).setTitle("ATENCION")
                .setMessage("SE ABRIO ARCHIVO 1")
                .setPositiveButton("ACEPTAR") { dialog, which -> }
                .show()
        }
    }

    fun abrirA2() {
        var cadena = intent.extras?.getString("cadena")
        if (ecxel == 1) {
            val guardarArchivo =
                OutputStreamWriter(openFileOutput("archivo2.csv", Activity.MODE_PRIVATE))
            guardarArchivo.write(cadena)
            guardarArchivo.flush()
            AlertDialog.Builder(this).setTitle("ATENCION")
                .setMessage("SE EXPORTO ARCHIVO 2")
                .setPositiveButton("ACEPTAR") { dialog, which -> }
                .show()
        } else {
            val abrirArchivo = BufferedReader(InputStreamReader(openFileInput("archivo2.txt")))
            var cad = abrirArchivo.readLine()
            AlertDialog.Builder(this).setTitle("ATENCION")
                .setMessage("SE ABRIO ARCHIVO 3")
                .setPositiveButton("ACEPTAR") { dialog, which -> }
                .show()
        }
    }

    fun abrirA3() {
        var cadena = intent.extras?.getString("cadena")
        if (ecxel == 1) {
            val guardarArchivo =
                OutputStreamWriter(openFileOutput("archivo3.csv", Activity.MODE_PRIVATE))
            guardarArchivo.write(cadena)
            guardarArchivo.flush()
            AlertDialog.Builder(this).setTitle("ATENCION")
                .setMessage("SE EXPORTO ARCHIVO 2")
                .setPositiveButton("ACEPTAR") { dialog, which -> }
                .show()
        } else {
            val abrirArchivo = BufferedReader(InputStreamReader(openFileInput("archivo3.txt")))
            var cad = abrirArchivo.readLine()
            AlertDialog.Builder(this).setTitle("ATENCION")
                .setMessage("SE ABRIO ARCHIVO 3")
                .setPositiveButton("ACEPTAR") { dialog, which -> }
                .show()
        }
    }
}