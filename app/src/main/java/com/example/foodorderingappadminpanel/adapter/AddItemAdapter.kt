package com.example.foodorderingappadminpanel.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodorderingappadminpanel.databinding.ItemItemBinding

class AddItemAdapter(private val menuItemName: ArrayList<String>, private val menuItemPrice: ArrayList<String>, private val menuItemImage: ArrayList<Int>) : RecyclerView.Adapter<AddItemAdapter.AddItemViewHolder>() {
    private val itemQuantity = IntArray(menuItemName.size) {1}



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddItemViewHolder {
        val binding = ItemItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AddItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AddItemViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = menuItemName.size

    inner class AddItemViewHolder (private val binding: ItemItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {

            binding.apply {
                val quantity = itemQuantity[position]
                txtNoOfItem.text = quantity.toString()
                foodNametxt.text = menuItemName[position]
                foodPriceTxt.text = menuItemPrice[position]
                foodImageView.setImageResource(menuItemImage[position])

                btnMinus.setOnClickListener {
                    decreaseQuantity(position)
                }
                btnPlus.setOnClickListener {
                    increaseQuantity(position)
                }
                trash.setOnClickListener {
                    deleteQuantity(position)
                }
            }
        }

    private fun deleteQuantity(position: Int) {
        menuItemName.removeAt(position)
        menuItemPrice.removeAt(position)
        menuItemImage.removeAt(position)

        notifyItemRemoved(position)
        notifyItemRangeChanged(position, menuItemName.size)
    }

    private fun decreaseQuantity(position: Int) {
        if(itemQuantity[position] > 1) {
            itemQuantity[position]--
            binding.txtNoOfItem.text = itemQuantity[position].toString()
        }
    }

    private fun increaseQuantity(position: Int) {
        if(itemQuantity[position] < 10) {
            itemQuantity[position]++
            binding.txtNoOfItem.text = itemQuantity[position].toString()
        }
    }
    }
}