import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
public class Q12_Write_Hashmap{
    public static class HashMap<K, V> {
        private class HMNode {
          K key;
          V value;
    
          HMNode(K key, V value) {
            this.key = key;
            this.value = value;
          }
        }
    
        private int size; // n
        private LinkedList<HMNode>[] buckets; // N = buckets.length
    
        public HashMap() {
          initbuckets(4);
          size = 0;
        }
    
        private void initbuckets(int N) {
          buckets = new LinkedList[N];
          for (int bi = 0; bi < buckets.length; bi++) {
            buckets[bi] = new LinkedList<>();
          }
        }
    
        public void put(K key, V value) throws Exception {
            // bi(bucket index) haashfn(key) give as a bucket index where we cam insert or update the value
            // di(data index) getDataWithinBucket(key, bi) it'll give a index where we can update if
            // key is already their or insert if not there
            // now check the bucket[bi] it is contains the key then di != -1 so update its value
            // if it is -1 then create a node in this bi and increament the size by 1
            int bi = hashfn(key);
            int di = getDataWithinBucket(key, bi);
            if(di != -1){
                // node with this key is there so update its value
                HMNode node = buckets[bi].get(di); // in bucket bi, data index di store is node now update val
                node.value = value;
            }
            else{
                // create node with this key val pair
                HMNode node = new HMNode(key, value);
                buckets[bi].add(node); // in bucket bi add one node and increament the size
                size++;
            }
            double lamda = size * 1.0 / buckets.length;
            // assume k is 2 that means in one list aprox 2 nodes can be there
            // lamda is size / length suppose size = 8(total 8 nodes) bucket length = 4
            // lamda is 8 / 4 = 2
            // if we add one node size become 9 so lamda become 2.25
            // so rehash the bucket(means craete a new bucket)
            if(lamda > 2.0){
                rehash();
            }
        }

        public void rehash() throws Exception{
            LinkedList<HMNode>[] oba = buckets;
            initbuckets(oba.length*2);
            size = 0;
            for (int i = 0; i < oba.length; i++) {
                for (HMNode node : oba[i]) {
                    put(node.key, node.value);
                }
            }
        }

        // di is data index initialize it with 0 now create for each loop for HMNode for bucket[bi]
        // if node.key == key that means this key is already there so return its index otherwise 
        // increase di by 1 
        // at end return -1 if no node is having same key that means this is not in this bucket list
        private int getDataWithinBucket(K key, int bi){
            int di = 0;
            for (HMNode node : buckets[bi]) {
                if(node.key.equals(key))
                return di;
                di++;
            }
            return -1;
        }

        private int hashfn(K key){
            // key.hashcode will give a big integer so using abs function and with mod with buckets.len
            // we can get our bucket index using this nucket index we can search the key
            // if key is there then update it's value or if not there then insert the key
            // we absolute hc so that it'll be positive value and in between [0, buckets.length(that is 4 curr)]
            int hc = key.hashCode();
            return Math.abs(hc) % buckets.length;
        }
    
        public V get(K key) throws Exception {
            int bi = hashfn(key);
            int di = getDataWithinBucket(key, bi);
            if(di != -1){
                HMNode node = buckets[bi].get(di);
                return node.value;
            }
            else{
                return null;
            }
        }
    
        public boolean containsKey(K key) {
            int bi = hashfn(key);
            int di = getDataWithinBucket(key, bi);
            if(di != -1){
                return true;
            }
            else{
                return false;
            }
        }
    
        public V remove(K key) throws Exception {
            int bi = hashfn(key);
            int di = getDataWithinBucket(key, bi);
            if(di != -1){
                HMNode node = buckets[bi].remove(di);
                size--;
                return node.value;
            }
            else{
                return null;
            }
        }
    
        public ArrayList<K> keyset() throws Exception {
            ArrayList<K> keys = new ArrayList<>();
            for (int i = 0; i < buckets.length; i++) {
                for (HMNode node : buckets[i]) {
                    keys.add(node.key);
                }
            }
            return keys;
        }
    
        public int size() {
            return size;
        }
    
       public void display() {
          System.out.println("Display Begins");
          for (int bi = 0; bi < buckets.length; bi++) {
            System.out.print("Bucket" + bi + " ");
            for (HMNode node : buckets[bi]) {
              System.out.print( node.key + "@" + node.value + " ");
            }
            System.out.println(".");
          }
          System.out.println("Display Ends");
      }
    }
    
      public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();
    
        String str = br.readLine();
        while (str.equals("quit") == false) {
          if (str.startsWith("put")) {
            String[] parts = str.split(" ");
            String key = parts[1];
            Integer val = Integer.parseInt(parts[2]);
            map.put(key, val);
          } else if (str.startsWith("get")) {
            String[] parts = str.split(" ");
            String key = parts[1];
            System.out.println(map.get(key));
          } else if (str.startsWith("containsKey")) {
            String[] parts = str.split(" ");
            String key = parts[1];
            System.out.println(map.containsKey(key));
          } else if (str.startsWith("remove")) {
            String[] parts = str.split(" ");
            String key = parts[1];
            System.out.println(map.remove(key));
          } else if (str.startsWith("size")) {
            System.out.println(map.size());
          } else if (str.startsWith("keyset")) {
            System.out.println(map.keyset());
          } else if (str.startsWith("display")) {
            map.display();
          }
          str = br.readLine();
        }
      }
}