package tk.crackntech.imagegallery.data.model

data class Photo(
    var farm: Int,
    var height_s: Int,
    var id: String,
    var isfamily: Int,
    var isfriend: Int,
    var ispublic: Int,
    var owner: String,
    var secret: String,
    var server: String,
    var title: String,
    var url_s: String,
    var width_s: Int
)