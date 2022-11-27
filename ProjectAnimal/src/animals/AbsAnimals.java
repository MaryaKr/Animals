package animals;

public abstract class AbsAnimals {
   public String name;
   public int age;
   public int weight;
   public String color;



    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public void say () {
        System.out.println("Я говорю");
    }
    public void go () {
        System.out.println("Я иду");
    }
    public void drink () {
        System.out.println("Я пью");
    }
    public void eat () {
        System.out.println("Я ем");
    }

    public String toString() {
       return String.format("Привет! меня зовут %s, мне %d %s, я вешу - %d кг, мой цвет - %s.", name, age, getYearCorrect(age), weight, color);
    }

    private  String getYearCorrect (int age) {
       if (age %10==0 || age % 10>=5 || age>=10 && age<=19 ){
           return "лет";
       }
       if (age%10==1){
           return "год";
       }
       return "года";
    }
}