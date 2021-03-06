package com.example.shopping.data.remote.service

import com.example.shopping.data.entity.category.CategoryEntity
import com.example.shopping.data.remote.url.Url
import com.example.shopping.data.response.categoty.CategoryResponse
import com.example.shopping.data.response.home.RecommendResponse
import com.example.shopping.data.response.order.RefundResponse
import com.example.shopping.data.response.product.ProductDetailResponse
import com.example.shopping.data.response.product.ProductResponse
import com.example.shopping.data.response.user.LoginResponse
import com.example.shopping.data.response.user.UserDetailResponse
import com.example.shopping.data.response.user.UserResponse
import com.example.shopping.model.remote.order.BodyOrderResponse
import com.example.shopping.model.remote.order.OrderRefundCancelModel
import com.example.shopping.model.recyclerView.product.order.OrderRequestListModel
import com.example.shopping.model.remote.order.BodyRefundResponse
import com.example.shopping.model.remote.order.OrderResponse
import com.example.shopping.model.user.LoginModel
import com.example.shopping.model.user.RegisterModel
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @GET(Url.PUT_CATEGORY)
    suspend fun putCategory(category: CategoryEntity)

    @GET(Url.GET_CATEGORY)
    suspend fun getAllCategory(): Response<CategoryResponse>

    @GET(Url.GET_PRODUCTS_BY_CATEGORY)
    suspend fun getCategoryByProducts(
        @Path("category_id") category_id: String,
        @Query("sort_type") sort_type: Int = 0,
        @Query("page") page: Int = 1,
        @Query("take") take: Int = 10
    ): Response<ProductResponse>

    @POST(Url.CREATE_USER)
    suspend fun createUser(
        @Body registerModel: RegisterModel
    ): Response<UserResponse>

    @POST(Url.SIGN_IN)
    suspend fun signIn(
        @Body loginModel: LoginModel
    ): Response<LoginResponse>

    @GET(Url.SIGN_OUT)
    suspend fun signOut(
        @Header("Authorization") access_token: String
    ): Response<String>

    @GET(Url.GET_USER_DETAIL)
    suspend fun getUserDetail(
        @Header("Authorization") access_token: String
    ): Response<UserDetailResponse>

    @GET(Url.GET_HOME)
    suspend fun getHome() : Response<List<RecommendResponse>>

    @GET(Url.GET_PRODUCT_DETAIL)
    suspend fun getProductDetail(
        @Path("product_id") product_id: String
    ) : Response<ProductDetailResponse>

    @POST(Url.ORDERS_CREATE)
    suspend fun orderProduct(
        @Header("Authorization") access_token: String,
        @Body items: OrderRequestListModel
    ) : Response<OrderResponse>

    @GET(Url.GET_ORDERS)
    suspend fun getOrders(
        @Header("Authorization") access_token: String
    ) : Response<BodyOrderResponse>

    @GET(Url.GET_REFUNDS)
    suspend fun getRefunds(
        @Header("Authorization") access_token: String
    ) : Response<BodyRefundResponse>

    @POST(Url.REQUEST_REFUND_CANCEL)
    suspend fun requestRefundCancel(
        @Header("Authorization") access_token: String,
        @Path("order_id") order_id: String,
        @Body orderRefundCancelModel: OrderRefundCancelModel
    ) : Response<RefundResponse>

    @POST(Url.DELETE_ORDER)
    suspend fun deleteOrder(
        @Header("Authorization") access_token: String,
        @Path("order_id") order_id: String
    ): Response<OrderResponse>

    @POST(Url.DELETE_REFUND)
    suspend fun deleteRefund(
        @Header("Authorization") access_token: String,
        @Path("order_id") order_id: String
    ): Response<RefundResponse>

    @GET(Url.SEARCH_PRODUCTS)
    suspend fun getSearchProducts(
        @Query("keyword") keyword: String
    ): Response<ProductResponse>
}
