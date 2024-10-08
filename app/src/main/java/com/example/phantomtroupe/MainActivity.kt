package com.example.phantomtroupe

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.phantomtroupe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var heroAdapter: HeroAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Using ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize hero data
        val heroList = listOf(
            Hero("Chrollo Luciifer", "Deskripsi Chrollo", R.drawable.chrollo, 0, "01 Januari 1990"),
            Hero("Nobunaga Hazama", "Deskripsi Nobu", R.drawable.nobu, 1, "11 Januari 1999"),
            Hero("Feitan Portor", "Deskripsi Feitan", R.drawable.feitan, 2, "21 Oktober 2000"),
            Hero("Machi Komacine", "Deskripsi Machi", R.drawable.machi, 3, "16 September 2010"),
            Hero("Hisoka Morrow", "Deskripsi Hisoka", R.drawable.hisoka, 4, "05 Januari 1994"),
            Hero("Phinks", "Deskripsi Phinks", R.drawable.phinks, 5, "01 Desember 1998"),
            Hero("Shalnark", "Deskripsi Shalnark", R.drawable.shalnark, 6, "17 September 1998"),
            Hero("Shizuku Murasaki", "Deskripsi Shizuku", R.drawable.shizuku, 8, "15 Maret 2003")
        )

        // Initialize RecyclerView
        heroAdapter = HeroAdapter(heroList, this)
        binding.recyclerViewMemberInfo.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewMemberInfo.adapter = heroAdapter
    }
}