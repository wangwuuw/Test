package dataStructure;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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
     * ���ķ���
     */
    public V put(K key,V value){
//          ExtHashMap.Node<K,V>[] tab = table;
          int hash = key.hashCode();
          int index =hash%table.length;
          //�Ѷ�Ӧ�±��node������и�ֵ��srcNode
          Node<K,V> srcNode = table[index];
          //�ж� �Ƿ�Ϊnull
        if (srcNode == null) {
            //Ϊnull˵��û��node��ֱ�Ӹ����±����鸳ֵ
            srcNode = new Node<K,V>(hash,key,value,null);
        }else{
            //��Ϊnull˵���Ѿ���node
            K k;Node<K,V> tempNode;
            //�ж�key�Ƿ���ͬ,�����ͬ�滻value����
            if (srcNode.hash == hash && ((k=srcNode.key)==key || k.equals(key) )) {
                tempNode= srcNode;
            }else{
                //����ͱ���nextNode
                for (int binCount = 0; ; binCount++) {
                    //�жϵ�ǰ�ڵ��Ƿ�Ϊnull
                    if ((tempNode =  srcNode.next) == null) {
                        srcNode  = new Node(hash,key,value,null);
                        break;
                    }
                    if (tempNode.hash==hash&&(((k=tempNode.key)==key) || k.equals(key))) {
                           break;
                    }
                    srcNode = tempNode;
                }
                if (tempNode != null) {
                    V oldValue = tempNode.value;
                    tempNode.value= value;
                    return oldValue;
                }


            }
        }
        return null;
    }
        public static void main(String[] args) {
        HashMap<Object, Object> map = new HashMap<>();
//        map.put(1,1);
//        Object o = map.get(1);
//            System.out.println(22%10);

        }


}
