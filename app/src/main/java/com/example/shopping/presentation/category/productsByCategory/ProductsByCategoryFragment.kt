package com.example.shopping.presentation.category.productsByCategory

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.shopping.model.product.ProductModel
import com.example.shopping.presentation.adapter.model.ModelRecyclerAdapter
import com.example.shopping.presentation.base.BaseFragment
import com.example.shopping.presentation.base.BaseViewModel
import com.example.shopping.presentation.listener.AdapterListener
import com.example.shopping.presentation.listener.ProductListListener
import org.koin.android.viewmodel.ext.android.viewModel
import kotlin.study.shopping.R
import kotlin.study.shopping.databinding.FragmentCategoryBinding
import kotlin.study.shopping.databinding.FragmentCategoryTest1Binding
import kotlin.study.shopping.databinding.FragmentHomeBinding
import kotlin.study.shopping.databinding.FragmentProductsByCategoryBinding

class ProductsByCategoryFragment :
    BaseFragment<ProductsByCategoryViewModel, FragmentProductsByCategoryBinding>() {

    override val viewModel by viewModel<ProductsByCategoryViewModel>()

    override fun getViewBinding(): FragmentProductsByCategoryBinding =
        FragmentProductsByCategoryBinding.inflate(layoutInflater)

    private val adapter = ModelRecyclerAdapter<ProductModel, ProductsByCategoryViewModel>(
        listOf(),
        viewModel,
        adapterListener = object : AdapterListener {
        }
    )

    override fun observeData() {
        viewModel.pbcStateLiveData.observe(this) {
            when (it) {
                is ProductsByCategoryState.UnInitialized -> {
                }
                is ProductsByCategoryState.Loading -> {
                }
                is ProductsByCategoryState.Success -> {
                }
            }
        }

        viewModel.productListLiveData.observe(this) {
            adapter.submitList(it)
        }
    }

    override fun initViews() = with(binding) {
        recyclerView.adapter = adapter
        viewModel.settingList()
    }

    companion object {

        fun newInstance(): ProductsByCategoryFragment {
            val args = Bundle()
            val fragment = ProductsByCategoryFragment()
            fragment.arguments = args
            return fragment
        }
    }
}