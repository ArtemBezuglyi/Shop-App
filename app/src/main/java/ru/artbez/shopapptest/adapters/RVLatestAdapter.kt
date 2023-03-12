package ru.artbez.shopapptest.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.artbez.shopapptest.MAIN
import ru.artbez.shopapptest.R
import ru.artbez.shopapptest.models.LatestItemsModel

class RVLatestAdapter: RecyclerView.Adapter<RVLatestAdapter.MyViewHolder>() {

    private var latestList = emptyList<LatestItemsModel>()

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.latest_item_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val lCategories = holder.itemView.findViewById<TextView>(R.id.latestcategories)
        val lGood = holder.itemView.findViewById<TextView>(R.id.latestgood)
        val lPrice = holder.itemView.findViewById<TextView>(R.id.latestprice)
        val lImage = holder.itemView.findViewById<ImageView>(R.id.latestimage)

        val ldPrice: String = latestList[position].price.toString()
        val ldPriceFull = "$ $ldPrice"

        lCategories.text = latestList[position].category
        lGood.text = latestList[position].name
        lPrice.text = ldPriceFull

        Glide.with(MAIN)
            .load(latestList[position].image_url)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(lImage)
    }

    override fun getItemCount(): Int {
        return latestList.size
    }

    fun setList(lList: List<LatestItemsModel>){
        latestList = lList
        notifyDataSetChanged()
    }

    override fun onViewAttachedToWindow(holder: MyViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener {
            Toast.makeText(MAIN, "Page 2 is in progress", Toast.LENGTH_LONG).show()
        }
    }

    override fun onViewDetachedFromWindow(holder: MyViewHolder) {
        holder.itemView.setOnClickListener(null)
    }
}