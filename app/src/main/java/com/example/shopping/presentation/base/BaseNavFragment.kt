package com.example.shopping.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import kotlinx.coroutines.Job

abstract class BaseNavFragment<VB: ViewBinding>: Fragment() {

    abstract val viewModel : BaseViewModel

    protected lateinit var binding: VB

    abstract fun getViewBinding(): VB

    private lateinit var fetch: Job

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = getViewBinding()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fetch = viewModel.fetch()
        observeData()
        initViews()
    }

    abstract fun observeData()

    open fun initViews() = Unit

    override fun onDestroyView() {
        super.onDestroyView()

        if(fetch.isActive){
            fetch.cancel()
        }
    }
}