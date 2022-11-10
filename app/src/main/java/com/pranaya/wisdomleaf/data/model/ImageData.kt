package com.pranaya.wisdomleaf.data.model

import android.net.Uri
import com.google.gson.annotations.SerializedName


/** sample data from API
  *id	:	22
  *author	:	Alejandro Escamilla
  *width	:	4434
  *height	:	3729
  *url	:	https://unsplash.com/photos/du_OrQAA4r0
  *download_url	:	https://picsum.photos/id/22/4434/3729
**/
data class ImageData(@SerializedName("id") val id: String,
                     @SerializedName("author")val author: String,
                     @SerializedName("width")val width : Long,
                     @SerializedName("height")val heigh : Long,
                     @SerializedName("url")val url : String,
                     @SerializedName("download_url")val downloadUrl : String) {


}