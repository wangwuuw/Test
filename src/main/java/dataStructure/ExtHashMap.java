package dataStructure;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 手写hhashMap1.8
 * @param <K>
 * @param <V>
 */
public class ExtHashMap<K,V> {
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    final float loadFactor;
    transient ExtHashMap.Node<K,V>[] table;
    static class Node<K,V> implements Map.Entry<K,V> {
        final int hash;
        final K key;
        V value;
        ExtHashMap.Node<K,V> next;

        Node(int hash, K key, V value, ExtHashMap.Node<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final K getKey()        { return key; }
        public final V getValue()      { return value; }
        public final String toString() { return key + "=" + value; }

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        public final boolean equals(Object o) {
            if (o == this)
                return true;
            if (o instanceof Map.Entry) {
                Map.Entry<?,?> e = (Map.Entry<?,?>)o;
                if (Objects.equals(key, e.getKey()) &&
                        Objects.equals(value, e.getValue()))
                    return true;
            }
            return false;
        }
    }
    public ExtHashMap() {
        this.loadFactor = DEFAULT_LOAD_FACTOR; // all other fields defaulted
        table = new Node[10];
    }

    /**
     * 核心方法
     */
    public V put(K key,V value){
//          ExtHashMap.Node<K,V>[] tab = table;
          int hash = key.hashCode();
          int index =hash%table.length;
          //把对应下标的node对象进行赋值给srcNode
          Node<K,V> srcNode = table[index];
          //判断 是否为null
        if (srcNode == null) {
            //为null说明没有node，直接给该下标数组赋值
            srcNode = new Node<K,V>(hash,key,value,null);//怪不得呢 src重新赋值了
            table[index]=srcNode;
        }else{
            //不为null说明已经有node
            K k;Node<K,V> tempNode;
            //判断key是否相同,如果相同替换value就行
            if (srcNode.hash == hash && ((k=srcNode.key)==key || k.equals(key) )) {
                tempNode= srcNode;
            }else{
                //否则就遍历nextNode
                for (int binCount = 0; ; binCount++) {
                    //判断当前节点是否为null
                    if ((tempNode =  srcNode.next) == null) {
                        srcNode  = new Node(hash,key,value,null);
                        break;
                    }
                    if (tempNode.hash==hash&&(((k=tempNode.key)==key) || k.equals(key))) {
                           break;
                    }
                    srcNode = tempNode;
                }
            }
            if (tempNode != null) {
                V oldValue = tempNode.value; //oldValue和tempNode.value指向同一个老值
                tempNode.value= value;//tempNode.value改变指向新值
                return oldValue;//返回老值
            }
        }

        return null;
    }
    public V get(K v){

        return null;
    }
        public static void main(String[] args) {
            HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
            objectObjectHashMap.put(1,1);



//            ExtHashMap<Object, Object> map = new ExtHashMap<Object,Object>();
//            Object value = map.put("11", "13");
//            System.out.println(value);
//            Object value2 = map.put("11", "12");
//            System.out.println(value2);


        }


}
