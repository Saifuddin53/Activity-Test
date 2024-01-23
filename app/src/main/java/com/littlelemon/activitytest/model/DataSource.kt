package com.littlelemon.activitytest.model

class DataSource() {
    fun loadAffirmations(): List<Affirmation> {
        return listOf<Affirmation> (
            Affirmation("First", 1),
            Affirmation("Second", 2),
            Affirmation("Third", 3),
            Affirmation("Fourth", 4),
            Affirmation("Fifth", 5),
            Affirmation("Sixth", 6),
        )
    }
}