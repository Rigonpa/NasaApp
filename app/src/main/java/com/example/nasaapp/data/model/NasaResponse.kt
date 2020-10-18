package com.example.nasaapp.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NasaResponse(

	@field:SerializedName("total")
	val total: Int? = null,

	@field:SerializedName("perpage")
	val perpage: Int? = null,

	@field:SerializedName("count")
	val count: Int? = null,

	@field:SerializedName("page")
	val page: Int? = null,

	@field:SerializedName("results")
	val results: List<List<String>>? = null
) : Parcelable
