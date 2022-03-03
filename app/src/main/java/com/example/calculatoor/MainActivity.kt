package com.example.calculatoor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    lateinit var two:TextView
    lateinit var three:TextView
    lateinit var four:TextView
    lateinit var five:TextView
    lateinit var six:TextView
    lateinit var seven:TextView
    lateinit var eight:TextView
    lateinit var nine:TextView
    lateinit var one:TextView
    lateinit var zero:TextView

    lateinit var plus:TextView
    lateinit var minus:TextView
    lateinit var multiply:TextView
    lateinit var divide:TextView
    lateinit var modulo:TextView
    lateinit var equals:TextView
    lateinit var changesign:TextView

    lateinit var decimal:TextView
    lateinit var expression:TextView
    lateinit var result:TextView

    lateinit var AC:TextView
    lateinit var back:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        one=findViewById(R.id.one)
        two=findViewById(R.id.two)
        three=findViewById(R.id.three)
        four=findViewById(R.id.four)
        five=findViewById(R.id.five)
        six=findViewById(R.id.six)
        seven=findViewById(R.id.seven)
        eight=findViewById(R.id.eight)
        nine=findViewById(R.id.nine)

        plus=findViewById(R.id.plus)
        minus=findViewById(R.id.minus)
        multiply=findViewById(R.id.multiply)
        divide=findViewById(R.id.divide)
        modulo=findViewById(R.id.modulo)
        equals=findViewById(R.id.ans)
        changesign=findViewById(R.id.changesign)
        decimal=findViewById(R.id.point)
        expression=findViewById(R.id.expression)
        result=findViewById(R.id.result)
        AC=findViewById(R.id.AC)
        back=findViewById(R.id.back)
        zero=findViewById(R.id.zero)

        one.setOnClickListener {
            appendText("1",true)
        }
        two.setOnClickListener {
            appendText("2",true)
        }
        three.setOnClickListener {
            appendText("3",true)
        }
        four.setOnClickListener {
            appendText("4",true)
        }
        five.setOnClickListener {
            appendText("5",true)
        }
        six.setOnClickListener {
            appendText("6",true)
        }
        seven.setOnClickListener {
            appendText("7",true)
        }
        eight.setOnClickListener {
            appendText("8",true)
        }
        nine.setOnClickListener {
            appendText("9",true)
        }
        zero.setOnClickListener {
            appendText("0",true)
        }

        plus.setOnClickListener {
            appendText("+",false)
        }
        minus.setOnClickListener {
            appendText("-",false)
        }
        multiply.setOnClickListener {
            appendText("*",false)
        }
        divide.setOnClickListener {
            appendText("/",false)
        }

        equals.setOnClickListener {
            try {
                val expr=ExpressionBuilder(expression.text.toString()).build()
                val answer=expr.evaluate()
                result.text=answer.toString()
            }
            catch (e : Exception){
                result.text=e.message
            }
        }
        back.setOnClickListener(){
            result.text=""
            result.hint=""
            val value=expression.text
            if(value.isNotEmpty()){
                expression.text=value.substring(0,value.length-1)
            }
        }
        AC.setOnClickListener(){
            result.text=""
            expression.text=""
            result.hint=""
        }
        modulo.setOnClickListener(){
            appendText("%",true)
        }
        changesign.setOnClickListener(){
            result.text=""
            result.hint=""
            if(expression.length()>0){
                expression.text=((expression.text.toString().toInt())*-1).toString()
            }
        }
        decimal.setOnClickListener(){
            appendText(".",true)
        }

    }

    fun appendText(value: String,tobeCleared:Boolean){

        if(result.text!= ""){
            expression.text=""
        }
        if(tobeCleared){
            result.text=""
            expression.append(value)
        }
        else{
            expression.append(result.text)
            expression.append(value)
            result.text=""
        }
        result.hint=expression.text
    }
}