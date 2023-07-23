package com.spacex.com.presentation.missions

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.spacex.com.R
import com.spacex.com.databinding.ItemMissionsBinding
import com.spacex.domain.models.launch.DocksModelDomain

import java.util.*

class MissionsAdapter(private var callback1: (DocksModelDomain) -> Unit) :
    RecyclerView.Adapter<MissionsAdapter.RepozHolder>() {
    private val repozList = ArrayList<DocksModelDomain>()

    class RepozHolder(itemView: View, private var callback1: (DocksModelDomain) -> Unit) :
        RecyclerView.ViewHolder(itemView) {
        private val binding = ItemMissionsBinding.bind(itemView)



        @SuppressLint("SimpleDateFormat", "SetTextI18n")
        fun bind(repoz: DocksModelDomain) = with(binding) {
            ImAvatar.load(repoz.links?.patch?.small)
            TvName.text = "Name: " + repoz.name.toString()
            TvCoresFlight.text = "Core.Flight: " + repoz.cores.first()?.flight
            TvSuccess.text = "Success: " + repoz.success
            if (repoz.date_utc.toString().isNullOrEmpty()) {
            } else {
                var dataBuff=""
                repoz.date_utc?.forEach {
                    if(it == 'T'){
                        TvDate.text = "Date: $dataBuff"
                    }else{
                        dataBuff += it.toString()
                    }
                }
            }
            CardView.setOnClickListener { callback1.invoke(repoz) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepozHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_missions, parent, false)
        return RepozHolder(view, callback1)
    }

    override fun onBindViewHolder(holder: RepozHolder, position: Int) {
        holder.bind(repozList[position])
    }

    override fun getItemCount(): Int {
        return repozList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addRepoz(repoz: List<DocksModelDomain>) {
        repozList.addAll(repoz)
        notifyDataSetChanged()
    }


}