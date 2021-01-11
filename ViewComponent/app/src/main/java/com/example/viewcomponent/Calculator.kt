package com.example.viewcomponent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_calculator.*

class Calculator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        var new = ""
        val calcStack = mutableListOf<String>()
        val resultList = mutableListOf<Any>()

        num1.setOnClickListener {
            new += "1"
            result.setText(new)
        }
        num2.setOnClickListener {
            new += "2"
            result.setText(new)
        }
        num3.setOnClickListener {
            new += "3"
            result.setText(new)
        }
        num4.setOnClickListener {
            new += "4"
            result.setText(new)
        }
        num5.setOnClickListener {
            new += "5"
            result.setText(new)
        }
        num6.setOnClickListener {
            new += "6"
            result.setText(new)
        }
        num7.setOnClickListener {
            new += "7"
            result.setText(new)
        }
        num8.setOnClickListener {
            new += "8"
            result.setText(new)
        }
        num9.setOnClickListener {
            new += "9"
            result.setText(new)
        }
        num0.setOnClickListener {
            new += "0"
            result.setText(new)
        }

        fun priority(operator: String): Int {
            return when (operator) {
                "*", "/" -> 1
                else -> 2
            }
        }

        plus.setOnClickListener {
            resultList.add(new.toInt())
            if (calcStack.size == 0) {
                calcStack.add("+")
            } else {
                if (priority("+") < priority(calcStack[calcStack.size - 1])) {
                    calcStack.add("+")
                } else {
                    resultList.add(calcStack.removeLast())
                    calcStack.add("+")
                }
            }
            new = ""
        }

        minus.setOnClickListener {
            resultList.add(new.toInt())
            if (calcStack.size == 0) {
                calcStack.add("-")
            } else {
                if (priority("-") < priority(calcStack[calcStack.size - 1])) {
                    calcStack.add("-")
                } else {
                    resultList.add(calcStack.removeLast())
                    calcStack.add("-")
                }
            }
            new = ""
        }

        multiply.setOnClickListener {
            resultList.add(new.toInt())
            if (calcStack.size == 0) {
                calcStack.add("*")
            } else {
                if (priority("*") < priority(calcStack[calcStack.size - 1])) {
                    calcStack.add("*")
                } else {
                    resultList.add(calcStack.removeLast())
                    calcStack.add("*")
                }
            }
            new = ""
        }

        divide.setOnClickListener {
            resultList.add(new.toInt())
            if (calcStack.size == 0) {
                calcStack.add("/")
            } else {
                if (priority("/") < priority(calcStack[calcStack.size - 1])) {
                    calcStack.add("/")
                } else {
                    resultList.add(calcStack.removeLast())
                    calcStack.add("/")
                }
            }
            new = ""
        }

        equal.setOnClickListener {
            resultList.add(new.toInt())
            while (calcStack.size != 0) {
                resultList.add(calcStack.removeLast())
            }

            fun postSix(list: MutableList<Any>): Int {
                val postStack = mutableListOf<Int>()

                for (i in list) {
                    if (i is Int) {
                        postStack.add(i)
                    } else {
                        val op1 = postStack.removeLast()
                        val op2 = postStack.removeLast()
                        if (i == "+") {
                            postStack.add(op2 + op1)
                        } else if (i == "-") {
                            postStack.add(op2 - op1)
                        } else if (i == "*") {
                            postStack.add(op2 * op1)
                        } else {
                            postStack.add(op2 / op1)
                        }
                    }
                }

                return postStack.removeLast()
            }

            result.setText(postSix(resultList).toString())
            calcStack.clear()
            resultList.clear()
            new = ""
        }

        clearAll.setOnClickListener {
            new = ""
            result.setText("0")
        }
    }
}