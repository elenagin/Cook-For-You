package com.example.cookforyou.ui.recipes

/**
 * author: Elena Ginebra Z.
 * date: 10 Nov 2020
 * description: Data Class MyRecipesItem for database data
 */
data class MyRecipesItem (
    var name: String? = "",
    var description: String? = "",
    val image_url: String? = "",
    val ingredient1: String? = "",
    val ingredient2: String? = "",
    val ingredient3: String? = "",
    val amount_ingredient1: Int? = 0,
    val amount_ingredient2: Int? = 0,
    val amount_ingredient3: Int? = 0,
    val unit_ingredient1: String? = "",
    val unit_ingredient2: String? = "",
    val unit_ingredient3: String? = "",
)
