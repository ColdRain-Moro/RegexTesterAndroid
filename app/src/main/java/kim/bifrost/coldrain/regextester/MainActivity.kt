package kim.bifrost.coldrain.regextester

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // 结果输出框只读
        editText5.keyListener = null
        button.setOnClickListener {
            editText5.setText(parseRegex(editText4.text.toString(), editText3.text.toString()).run {
                "共找到 ${this.size} 处匹配: \n" + this.joinToString("\n")
            })
            Toast.makeText(this, "匹配完成!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun parseRegex(regex: String, input: String): List<String> {
        val m = regex.toPattern().matcher(input)
        val array = mutableListOf<String>()
        while (m.find()) {
            array.add(m.group())
        }
        return array
    }
}