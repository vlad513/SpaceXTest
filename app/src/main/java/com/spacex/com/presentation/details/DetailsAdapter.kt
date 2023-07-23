package com.spacex.com.presentation.details

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.spacex.com.R
import com.spacex.com.databinding.ItemCrewBinding
import com.spacex.domain.models.crew.CrewModelDomain


class DetailsAdapter :
    RecyclerView.Adapter<DetailsAdapter.RepozHolder>() {
    private val repozList = ArrayList<CrewModelDomain>()

    class RepozHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        private val binding = ItemCrewBinding.bind(itemView)
        @SuppressLint("SimpleDateFormat", "SetTextI18n")
        fun bind(repoz: CrewModelDomain) = with(binding) {
           TvName.text = repoz.name
           TvAgency.text = repoz.agency
           TvStatus.text = repoz.status
           ImAvatar.load(repoz.image)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepozHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_crew, parent, false)
        return RepozHolder(view)
    }

    override fun onBindViewHolder(holder: RepozHolder, position: Int) {
        holder.bind(repozList[position])
    }

    override fun getItemCount(): Int {
        return repozList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addRepoz(repoz: CrewModelDomain) {
        repozList.add(repoz)
        notifyDataSetChanged()
    }


}