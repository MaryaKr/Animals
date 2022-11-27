package animals.birds;

import animals.AbsAnimals;

public class Duck extends AbsAnimals implements IFlying{
    public void say() {
        System.out.println("Кря ");
    }
    public void fly (){
        System.out.println("Я лечу");
    }
}
