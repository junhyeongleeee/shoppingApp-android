package com.example.shopping.data.remote.service

import com.example.shopping.data.entity.category.CategoryEntity
import com.example.shopping.data.remote.url.Url
import com.example.shopping.data.response.categoty.CategoryResponse
import com.example.shopping.data.response.product.ProductResponse
import com.example.shopping.data.response.user.UserResponse
import com.example.shopping.model.user.RegisterModel
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @GET(Url.PUT_CATEGORY)
    suspend fun putCategory(category: CategoryEntity)

    @GET(Url.GET_CATEGORY)
    suspend fun getAllCategory(): Response<List<CategoryResponse>>

    @GET(Url.GET_PRODUCTS_BY_CATEGORY)
    suspend fun getCategoryByProducts(
        @Path("category_id") category_id: String,
        @Query("sort_type") sort_type: Int = 0,
        @Query("page") page: Int = 1,
        @Query("take") take: Int = 10
    ): Response<List<ProductResponse>>

    @POST(Url.CREATE_USER)
    suspend fun createUser(
        @Body registerModel: RegisterModel
    ): Response<UserResponse>
}