package com.example.shopping.data.remote.url

object Url {
    const val BASE_URL = "/../"
    const val MOCK_URL = "/v1/"

    const val PUT_CATEGORY = ""
    const val GET_CATEGORY = "/categories"
    const val GET_PRODUCTS_BY_CATEGORY = "/categories/{category_id}/products"

    const val CREATE_USER = "users/create"
    const val SIGN_IN = "/auth/sign-in"
}