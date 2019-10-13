package cozy.techacademy.aisatsuapp

import android.app.TimePickerDialog
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        showTimePickerDialog()
    }

    private fun showTimePickerDialog() {
        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener { _, hour, minute ->
                Log.d("UI_PARTS", "$hour:$minute")

                var aisatsu = "null"
                when(hour) {
                    in  0 ..  1 -> aisatsu = "こんばんは"
                    in  2 ..  9 -> aisatsu = "おはよう"
                    in 10 .. 17 -> aisatsu = "こんにちは"
                    in 18 .. 23 -> aisatsu = "こんばんは"
                }
                textView.setText(aisatsu, TextView.BufferType.NORMAL)
            },
            13, 0, true)
        timePickerDialog.show()
    }

}
