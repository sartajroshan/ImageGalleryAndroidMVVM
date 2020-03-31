package tk.crackntech.imagegallery.data.model

data class Photos(
    var page: Int,
    var pages: Int,
    var perpage: Int,
    var photo: List<Photo>,
    var total: Int
)