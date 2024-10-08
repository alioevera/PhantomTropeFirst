package com.example.phantomtroupe

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.phantomtroupe.databinding.ItemMemberBinding

class HeroAdapter(private val heroes: List<Hero>, private val mainActivity: MainActivity) : RecyclerView.Adapter<HeroAdapter.HeroViewHolder>() {

    inner class HeroViewHolder(private val binding: ItemMemberBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(hero: Hero) {
            // Bind hero data to the views
            binding.namaMember.text = "Name: ${hero.name}"
            binding.nomorMember.text = "Number: ${hero.number}"
            binding.tanggalLahirMember.text = "Date of Birth: ${hero.birthDate}"
            binding.iconMember.setImageResource(hero.photo)

            // Set an OnClickListener on the root view
            binding.root.setOnClickListener {
                // Create an Intent to start DetailMemberActivity
                val context: Context = binding.root.context
                val intent = Intent(context, DetailMemberActivity::class.java).apply {
                    putExtra("HERO_NAME", hero.name) // Pass the hero name
                    putExtra("HERO_IMAGE", hero.photo) // Pass the hero image resource ID
                }
                context.startActivity(intent)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        val binding = ItemMemberBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HeroViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        holder.bind(heroes[position])
    }

    override fun getItemCount(): Int = heroes.size
}
