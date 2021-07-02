public class Person {
    private int id;
    private String name;
    private double temp;
    private int hour;
    private int min;
    private String abroad_visit;
    private String regDate;

    public Person(int id, String name, double temp, int hour, int min, String abroad_visit, String regDate) {
        this.id = id;
        this.name = name;
        this.temp = temp;
        this.hour = hour;
        this.min = min;
        this.abroad_visit = abroad_visit;
        this.regDate = regDate;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public String getAbroad_visit() {
        return abroad_visit;
    }

    public void setAbroad_visit(String abroad_visit) {
        this.abroad_visit = abroad_visit;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    @Override
    public String toString() {
        return this.id + "   " + this.name + "  " + this.temp + "  " + this.hour + "    " + this.min + "\t\t" + this.abroad_visit + "\t\t" + this.regDate;
    }
}
