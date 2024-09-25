package co.init.nbaapp.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Team(
    @SerializedName("id") val id: Int,
    @SerializedName("conference") val conference: String,
    @SerializedName("division") val division: String,
    @SerializedName("city") val city: String,
    @SerializedName("name") val name: String,
    @SerializedName("full_name") val fullName: String,
    @SerializedName("abbreviation") val abbreviation: String
) : Serializable