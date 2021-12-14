import com.example.flowpodcast.jsonresponse.Snippet

data class Items(

    val kind: String,
    val etag: String,
    val id: Id,
    val snippet: Snippet
)