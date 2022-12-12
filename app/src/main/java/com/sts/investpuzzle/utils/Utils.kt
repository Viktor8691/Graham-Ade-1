package com.sts.investpuzzle.utils

import android.app.Dialog
import android.content.Context
import android.view.Window
import android.view.WindowManager
import androidx.viewbinding.ViewBinding
import com.sts.investpuzzle.core.data.network.model.stock.Stock

import java.util.Calendar
import kotlin.math.roundToInt

object Utils {

    fun customDialog(context: Context, viewBinding: ViewBinding) : Dialog{
        val dialog = Dialog(context)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(viewBinding.root)
        dialog.getWindow()?.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)

        return dialog
    }

    fun getMaxYearOfBirthday() : Int{
        return Calendar.getInstance().get(Calendar.YEAR)
    }

    fun intToStringTime(sec : Int) : String {
        val min = sec / 60
        val seconds = sec - min * 60
        return "$min:$seconds"
    }

    fun getTotalPrice(stock : Stock) : String {
        val totalPrice = (stock.volume * stock.price).roundToInt()
        return "$ $totalPrice USD"
    }

    fun getTotalPrice(price : Float, vol : Int) : String{
        val totalPrice = (price * vol).roundToInt() / 100.0
        return "$totalPrice"
    }

    fun getFileExtension(url : String) : String{
        return  url.substring(url.lastIndexOf(".")).replaceFirst(".", "")
    }
    fun makeFileName(ext : String) = "${System.currentTimeMillis()}.$ext"
}