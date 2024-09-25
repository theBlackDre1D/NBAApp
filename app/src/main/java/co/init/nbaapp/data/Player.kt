package co.init.nbaapp.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Player(
    @SerializedName("id") val id: Int,
    @SerializedName("first_name") val firstName: String,
    @SerializedName("last_name") val lastName: String,
    @SerializedName("position") val position: String,
    @SerializedName("height") val height: String,
    @SerializedName("weight") val weight: String,
    @SerializedName("jersey_number") val jerseyNumber: String,
    @SerializedName("college") val college: String,
    @SerializedName("country") val country: String,
    @SerializedName("draft_year") val draftYear: String,
    @SerializedName("draft_round") val draftRound: String,
    @SerializedName("draft_number") val draftNumber: String,
    @SerializedName("team") val team: Team
) : Serializable {

    val fullName: String
        get() = "$firstName $lastName"
}