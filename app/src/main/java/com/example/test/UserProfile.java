package com.example.test;

import android.provider.BaseColumns;

public final class UserProfile {

    private UserProfile() {}


    public static class Users implements BaseColumns {
        public static final String UserInfo  = "UserInfo";
        public static final String userName  = "userName";
        public static final String dateOfBirth = "dateOfBirth";
        public static final String COLUMN_3 = "password";
        public static final String Gender  = "gender";
    }
}

