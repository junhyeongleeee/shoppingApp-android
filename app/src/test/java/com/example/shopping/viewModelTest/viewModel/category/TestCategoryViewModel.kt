package com.example.shopping.viewModelTest.viewModel.category

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.shopping.data.remote.service.ApiService
import com.example.shopping.data.repository.TestCategoryRepository
import com.example.shopping.presentation.base.BaseViewModel
import com.example.shopping.presentation.category.CategoryState
import kotlinx.coroutines.*

class TestCategoryViewModel(
    private val service: ApiService
): BaseViewModel() {

    private var _mainStateLiveData = MutableLiveData<CategoryState>(CategoryState.UnInitialized)
    val mainStateLiveData: LiveData<CategoryState> = _mainStateLiveData

    private var categoryRepository: TestCategoryRepository

    init {
        categoryRepository = TestCategoryRepository(service)
    }

    override fun fetch(): Job = viewModelScope.launch{
        _mainStateLiveData.postValue(CategoryState.Loading)
        getCategories()
    }

    private fun getCategories() = viewModelScope.launch {
        val list = categoryRepository.getCategories()

        if(list.isEmpty()){
            _mainStateLiveData.postValue(CategoryState.Success(list.mapIndexed{ _, entity ->
                entity.toModel()
            }))
        }
        else _mainStateLiveData.postValue(CategoryState.Failure)
    }
}