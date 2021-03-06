package com.example.shopping.di

import android.widget.SearchView
import com.example.shopping.presentation.category.CategoryViewModel
import com.example.shopping.presentation.category.productsByCategory.ProductsByCategoryViewModel
import com.example.shopping.presentation.detail.ProductDetailActivityViewModel
import com.example.shopping.presentation.detail.navigation.order.OrderViewModel
import com.example.shopping.presentation.detail.navigation.productDetail.ProductDetailViewModel
import com.example.shopping.presentation.home.HomeViewModel
import com.example.shopping.presentation.home.alarm.AlarmViewModel
import com.example.shopping.presentation.main.MainViewModel
import com.example.shopping.presentation.my.MyViewModel
import com.example.shopping.presentation.my.auth.AuthViewModel
import com.example.shopping.presentation.my.auth.navigation.login.LoginViewModel
import com.example.shopping.presentation.my.auth.navigation.register.RegisterViewModel
import com.example.shopping.presentation.my.orderList.OrderListViewModel
import com.example.shopping.presentation.my.refundList.RefundListViewModel
import com.example.shopping.presentation.my.userDetail.UserDetailViewModel
import com.example.shopping.presentation.search.SearchViewModel
import com.example.shopping.presentation.search.navigation.products.SearchResultViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ViewModelModule = module {
    viewModel { MainViewModel() }
    viewModel { CategoryViewModel(get()) }
    viewModel { SearchResultViewModel(get()) }
    viewModel { SearchViewModel() }
    viewModel { MyViewModel(get(), get()) }
    viewModel { HomeViewModel(get()) }
    viewModel { (category_id: String) -> ProductsByCategoryViewModel(category_id, get()) }
    viewModel { AlarmViewModel() }
    viewModel { AuthViewModel() }
    viewModel { LoginViewModel(get(), get()) }
    viewModel { RegisterViewModel(get()) }
    viewModel { UserDetailViewModel(get(), get()) }
    viewModel { ProductDetailActivityViewModel() }
    viewModel { (product_id: String) -> ProductDetailViewModel(product_id, get(), get()) }
    viewModel { OrderViewModel(get(), get()) }
    viewModel { OrderListViewModel(get(), get()) }
    viewModel { RefundListViewModel(get(), get()) }
}