package com.example.goalsapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.goalsapp.R
import com.example.goalsapp.model.Data

class GoalsAdapter(val context: Context, val dataset: List<Data>) :
    RecyclerView.Adapter<GoalsAdapter.itemsViewHolder>() {

    inner class itemsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.itemTv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemsViewHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.items, parent, false)
        return itemsViewHolder(adapterLayout)
    }

    override fun getItemCount() = dataset.size

    override fun onBindViewHolder(holder: itemsViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = item.goalName

        val bundle = bundleOf(
            "head" to item.goalName,
            "description" to item.description,
            "dueDate" to item.dueDate
        )

        holder.itemView.setOnClickListener {
            holder.itemView.findNavController().navigate(R.id.goalsFragment, bundle)
        }
    }
}