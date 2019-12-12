package app.entity;

public class Employee {
//    @JacksonXmlProperty(localName = "name")
    private String name;
//    @JacksonXmlProperty(localName = "surname")
    private String surname;
//    @JacksonXmlProperty(localName = "dob")
    private String dob;
//    @JacksonXmlProperty(localName = "age")
    private int age;
//    @JacksonXmlProperty(localName = "category")
    private String category;

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCategory() {
        return category;
    }

    public String getDob() {
        return dob;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "EMPLOYEE  {name: " + name + "  surname: " + surname + "  age: " + age + "  category: " + category + "  dob: "+ dob + "}";
    }
}

