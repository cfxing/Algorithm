package com.xnj.hash;

import com.xnj.xnj;

import java.util.HashMap;

/**
 * 设计结构：有三个功能：
 *  1.insert(key)：  将 key 加入到该结构中，做到不重复
 *  2.delete(key): 将原本在结构中的key 移除
 *  3.getRandom()：等概率随机返回结构中的任何一个key
 *
 *  时间复杂度：O（1）
 *
 * @author chen xuanyi
 * @Date 2020/5/10 12:10
 */
public class RandomPool<K> {
    //Integer :  String 加入map 的顺序记录
    HashMap<K, Integer> keyIndexMap;
    HashMap<Integer, K> indexKeyMap;
    int size ;

    public RandomPool() {
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<Integer, String> map2 = new HashMap<>();
        int size = 0;
    }

    public K getRandom(){
        if (size == 0) {
            return null;
        }
        int index = (int) (Math.random()*size);
        return indexKeyMap.get(index);

    }

    public void insert(K k){
        if (!this.keyIndexMap.containsKey(k)){

            keyIndexMap.put(k, size);
            indexKeyMap.put(size, k);
            size++;
        }
    }

    //找到删除的string 的  index，让index上的值为最后一个的值，然后删除最后一个
    //本身无序
    public void delete(K k){
        if (this.keyIndexMap.containsKey(k)) {
            //要删除的 key 的 value
            int deleteIndex = keyIndexMap.get(k);
            int lastIndex = --size;
            K lastKey = indexKeyMap.get(lastIndex);
            keyIndexMap.put(lastKey, deleteIndex);
            indexKeyMap.put(deleteIndex, lastKey);
            keyIndexMap.remove(k);
            indexKeyMap.remove(lastIndex);
        }
    }

    @xnj
    public void delete2(K k){
        if (keyIndexMap.containsKey(k)){
            //得到要删除的 val
            int deletIndex = keyIndexMap.get(k);
            //得到最后一个 val
            int lastIndex = --size;
            //得到最后一个 key
            K lastKey = indexKeyMap.get(lastIndex);

            //将最后一个entry 变为 当前的value
            keyIndexMap.put(lastKey, deletIndex);
            //将当前 val 的 value 设置为 lastKey
            indexKeyMap.put(deletIndex, lastKey);
            //删除k, 因为k 中的value 保存到了 lasKey 中
            keyIndexMap.remove(k);
            //删除最后一个，因为最后一个的value已经保存在了 deletIndex 中
            indexKeyMap.remove(lastIndex);
        }
    }


}
