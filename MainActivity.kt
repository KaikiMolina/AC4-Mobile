package com.ac1

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.ac1.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numero_zero.setOnClickListenner{ AcrescentarUmaExpressao(string:"0", limpar_dados:true) }
        numero_um.setOnClickListenner{ AcrescentarUmaExpressao(string:"1", limpar_dados:true) }
        numero_dois.setOnClickListenner{ AcrescentarUmaExpressao(string:"2", limpar_dados:true) }
        numero_tres.setOnClickListenner{ AcrescentarUmaExpressao(string:"3", limpar_dados:true) }
        numero_quatro.setOnClickListenner{ AcrescentarUmaExpressao(string:"4", limpar_dados:true) }
        numero_cinco.setOnClickListenner{ AcrescentarUmaExpressao(string:"5", limpar_dados:true) }
        numero_seis.setOnClickListenner{ AcrescentarUmaExpressao(string:"6", limpar_dados:true) }
        numero_sete.setOnClickListenner{ AcrescentarUmaExpressao(string:"7", limpar_dados:true) }
        numero_oito.setOnClickListenner{ AcrescentarUmaExpressao(string:"8", limpar_dados:true) }
        numero_nove.setOnClickListenner{ AcrescentarUmaExpressao(string:"9", limpar_dados:true) }
        ponto.setOnClickListenner{ AcrescentarUmaExpressao(string:".", limpar_dados:true) }

        soma.setOnClickListenner{ AcrescentarUmaExpressao(string:"+", limpar_dados:false) }
        subtracao.setOnClickListenner{ AcrescentarUmaExpressao(string:"-", limpar_dados:false) }
        multiplicacao.setOnClickListenner{ AcrescentarUmaExpressao(string:"*", limpar_dados:false) }
        divisao.setOnClickListenner{ AcrescentarUmaExpressao(string:"/", limpar_dados:false) }

        limpar.setOnClickListenner{ it:View!
            expressao.text = ""
            txt_resultado.text = ""
        }

        backspace.setOnClickListenner{ it:View!
            val string = expressao.text.toString()

            if(string.isNotBlank()){
                expressao.text = string.substring(0,string.length-1)
            }
            txt_resultado.text = ""
        }

        igual.setOnClickListenner{ it:View!
            try {
                val expressao = ExpressionBuilder(expressao.text.toString()).build()
                val resultado = expressao.evaluate()
                val longResult = resultado.toLong()

                if(resultafo == longResult.toDouble())
                    txt-resultado.text = longResult.toString()
                else
                    txt-resultado.text = resultado.toString()

            }catch (e: Exception){

            }
        }
    }

    fun AcrescentarUmaExpressao(string: String, limpar_dados: Boolean){

        if (txt_resultado.text.isNotEmpty()){
            expressao.text = ""
        }

        if (limpar_dados){
            txt_resultado.text = ""
            expressap.append(string)
        }else{
            expressao.append(txt_resultado.text)
            expressao.append(string)
            txt_resultado.text= ""
        }
    }
}