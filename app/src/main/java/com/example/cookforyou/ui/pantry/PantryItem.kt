package com.example.cookforyou.ui.pantry

/**
 * author: Elena Ginebra Z.
 * date: 10 Nov 2020
 * description: Data Class PantryItem for database data
 */
data class PantryItem (
    var item: String? = "",
    var amount: Int? = null,
    val unit: String? = "",
)

