package hu.aut.bme.matesebi.todocoach.model

data class Task (
    val id: Long? = null,
    val projectId: Int? = null,
    val sectionId: Int? = null,
    val content: String? = null,
    val completed: Boolean? = null,
    val labelIds: List<Int>? = null,
    val parent: Int? = null,
    val order: Int? = null,
    val priority: Int? = null,
    val due: Due? = null,
    val url: String? = null,
    val commentCount: Int? = null
)