package mx.edu.ittepic.tpdm_practica2_kevinvillegas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isGone
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        var menuactivity1 : ListView?=null
        var rbton:RadioButton?=null
        var rbton2:RadioButton?=null
        var layor: RelativeLayout?=null
        var camporenglon:EditText?=null
        var campocelda:EditText?=null




        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        menuactivity1= findViewById(R.id.menuListview)
        rbton=findViewById(R.id.vector)
        rbton2=findViewById(R.id.matriz)
        layor=findViewById(R.id.layo)
        campocelda=findViewById(R.id.campo1)
        camporenglon=findViewById(R.id.campoRenglones)






        rbton?.setOnClickListener {
            etiquetaRenglones.isInvisible=true
            campoRenglones.isInvisible=true

        }

        rbton2?.setOnClickListener {
            etiquetaRenglones.isVisible=true
            campoRenglones.isVisible=true


        }






        menuactivity1?.setOnItemClickListener { parent, view, position, id ->

            //Switch
            when(position){
                0 -> capturarValores()
               // 1 -> abrirGuardarArchivos()
                2 -> abrirAcercaDe()
                3 -> finish()
            }

        }

    }

    fun capturarValores(){

        if(matriz?.isChecked==true){
            if (campo1?.text.toString().isEmpty()== true || campoRenglones?.text.toString().isEmpty()==true){
                val alerta= AlertDialog.Builder(this)
                alerta.setTitle("Alerta").setMessage(("No llenaste los campos Celdas o Matriz"))
                    .setPositiveButton("Aceptar"){dialog,which ->}.show()
            }
            else{

                var camporenglon:EditText?=null
                var campocelda:EditText?=null
                var reng =0
                var celda =0

                campocelda=findViewById(R.id.campo1)
                camporenglon=findViewById(R.id.campoRenglones)

                celda=campocelda?.text.toString().toInt()
                reng=camporenglon?.text.toString().toInt()


                var capturarDatos=Intent(this, Main2Activity::class.java)
                capturarDatos.putExtra("celda", celda)
                capturarDatos.putExtra("renglon",reng)
                startActivity(capturarDatos)


            }
        }
        if(vector?.isChecked==true){
            if (campo1?.text.toString().isEmpty()== true){
                val alerta= AlertDialog.Builder(this)
                alerta.setTitle("Alerta").setMessage(("No llenaste los campos Celdas"))
                    .setPositiveButton("Aceptar"){dialog,which ->}.show()
            }
            else{

                var campocelda:EditText?=null
                var celda =0

                campocelda=findViewById(R.id.campo1)
                celda=campocelda?.text.toString().toInt()

                var capturarDatos=Intent(this, Main2Activity::class.java)
                capturarDatos.putExtra("celda", celda)
                startActivity(capturarDatos)

            }
        }

    }
    fun abrirAcercaDe(){
        val alerta = AlertDialog.Builder(this)

        alerta.setTitle("Acerca De...").setMessage("(c) Kevin Alexis Villegas Estanco")
            .setPositiveButton("Aceptar"){dialogInterface, i ->  }.setNegativeButton("Cancelar"){dialog,which->}.show()

    }


    }

