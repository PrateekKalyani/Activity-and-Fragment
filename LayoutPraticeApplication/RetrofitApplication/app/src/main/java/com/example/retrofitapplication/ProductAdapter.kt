package com.example.retrofitapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofitapplication.databinding.SingleProductItemBinding

class ProductAdapter(
    private val productList : List<ProductModel>,
    private val context : Context
    ) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>(){

    class ProductViewHolder(private val binding : SingleProductItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(
            product : ProductModel,
            context : Context) {

            binding.run {
                productTitle.text = product.title
                productDescription.text = product.description
                priceText.text = "Price : ${product.price}"
                categoryText.text  = "Category : ${product.category}"
                rateText.text = "Rate : ${product.rating.rate}"
                countText.text = "Count : ${product.rating.count}"

                Glide.with(context)
                    .load(product.image)
                    .error(R.drawable.ic_launcher_background)
                    .into(productImage)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {

        return ProductViewHolder(SingleProductItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {

        holder.bind(product = productList[position], context = context)
    }

    override fun getItemCount(): Int {
        return productList.size
    }
}