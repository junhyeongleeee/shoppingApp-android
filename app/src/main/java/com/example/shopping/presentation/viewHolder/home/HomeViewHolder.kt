package com.example.shopping.presentation.viewHolder.home

import com.example.shopping.extensions.load
import com.example.shopping.model.recyclerView.product.ProductModel
import com.example.shopping.presentation.adapter.model.ModelViewHolder
import com.example.shopping.presentation.base.BaseViewModel
import com.example.shopping.presentation.listener.AdapterListener
import com.example.shopping.presentation.listener.ProductListListener
import com.example.shopping.util.provider.ResourcesProvider
import kotlin.study.shopping.databinding.ViewholderHomeBinding

class HomeViewHolder(
    private val binding: ViewholderHomeBinding,
    viewModel: BaseViewModel,
    resourcesProvider: ResourcesProvider
): ModelViewHolder<ProductModel>(binding, viewModel, resourcesProvider) {

    override fun bindViews(model: ProductModel, adapterListener: AdapterListener){
        if( adapterListener is ProductListListener){
            binding.root.setOnClickListener {
                adapterListener.onClickItem(model)
            }
        }
    }

    override fun bindData(model: ProductModel) = with(binding){
        name.text = model.name
        price.text = model.price.toString() + "원 "
        img.load(model.image_url?: "", corner = 0f)
    }
}
