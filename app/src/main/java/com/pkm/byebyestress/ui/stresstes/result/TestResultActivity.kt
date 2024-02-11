package com.pkm.byebyestress.ui.stresstes.result

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.pkm.byebyestress.R
import com.pkm.byebyestress.databinding.ActivityTestResultBinding

class TestResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTestResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras
        val score = bundle?.getInt("bobot")

        binding.score.text = score.toString()
        if (score != null) {
            val drawable: Drawable
            val icon: Drawable
            if (score <= 13) {
                drawable = ContextCompat.getDrawable(this, R.drawable.ellipse)!!
                icon = ContextCompat.getDrawable(this, R.drawable.stress_rendah)!!
                setViewColor(
                    "Stres Rendah",
                    getString(R.string.rekomendasi_stres_ringan), drawable, icon, "#58C2C5"
                )
            } else if (score <= 26 && score >= 14) {
                drawable = ContextCompat.getDrawable(this, R.drawable.ellipseyellow)!!
                icon = ContextCompat.getDrawable(this, R.drawable.stress_sedang)!!
                setViewColor(
                    "Stres Sedang",
                    getString(R.string.rekomendasi_stres_sedang), drawable, icon, "#FFDF39"
                )
            } else if (score <= 40 && score >= 27) {
                drawable = ContextCompat.getDrawable(this, R.drawable.ellipsered)!!
                icon = ContextCompat.getDrawable(this, R.drawable.stress_berat)!!
                setViewColor(
                    "Stres Tinggi",
                    getString(R.string.rekomendasi_stres_berat),
                    drawable,
                    icon,
                    "#FF5C39"
                )
            }
        }
    }

    private fun setViewColor(
        title: String,
        rekomendasi: String,
        drawable: Drawable,
        icon: Drawable,
        colorText: String
    ) {
        val color = Color.parseColor(colorText)
        binding.recomendationTitle.text = title
        binding.recomendationTitle.setTextColor(color)
        binding.ellipseCorner.background = drawable
        binding.ellipseLeft.background = drawable
        binding.ellipseRight.background = drawable
        binding.expressionImage.setImageDrawable(icon)
        binding.recomendationBody.text = rekomendasi
    }
}