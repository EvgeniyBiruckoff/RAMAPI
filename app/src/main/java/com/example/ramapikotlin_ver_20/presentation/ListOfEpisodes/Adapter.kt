package com.example.ramapikotlin_ver_20.presentation.ListOfEpisodes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ramapikotlin_ver_20.databinding.LoeRecyclerViewItemBinding
import com.example.ramapikotlin_ver_20.domain.models.Episode

class Adapter(data:List<Episode>) : RecyclerView.Adapter<Adapter.ViewHolder>() {
    var dataArrayList:List<Episode>
    init {
        dataArrayList = data
    }
    class ViewHolder(val binding: LoeRecyclerViewItemBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = LoeRecyclerViewItemBinding.inflate(inflater,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val episode = dataArrayList.get(position)
        with(holder.binding){
            name.text = episode.name
            airDate.text = episode.air_date

        }
    }

    override fun getItemCount(): Int {
        return dataArrayList.size
    }
}



