package mx.edu.ittepic.tpdm_practica2_kevinvillegas


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.MenuItem
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isInvisible
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var menuLista : ListView?=null
    var RbtnVector : RadioButton?=null
    var RbtnMatriz : RadioButton?=null
    var LayoReg : LinearLayout?=null
    var editCasilla: EditText?=null
    var editRenglones :EditText?=null
    var matriz = 0
    var vector = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        RbtnVector=findViewById(R.id.rabuVector)
        RbtnMatriz=findViewById(R.id.rabuMatriz)
        LayoReg=findViewById(R.id.Layorenglones)
        menuLista=findViewById(R.id.menuOpciones)
        editCasilla=findViewById(R.id.campoCasillas)




        val Lopciones:Array<String> = resources.getStringArray(R.array.opcinesmenu)
        val arrayAdapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,Lopciones)
        menuLista?.adapter = arrayAdapter

        menuLista?.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, position, id ->
            val indice = adapterView.getItemIdAtPosition(position).toString().toInt()

            when(indice)
            {
                0->{ valida()}
                1->{
                    var activity3= Intent(this,Main3Activity::class.java)
                    var cadena = intent.extras?.getString("cadena") //Aqui comienza a mandar datos
                    activity3.putExtra("cadena",cadena)
                    startActivity(activity3) }

                2->{AlertDialog.Builder(this).setTitle("Acerca de")
                    .setMessage("(C) Kevin Alexis Villegas Estanco")
                    .setPositiveButton("Aceptar"){dialog,which->}
                    .show()}
                3->{finish()}
            }
        }


        var textR = TextView(this)
        textR.setText("Renglones : ")
        editRenglones= EditText(this)
        editRenglones?.setHint(" Numero de Celdas                        ")
        editRenglones?.inputType=InputType.TYPE_CLASS_NUMBER
        LayoReg?.addView(textR)
        LayoReg?.addView(editRenglones)

        RbtnVector?.setOnClickListener {

            LayoReg?.removeAllViews() }

        RbtnMatriz?.setOnClickListener{
            LayoReg?.removeAllViews()
            var textR = TextView(this)
            textR.setText("Renglones : ")
            editRenglones= EditText(this)
            editRenglones?.setHint("Numero de Renglones                       ")
            editRenglones?.inputType=InputType.TYPE_CLASS_NUMBER
            LayoReg?.addView(textR)
            LayoReg?.addView(editRenglones) }


    }


    fun valida() {
        if(RbtnMatriz?.isChecked==true){
            if(editCasilla?.text.toString().isEmpty() or editRenglones?.text.toString().isEmpty()){
                AlertDialog.Builder(this).setTitle("Error")
                    .setMessage("Llenar los datos para hacer una matriz")
                    .setPositiveButton("Aceptar"){dialog,which->}
                    .show()
            }
            else {
                matriz=1
                var activity2= Intent(this,Main2Activity::class.java)
                activity2.putExtra("matriz",1)
                startActivity(activity2)
            }

        }
        if(RbtnVector?.isChecked==true) {
            if(editCasilla?.text.toString().isEmpty())
            {
                AlertDialog.Builder(this).setTitle("Error")
                    .setMessage("Llenar los datos para hacer un vector")
                    .setPositiveButton("Aceptar"){dialog,which->}
                    .show()
            }
            else{
                vector=1
                var activity2= Intent(this,Main2Activity::class.java)
                activity2.putExtra("vector",1)
                startActivity(activity2)
            }

        }
    }



}