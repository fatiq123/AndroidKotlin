package com.example.journalapp

class JournalUser {

    var username: String? = null
    var userId: String? = null

    companion object {
        var instance: JournalUser? = null
            get() {
                if (field == null) {
                    // create a new instance from journal user
                    field = JournalUser()

                }
                return field
            }
            private set
    }
}