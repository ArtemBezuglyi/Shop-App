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

class RVBrandsAdapter: RecyclerView.Adapter<RVBrandsAdapter.MyViewHolder>() {

    private var brandsList = emptyList<LatestItemsModel>()

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.brands_item_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val bCategories = holder.itemView.findViewById<TextView>(R.id.brandscategories)
        val bGood = holder.itemView.findViewById<TextView>(R.id.brandsgood)
        val bPrice = holder.itemView.findViewById<TextView>(R.id.brandsprice)
        val bImage = holder.itemView.findViewById<ImageView>(R.id.brandsimage)

        val bdPrice: String = brandsList[position].price.toString()
        val bdPriceFull = "$ $bdPrice"

        bCategories.text = brandsList[position].category
        bGood.text = brandsList[position].name
        bPrice.text = bdPriceFull

        Glide.with(MAIN)
            .load(brandsList[position].image_url)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(bImage)
    }

    override fun getItemCount(): Int {
        return brandsList.size
    }

    fun setList(bList: List<LatestItemsModel>){
        brandsList = bList
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