package programmer.zaman.now.pemmobtugas5

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.PendingIntentCompat.send
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
//      Implemntasi Date
        val date = Date()
        val formatter = SimpleDateFormat("EEEE, dd-MMMM-yyyy", Locale.getDefault())
        val formattedDate = formatter.format(date)

//      Set text oleh date
        val dateText : TextView = findViewById(R.id.date_text)
        dateText.setText(formattedDate);

//      Explicit
        val phoneInput : EditText = findViewById(R.id.phone_input)
        val saveButton : Button = findViewById(R.id.saveButton)

        saveButton.setOnClickListener({
            val sendPhone = phoneInput.text.toString();
            send(sendPhone)

            //      Implementasi Toast
            Toast.makeText(this, "Nomor di kirim", Toast.LENGTH_SHORT).show()

        })
    }

    private fun send(sendPhone: String) {
        val intent = Intent(this, MainActivity2::class.java )
        intent.putExtra("Dikirim", sendPhone)
        startActivity(intent)
    }
}