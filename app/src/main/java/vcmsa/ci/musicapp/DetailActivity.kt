package vcmsa.ci.musicapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class DetailActivity: AppCompatActivity() {

    private val ratings = mutableListOf<Float>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed_view_screen)

        val displayResults = findViewById<EditText>(R.id.displayResults)
        val averageResults = findViewById<TextView>(R.id.averageResults)
        val showsongButton=findViewById<Button>(R.id.showSongsButton)
        val CalculateButton=findViewById<Button>(R.id.CalculateButton)
        val BackButton=findViewById<Button>(R.id.BackButton)


        showsongButton.setOnClickListener{
            val input = displayResults.text.toString()
            if (input.isNotEmpty()){
                val rating = input.toFloatOrNull()
                if (rating != null && rating in 1.0..5.0){
                    ratings.add(rating)
                    Toast.makeText(this, "Added Rating: + ${rating}",Toast.LENGTH_SHORT).show()
                    displayResults.text.clear() } else {
                        Toast.makeText(this,"Please enter a valid rating (1 to 5)",Toast.LENGTH_SHORT).show()
                }
            }

        }

        CalculateButton.setOnClickListener{
            var total = 0f
            for (rate in ratings){
                total += rate
            }
            val average = if (ratings.isNotEmpty())total/ratings.size
            else 0f

            averageResults.text = "Average Rating: %.2f.format(average)"
        }


        BackButton.setOnClickListener{
            val intent = Intent(this,DetailActivity::class.java)
            startActivity(intent)
        }

    }
















}