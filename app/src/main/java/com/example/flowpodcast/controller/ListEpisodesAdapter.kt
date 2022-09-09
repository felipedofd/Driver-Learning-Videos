package com.example.flowpodcast.controller

import Items
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.flowpodcast.EXTRA_MESSAGE
import com.example.flowpodcast.PlayerActivity
import com.example.flowpodcast.databinding.EpisodesItemsListBinding
import com.squareup.picasso.Picasso

class ListEpisodesAdapter(
    private val itemsList: List<Items>,
    private val context: Context
) : RecyclerView.Adapter<ListEpisodesAdapter.ViewHolder>() {

    class ViewHolder(val binding: EpisodesItemsListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(response: Items) {
            binding.descriptionEpisode.text = response.snippet.description
            binding.titleEpisode.text = response.snippet.title
            Picasso.get().load(response.snippet.thumbnails.high.url).into(binding.imageEpisode)

            binding.root.setOnClickListener { v ->
//                i.data = Uri.parse(response.id.videoId
//               )
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