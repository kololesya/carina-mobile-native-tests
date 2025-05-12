package laba.model;

import com.zebrunner.carina.utils.R;

public class UserRepository {

    public static User getStandardUser() {
        return new User(
                R.TESTDATA.getDecrypted("user.standard"),
                R.TESTDATA.getDecrypted("password.valid")
        );
    }

    public static User getLockedUser() {
        return new User(
                R.TESTDATA.getDecrypted("user.locked"),
                R.TESTDATA.getDecrypted("password.valid")
        );
    }

    public static User getProblemUser() {
        return new User(
                R.TESTDATA.getDecrypted("user.problem"),
                R.TESTDATA.getDecrypted("password.valid")
        );
    }

    public static User getEmptyUsername() {
        return new User("", R.TESTDATA.getDecrypted("password.valid"));
    }

    public static User getEmptyPassword() {
        return new User(R.TESTDATA.getDecrypted("user.standard"), "");
    }

    public static User getInvalidUser() {
        return new User(
                R.TESTDATA.getDecrypted("user.invalid"),
                R.TESTDATA.getDecrypted("password.invalid")
        );
    }
}
