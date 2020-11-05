package com.xnj.queue;

/**
 * 给进队列的对象一个时间戳，以区别谁先谁后
 * @author chen xuanyi
 * @Date 2020/4/27 13:30
 */
public class PetEnterQueue {
    private Pet pet;
    private  int count;

    public PetEnterQueue(Pet pet, int count) {
        this.pet = pet;
        this.count = count;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
