package mariav.insurance.model.entity;

import com.google.gson.annotations.SerializedName;

import static mariav.insurance.model.Consts.WORDS_SEPARATE;

public class Profile {

    private int id;
    private String avatar;
    @SerializedName("first_name")
    private String firstName;
    @SerializedName("last_name")
    private String lastName;

    public Profile(int id, String avatar, String firstName, String lastName) {
        this.id = id;
        this.avatar = avatar;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + WORDS_SEPARATE + lastName;
    }
}
