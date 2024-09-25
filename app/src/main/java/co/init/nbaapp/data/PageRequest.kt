package co.init.nbaapp.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PageRequest(
    @SerializedName("cursor") val cursor: Int,
    @SerializedName("per_page") val perPage: Int = DEFAULT_PAGE_SIZE
) : Serializable {

    companion object {
        private const val DEFAULT_PAGE_SIZE = 35
    }
}