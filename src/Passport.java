class Passport {
    private int passportNumber;
    private String fullName;
    private String position;
    private boolean isAllowed;

    public Passport(int number, String name, String position, boolean isAllowed) {
        this.passportNumber = number;
        this.fullName = name;
        this.position = position;
        this.isAllowed = isAllowed;
    }

    public int getPassportNumber() {
        return passportNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPosition() {
        return position;
    }

    public boolean isAllowed() {
        return isAllowed;
    }

    public void setAllowed(boolean allowed) {
        isAllowed = allowed;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return fullName + ", " + passportNumber + ", " + position + ", " + isAllowed;
    }
}