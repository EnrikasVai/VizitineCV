package com.example.vizitinecv.data

import com.example.vizitinecv.R
import com.example.vizitinecv.model.Affirmation

class Datasource() {
    fun loadAffirmations(): List<Affirmation> {
        return listOf<Affirmation>(
            Affirmation(R.string.affirmation1, R.drawable.logo1, R.string.affirmation1_1),
            Affirmation(R.string.affirmation2, R.drawable.logo2,R.string.affirmation2_2),
            Affirmation(R.string.affirmation3, R.drawable.logo3,R.string.affirmation3_3),
            Affirmation(R.string.affirmation4, R.drawable.logo4,R.string.affirmation4_4)
        )
    }
}