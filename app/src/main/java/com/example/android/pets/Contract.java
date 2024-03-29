package com.example.android.pets;

import android.provider.BaseColumns;

public class Contract {
    public static final class PetEntry  {


        public final static String TABLE_NAME = "pets";


        public final static String COLUMN_ID = "id";


        public final static String COLUMN_PET_NAME ="name";


        public final static String COLUMN_PET_BREED = "breed";


        public final static String COLUMN_PET_GENDER = "gender";


        public final static String COLUMN_PET_WEIGHT = "weight";

        /**
         * Possible values for the gender of the pet.
         */
        public static final int GENDER_UNKNOWN = 0;
        public static final int GENDER_MALE = 1;
        public static final int GENDER_FEMALE = 2;
    }
}
