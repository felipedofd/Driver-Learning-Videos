package com.example.driverlearningvideos.controller

import com.example.driverlearningvideos.data.Items
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.driverlearningvideos.EXTRA_MESSAGE
import com.example.driverlearningvideos.player.PlayerActivity
import com.example.driverlearningvideos.databinding.EpisodesItemsListBinding
import com.squareup.picasso.Picasso

class ListEpisodesAdapter(
    private val itemsList: List<Items>,
    private val context: Context
) : RecyclerView.Adapter<ListEpisodesAdapter.ViewHolder>() {

    class ViewHolder(private val binding: EpisodesItemsListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(response: Items) {
            binding.descriptionEpisode.text = response.snippet.description
            binding.titleEpisode.text = response.snippet.title
            Picasso.get().load(response.snippet.thumbnails.high.url).into(binding.imageEpisode)

            binding.root.setOnClickListener { v ->
                val intent = Intent(binding.root.context, PlayerActivity::class.java)
                intent.putExtra(EXTRA_MESSAGE, response.id.videoId)
                binding.root.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = EpisodesItemsListBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val response = itemsList[position]
        holder.bind(response)
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }
}