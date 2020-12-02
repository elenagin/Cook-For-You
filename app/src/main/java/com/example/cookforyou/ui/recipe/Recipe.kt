package com.example.cookforyou.ui.recipe

/**
 * author: Elena Ginebra Z.
 * date: 10 Nov 2020
 * description: Data Class RecipeItem for database data
 */
data class Recipe (
    var id: Int=0,
    var name: String? = "",
    var description: String? = "",
    val image_url: String? = "",
    val ingredient1: String? = "",
    val ingredient2: String? = "",
    val ingredient3: String? = "",
    val amount_ingredient1: Float? = 0.0f,
    val amount_ingredient2: Float? = 0.0f,
    val amount_ingredient3: Float? = 0.0f,
    val unit_ingredient1: String? = "",
    val unit_ingredient2: String? = "",
    val unit_ingredient3: String? = "",
)
