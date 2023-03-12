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
import ru.artbez.shopapptest.models.FlashsaleItemsModel

class RVFlashsaleAdapter: RecyclerView.Adapter<RVFlashsaleAdapter.MyViewHolder>() {

    private var flashsaleList = emptyList<FlashsaleItemsModel>()

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.flashsale_item_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val fCategories = holder.itemView.findViewById<TextView>(R.id.flashsalecategories)
        val fGood = holder.itemView.findViewById<TextView>(R.id.flashsalegood)
        val fPrice = holder.itemView.findViewById<TextView>(R.id.flashsaleprice)
        val fPercent = holder.itemView.findViewById<TextView>(R.id.flashsalepercent)
        val fImage = holder.itemView.findViewById<ImageView>(R.id.flashsaleimage)

        val fdPrice: String = flashsaleList[position].price.toString()
        val fdPriceFull = "$ $fdPrice"

        val discount: String = flashsaleList[position].discount.toString()
        val discountFull = "$discount% off"

        fCategories.text = flashsaleList[position].category
        fGood.text = flashsaleList[position].name
        fPrice.text = fdPriceFull
        fPercent.text = discountFull

        Glide.with(MAIN)
            .load(flashsaleList[position].image_url)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(fImage)
    }

    override fun getItemCount(): Int {
        return flashsaleList.size
    }

    fun setList(fList: List<FlashsaleItemsModel>){
        flashsaleList = fList
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