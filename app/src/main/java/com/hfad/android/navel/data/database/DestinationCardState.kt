package com.hfad.android.navel.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.hfad.android.navel.R
import com.hfad.android.navel.data.models.DestCardModel

@Entity(tableName = "destCardTable")
data class DestinationCardState  (
    @ColumnInfo(name = "name") val name: String = "",
    @ColumnInfo(name = "type") val type: String = "",
    @ColumnInfo(name = "country") val country: String = "",
    @ColumnInfo(name = "city") val city: String = "",
    @ColumnInfo(name = "flag") val flag: Int = 0,
    @ColumnInfo(name = "rating") val rating: Double = 0.0,
    @ColumnInfo(name = "addedToBookmark") val addedToBookmark: Boolean = false,
    @ColumnInfo(name = "imageUri") val imageUri: Int = R.drawable.komodo_island,
) {
    @PrimaryKey(autoGenerate = true)
    var id = 0

}



//fun DestCardModel.convertToState(destCardModel: DestCardModel): DestinationCardState {
//
//    val name = destCardModel.name
//    val type = destCardModel.type
//    val country = destCardModel.country
//    val city = destCardModel.city
//    val flag = destCardModel.flag
//    val rating = destCardModel.rating
//    val addedToBookmark = destCardModel.addedToBookmark
//    val imageUri = destCardModel.imageUri
//
//    return DestinationCardState(name, type, country, city, flag, rating, addedToBookmark, imageUri)
//}
