public class Persona {
    private int id;
    private String name;
    private String lastName;
    private String job;

    public Persona(int id, String name, String lastName, String job) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.job = job;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", job='" + job + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getJob() {
        return job;
    }
}
