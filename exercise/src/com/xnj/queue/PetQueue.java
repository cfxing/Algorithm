package com.xnj.queue;

import java.util.List;
import com.xnj.queue.*;

/**
 * @author chen xuanyi
 * @Date 2020/4/27 13:31
 */
public class PetQueue {
    private List<PetEnterQueue> cat;
    private List<PetEnterQueue> dog;
    private static int count;//用来判断谁先谁后

    public void add(Pet pet){
        if (pet.getType().equals("dog")){
            dog.add(new PetEnterQueue(new Dog(), ++count));
        }else if (pet.getType().equals("cat")){
            cat.add(new PetEnterQueue(new Cat(), ++count));
        }
    }

    public Dog dogPoll(){
        if (dog == null || dog.size() == 0){
            System.out.println("没有dog");
        }else {
            return (Dog) dog.get(0).getPet();
        }
        return null;
    }

    public Cat catPoll(){
        if (cat == null || cat.size() == 0){
            System.out.println("没有cat");
        }else{
            return (Cat)cat.get(0).getPet();
        }
        return null;
    }
    public Pet pollAll(){
        if (dog != null && dog.size() != 0 && cat != null && cat.size() != 0){
            if (dog.get(0).getCount() < dog.get(0).getCount()){
                return dog.get(0).getPet();
            }else {
                return cat.get(0).getPet();
            }
        }else if (dog != null && dog.size() != 0){
            return dog.get(0).getPet();
        }else if (cat != null && cat.size() != 0){
            return cat.get(0).getPet();
        }else {
            System.out.println("没有元素");
        }
        return null;
    }

}
