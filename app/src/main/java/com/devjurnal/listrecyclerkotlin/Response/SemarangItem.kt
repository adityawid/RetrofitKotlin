package com.devjurnal.listrecyclerkotlin.Response

import com.google.gson.annotations.SerializedName

data class SemarangItem(

	@field:SerializedName("longitude_wisata")
	val longitudeWisata: Double? = null,

	@field:SerializedName("id_wisata")
	val idWisata: Int? = null,

	@field:SerializedName("deskripsi_wisata")
	val deskripsiWisata: String? = null,

	@field:SerializedName("latitude_wisata")
	val latitudeWisata: Double? = null,

	@field:SerializedName("nama_wisata")
    var namaWisata: String? = null,

	@field:SerializedName("gambar_wisata")
	val gambarWisata: String? = null,

	@field:SerializedName("alamat_wisata")
	val alamatWisata: String? = null
)