package generics;

import java.util.List;

//utils - utility class have some methods
public class Utils {
    //method simpleDoSomething will accept animal datatype
    public static void simpleDoSomething(Animal animal){

    }
    //method doSomething will accept list of Animal
    public static void doSomething4(List<Animal> animalList){
        for(Animal it:animalList){

        }
    }


    //Here, we didn't know what exactly T is
    //method doSomething will accept list of Animal, list of dogs, list of cats...
    //List <? extends Animal> -> wildcard notation
    public static void doSomething(List<? extends Animal> animalList){
        for(Animal it:animalList){

        }
    }
    //or the above method we can write as...see below(standard method of writing generic)...above methods is fast forward generic method
    //Here, what exactly T is --> when we pass in main function
    //T extends Animal -> Anything of this type Animal + anything who is children of animal ->
    //we can pass list of animal type List<Animal> or list of any type which is children of animal List<T> animalList
    public static <T extends Animal> void doSomething2(List<T> animalList){
        for(T it:animalList){

        }
    }

    //let's return somethng
    public static <T extends Animal> T doSomething5(List<T> animalList){
        return animalList.get(0);
    }

    public static <P> void anyMethod(P x){

    }

    //use case
    public static void printAnimalNames(List<? extends Animal> animalList){
        for(Animal it:animalList){
            //name attribute copied to this children class that is dog and cat.
            System.out.println("Animal name is: " + it.name);
        }
    }
    //to pass list of interfaces using generics
    public static <T extends A> void testIntefaces(List<T> A){
        for(T it:A){

        }
    }
}
