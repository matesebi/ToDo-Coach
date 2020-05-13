package hu.aut.bme.matesebi.todocoach.model

data class Project(
    val id: Long? = null,
    val name: String? = null,
    val color: Int? = null,
    val parent: Int? = null,
    val order: Int? = null,
    val commentCount: String? = null,
    val shared: Boolean? = null,
    val inboxProject: Boolean? = null,
    val teamInbox: Boolean? = null
)