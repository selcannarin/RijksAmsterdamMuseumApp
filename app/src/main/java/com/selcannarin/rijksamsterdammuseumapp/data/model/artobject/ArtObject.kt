package com.selcannarin.rijksamsterdammuseumapp.data.model.artobject

data class ArtObject(

    val id: String,
    val objectNumber: String,
    val principalOrFirstMaker: String,
    val title: String,
    val webImage: WebImage
)

