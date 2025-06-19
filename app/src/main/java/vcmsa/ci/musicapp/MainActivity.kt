package vcmsa.ci.musicapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlin.system.exitProcess


class MainActivity:AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val tableLayoutEdit=findViewById<EditText>(R.id.tableLayoutEdit1)
            val playlistButton=findViewById<Button>(R.id.playlistButton)
            val nextButton=findViewById<Button>(R.id.nextButton)
        val exitButton=findViewById<Button>(R.id.exitButton)

            playlistButton.setOnClickListener{
                val music=tableLayoutEdit.text.toString().trim().lowercase()
                val musicDisplay=when (music){
                     "Song Title" -> ""
                         "Artist" -> ""
                    "Ratings" ->""
                    "Comments" -> ""


                    else -> "Please enter"}

                playlistButton.text=musicDisplay

        }

        nextButton.setOnClickListener{
            val intent = Intent(this,DetailActivity::class.java)
            startActivity(intent)

        }

        exitButton.setOnClickListener{
            finishAffinity()
            exitProcess(status = 0)
        }




    }
}