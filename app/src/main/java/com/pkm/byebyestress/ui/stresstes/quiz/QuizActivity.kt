package com.pkm.byebyestress.ui.stresstes.quiz

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.pkm.byebyestress.databinding.ActivityQuizBinding

class QuizActivity : AppCompatActivity() {
   private lateinit var binding: ActivityQuizBinding
   private val daftarSoal = mutableListOf(
      "Soal 1",
      "Soal 2",
      "Soal 3",
      "Soal 4",
      "Soal 5",
      "Soal 6",
      "Soal 7",
      "Soal 8",
      "Soal 9",
      "Soal 10"
   )
   private var posisiSoalSaatIni = 0
   private val jawabanPengguna = IntArray(daftarSoal.size) { -1 }
   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      binding = ActivityQuizBinding.inflate(layoutInflater)
      setContentView(binding.root)

      tampilkanSoal(posisiSoalSaatIni)

      binding.next.setOnClickListener {
         if (posisiSoalSaatIni < daftarSoal.size - 1) {
            posisiSoalSaatIni++
            tampilkanSoal(posisiSoalSaatIni)
         } else if (posisiSoalSaatIni == daftarSoal.size - 1) {
            // Jika ini adalah soal terakhir, lakukan sesuatu di sini
            // Misalnya, hitung total bobot jawaban
            hitungTotalBobotJawaban()
         }
      }

      binding.back.setOnClickListener {
         if (posisiSoalSaatIni > 0) {
            posisiSoalSaatIni--
            tampilkanSoal(posisiSoalSaatIni)
         }
      }

      binding.radioGroup.setOnCheckedChangeListener { _, checkedId ->
         val bobotJawaban = when (checkedId) {
            binding.button1.id -> 1
            binding.button2.id -> 2
            binding.button3.id -> 3
            binding.button4.id -> 4
            binding.button5.id -> 5
            else -> -1
         }
         // Simpan jawaban pada posisi soal saat ini
         jawabanPengguna[posisiSoalSaatIni] = bobotJawaban
      }
   }

   private fun tampilkanSoal(posisi: Int) {
      // Mengatur teks tombol "Next" atau "Finish" berdasarkan posisi soal
      if (posisi == daftarSoal.size - 1) {
         binding.next.text = "Finish"
      } else if (posisi < daftarSoal.size - 1) {
         binding.next.text = "Next"
      }

      // Menampilkan soal dengan posisi tertentu
      binding.soal.text = daftarSoal[posisi]

      // Memuat jawaban pengguna jika ada
      val jawabanPenggunaSebelumnya = jawabanPengguna[posisi]
      if (jawabanPenggunaSebelumnya != -1) {
         // Menandai radio button berdasarkan jawaban pengguna sebelumnya
         when (jawabanPenggunaSebelumnya) {
            1 -> binding.button1.isChecked = true
            2 -> binding.button2.isChecked = true
            3 -> binding.button3.isChecked = true
            4 -> binding.button4.isChecked = true
            5 -> binding.button5.isChecked = true
         }
      } else {
         // Mengatur semua radio button menjadi tidak dipilih jika tidak ada jawaban sebelumnya
         binding.radioGroup.clearCheck()
      }
   }

   private fun hitungTotalBobotJawaban() {
      // Menghitung total bobot jawaban
      var totalBobot = 0
      for (jawaban in jawabanPengguna) {
         if (jawaban != -1) {
            totalBobot += jawaban
         }
      }
      // Lakukan sesuatu dengan total bobot, misalnya tampilkan hasilnya
      Toast.makeText(this, "Total Bobot Jawaban: $totalBobot", Toast.LENGTH_SHORT).show()
   }
}