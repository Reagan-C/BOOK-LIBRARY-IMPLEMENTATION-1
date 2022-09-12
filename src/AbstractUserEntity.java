public abstract class AbstractUserEntity {
    private  int id;
    private String name;
    private  String gender;
    private Role role;
    public AbstractUserEntity(String name, int id, String gender, Role role) {
        this.name = name;
        this.id = id;
        this.gender = gender;
        this.role = role;
    }
    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public Role getRole() {
        return role;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", gender='" + gender + '\'' +
                ", role=" + role +
                '}';
    }
}
