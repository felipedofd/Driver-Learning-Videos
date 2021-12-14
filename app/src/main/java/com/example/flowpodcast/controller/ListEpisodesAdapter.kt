package com.example.flowpodcast.controller

import Items
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
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

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = EpisodesItemsListBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val response = itemsList[position]
        holder.bind(response)
        val source =itemsList[position].id
        holder.itemView.setOnClickListener { v ->
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(itemsList[position].id.videoId)
            v.context.startActivity(i)
        }
            if (source != null) {
                holder.itemView

            }

    }

    override fun getItemCount(): Int {
        return itemsList.size
    }
}