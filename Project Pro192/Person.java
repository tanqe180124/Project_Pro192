public abstract class Person {
    private String fullName;
    private String gender;
    private int birthDay;
    private int birthMonth;
    private int birthYear;
    private String email;
    private String phoneNumber;
    private String address;

    public Person(String fullName, String gender, int birthDay, int birthMonth, int birthYear, String email, String phoneNumber, String address) {
        this.fullName = fullName;
        this.gender = gender;
        this.birthDay = birthDay;
        this.birthMonth = birthMonth;
        this.birthYear = birthYear;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    @Override
    public String toString() {
        return " {" +
                "fullName: '" + fullName + '\'' +
                ", gender: '" + gender + '\'' +
                ", birthDay: " + birthDay +
                ", birthMonth: " + birthMonth +
                ", birthYear: " + birthYear +
                ", email: '" + email + '\'' +
                ", phoneNumber: '" + phoneNumber + '\'' +
                ", address: '" + address + '\'';
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isValidFullName(String fullName) {
        for (int i = 0; i < fullName.length(); i++) {
            char currentChar = fullName.charAt(i);
            if (!Character.isLetter(currentChar) && !Character.isWhitespace(currentChar)) {
                return false;
            }
        }
        return true;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isValidGender(String gender) {
        for (int i = 0; i < gender.length(); i++) {
            char currentChar = gender.charAt(i);
            if (!Character.isLetter(currentChar)) {
                return false;
            }
        }
        return true;
    }

    public int getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(int birthDay) {
        this.birthDay = birthDay;
    }

    public boolean isValidBirthDay(int birthDay) {
        if (birthDay > 31 || birthDay < 1) {
            return false;
        }
        return true;
    }

    public int getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(int birthMonth) {
        this.birthMonth = birthMonth;
    }

    public boolean isValidBirthMonth(int birthMonth) {
        if (birthMonth < 1 || birthMonth > 12) {
            return false;
        }
        return true;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public boolean isValidBirthYear (int birthYear) {
        if (birthYear < 0) {
            return false;
        }
        return true;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isValidEmail (String email) {
        if (!email.contains("@") || !email.contains(".") || email.contains(" ")) {
            return false;
        }
        return true;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isValidPhoneNumber (String phoneNumber) {
        for (int i = 0; i < phoneNumber.length(); i++) {
            char currentChar = phoneNumber.charAt(i);
            if (!Character.isDigit(currentChar)) {
                return false;
            }
        }
        if (phoneNumber.length() != 10 && phoneNumber.length() != 11) {
            return false;
        }
        return true;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
