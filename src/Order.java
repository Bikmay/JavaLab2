import java.lang.reflect.Array;

public class Order {

    //todo пересмотри свою политику именования в этом и других классах. Dish можешь не трогать, там нормально)
    private int size;
    private boolean checkOpportunity = true;
    private Dish[] massOfFood;
    private int index = 0;

    //todo константы и конструкторы по аналогии с Dish
    Order() {
        massOfFood = new Dish[16];
    }

    Order(int numberOfElements) {
        massOfFood = new Dish[numberOfElements];
    }

    Order(Dish[] massOfFood) {

    }

    private static double[] quickSort(double[] mass, int b, int e) {
        int l = b, r = e;
        double piv = mass[(b + e) / 2];
        do {
            while (mass[l] < piv) l++;
            while (mass[r] > piv) r--;
            if (l <= r) mass = swap(mass, l, r);
        } while (l <= r);
        if (b < r) quickSort(mass, b, r);
        if (e > l) quickSort(mass, l, e);
        return mass;
    }  //Быстрая сортировака


    private static double[] swap(double[] mass, int firstIndex, int secondIndex) {
        double copyFirstValue;
        copyFirstValue = mass[firstIndex];
        mass[firstIndex] = mass[secondIndex];
        mass[secondIndex] = copyFirstValue;
        return mass;
    }

    //todo именование дерьмо
    //do
    public int deleteDishs(String[] deleteDishs) {
        int count = 0;
        int[] indexMass= new int[deleteDishs.length];
        for (int i = 0; i <deleteDishs.length ; i++) {


            for (int j = 0; j < massOfFood.length; j++) {
                if (deleteDishs[i].equals(massOfFood[j].getName())) {
                    massOfFood[j] = null;
                    indexMass[count]=j;
                    count++;
                }
            }
        }

        for (int i = 0; i <count ; i++) {
            massOfFood[indexMass[i]]=massOfFood[massOfFood.length-1];
            massOfFood[massOfFood.length-1]=null;

        }
    }



    //todo именование дерьмо
    //todo но метод оставляет за собой дырку в массиве, это нехорошо)
    //do
    public boolean deleteOneDish(String deleteDish) {
        for (int i = 0; i < massOfFood.length; i++) {
            if (deleteDish == massOfFood[i].getName()) {
                massOfFood[i] = null;
                System.arraycopy(massOfFood,i,massOfFood,i+1,massOfFood.length-i);
                return true;
            }
        }
        return false;
    }

    //todo именование дерьмо
    //todo именование переменных тоже дерьмо
    //do
    public Dish[] sotringDishsAtCosts() {

        Dish[] dishMass = returnDishs();//Входящий
        double[] w_mass = new double[dishMass.length];//Массив цен
        Dish[] ResMass = new Dish[dishMass.length];//Результирующий массив

        //todo зачем ты это делаешь??
        // копирую цены,чтобы потом по ним сортировать

        for (int i = 0; i < dishMass.length; i++) {
            w_mass[i] = dishMass[i].getCost();
        }

        w_mass = quickSort(w_mass, 0, w_mass.length - 1);

        //todo и здесь... ??
        //Вписываю в результирующий массив
        for (int i = w_mass.length; i >-1; i--) {
            for (int j = 0; j < ResMass.length; j++) {
                if (dishMass[j].getCost() == w_mass[i]) {
                    ResMass[i] = dishMass[j];
                    dishMass[j] = null;
                }
            }
        }
        //todo тебе достаточно использовать просто метод быстрой сортировки,
        //todo зачем ты занимаешься созданием бесполезных массиввов?
        //Сортировка идёт по цене
        return ResMass;
    }


    //todo именование дерьмо
    //todo не нужно отлавливать на данном этапе исключения
    //todo используешь приватный сайз для добавления. Если он меньше длины массива, то просто добавляешь
    //todo если меньше, то увеличиваешь массив вдвое, копируешь и добавляешь
    //do
    public boolean addToOrder(Dish dish,int index) {

        if(massOfFood.length<=index)
        {
            massOfFood[index]=dish;
            return true
        }
        else
        {
            Dish[] newMass= new Dish[massOfFood.length*2];
            System.arraycopy(massOfFood,0,newMass,0,massOfFood.length+1);
            return true;
        }
        return false;

    }

    //todo именование дерьмо
    //todo вернул бы копию массива от 0 до size
    //do
    public Dish[] getMassOfFood() {
        Dish[] copyMass= new Dish[massOfFood.length];
        System.arraycopy(massOfFood,0,copyMass,0,massOfFood.length);
        return copyMass;
    }


    //todo именование дерьмо
    //do
    public int getCountDish(String nameOfDish) {
        int count = 0;
        for (int i = 0; i < massOfFood.length; i++) {
            if (nameOfDish.equals(massOfFood[i].getName())) {
              count++;
            }
        }
        return count;
    }

    //todo именование дерьмо
    public double returnCostOfOrder() {
        double sum = 0;
        for (int i = 0; i < MassOfFood.length; i++) {
            sum += MassOfFood[i].getCost();
        }
        return sum;
    }

    //todo именование дерьмо
    //todo что блять здесь происходит >_<
    public String[] getMassOfDish() {
        int niga = MassOfFood.length;
        int R_a = 0;
        for (int i = 0; i < MassOfFood.length; i++) {
            for (int j = 0; j < MassOfFood.length; j++) {
                if (MassOfFood[i].getName() == MassOfFood[j].getName()) {
                    if (R_a > 0) {
                        niga -= 1;
                    }
                    R_a++;
                }
            }
        }
        //todo неплохим выходом из сиутации будет следующий подход
        //todo создаешь стринговый массив размера size
        //todo при совпадении имени добавляешь в массив имя блюда
        //todo тримишь массив и возвращаешь его
        String[] ReturNames = new String[niga];
        boolean Checker = true;
        int k = 0;
        for (int i = 0; i < MassOfFood.length; i++) {
            for (int j = 0; j < ReturNames.length; j++) {
                if (MassOfFood[i].getName() == MassOfFood[j].getName()) {
                    Checker = false;
                }
            }
            if (Checker == true) { //todo сравнивать логические переменные на булевские литералы? ВАТ?!
                ReturNames[k] = MassOfFood[i].getName();
                k++;
            }
        }
        return ReturNames;
    }

    //todo А ты уверен, что реализовал здесь все методы по заданию?
}
