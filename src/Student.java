public class Student implements Comparable<Student> {
    private int id;
    private String name;
    private int age;
    private String sex;
    private String address;
    private Double midscore;
    public Student(){};

    public Student(int id, String name, int age, String sex, String address, double midscore) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
        this.midscore = midscore;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getMidscore() {
        return midscore;
    }

    public void setMidscore(Double midscore) {
        this.midscore = midscore;
    }

    @Override
    public String toString() {
        return "id : " + id +
                ", name : '" + name + '\'' +
                ", sex : '" + sex + '\'' +
                ", address : '" + address + '\'' +
                ", midscore : " + midscore;
    }

    @Override
    public int compareTo(Student o) {
        return this.getMidscore().compareTo(o.getMidscore());
    }
}
