package com.tassiecomp.myretrofittrial

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

//문자열이 제이슨  형태인지, 재이슨 배열 형태인지
fun String?.isJsonObject():Boolean {
    if(this?.startsWith("{") == true && this.endsWith("}")){
        return true
    } else{
        return false
    }
}

//문자열이 제이슨 배열인지
//여기서String?.했기때문에 가능하다.
fun String?.isJsonArray() : Boolean {
    if(this?.startsWith("[") == true && this.endsWith("]")){
        return true
    } else{
        return false
    }
}

fun EditText.onMyTextChanged(completion:(Editable?) -> Unit){
    //this는 edittext를 뜻한다.
    this.addTextChangedListener(object: TextWatcher {

        override fun afterTextChanged(editable: Editable?) {
            completion(editable)
        }
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

        }



    })
}