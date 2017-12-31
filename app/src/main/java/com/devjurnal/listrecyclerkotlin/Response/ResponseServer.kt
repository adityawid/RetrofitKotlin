package com.devjurnal.listrecyclerkotlin.Response

import com.google.gson.annotations.SerializedName

data class ResponseServer(

	@field:SerializedName("semarang")
	val semarang: List<SemarangItem?>? = null
)