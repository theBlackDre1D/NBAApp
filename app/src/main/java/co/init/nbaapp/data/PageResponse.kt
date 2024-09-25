package co.init.nbaapp.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PageResponse<T : Serializable>(
    @SerializedName("data") val data: List<T>,
    @SerializedName("meta") val meta: Meta
) : Serializable

data class Meta(
    @SerializedName("next_cursor") val nextCursor: Int,
    @SerializedName("per_page") val perPage: Int
) : Serializable