package com.faiz.recipecatalogue.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.faiz.recipecatalogue.DetailActivity
import com.faiz.recipecatalogue.data.Recipes
import com.faiz.recipecatalogue.databinding.RowItemRecipeBinding

class RecipesAdapter(private val listRecipes: ArrayList<Recipes>) :
    RecyclerView.Adapter<RecipesAdapter.MyViewHolder>(){

    inner class  MyViewHolder(val binding: RowItemRecipeBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(
        RowItemRecipeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.apply {
            with(listRecipes[position]){
                tvNameRecipe.text = name
                tvCategory.text = category
                tvPrice.text = price
                Glide.with(imgRecipe.context).load(photo).into(imgRecipe)
            }
        }
        holder.itemView.setOnClickListener{
            val intent = Intent(it.context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.DATA_RECIPES, listRecipes[position])
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount() = listRecipes.size
}