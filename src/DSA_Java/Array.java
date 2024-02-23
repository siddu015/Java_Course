package DSA_Java;

public class Array {

        private int[] items;
        private int count;
        public Array(int length){
            items = new int[length];
        }
        public void print(){
            for(int i=0;i<count;i++)
                System.out.println(items[i]);
            // System.out.println(Arrays.toString(items));
        }
        public void insert(int value){
            if(count== items.length){
                int[] newItems = new int[count *2];
                for(int i=0;i<count;i++){
                    newItems[i] = items[i];
                }
                items = newItems;
            }
            items[count++] = value;
        }
        public void indexof(int item){
            int i;
            for(i=0;i<count;i++)
                if(items[i] == item)
                    System.out.println(i);
        }
        public void removeAt(int index){
            if(index<0 || index >= count)
                throw new IllegalArgumentException();
            for(int i = index; i<count-1;i++)
                    items[i] = items[i+1];
            count--;
        }
        public void max(){
            int m=0;
            for(int i=0;i<count;i++){
                if(m<items[i])
                    m = items[i];
            }
            System.out.println(m);
        }
    
        public int value(int index){
            return items[index];
        }
    
        public static void intersect(Array a, Array b){
            for(int i=0;i<a.count;i++)
                for(int j=0;j<b.count;j++)
                    if(a.value(i)==b.value(j))
                        System.out.println(" "+a.value(i)+" ");
    
        }
    
        public void reverse(){
            int[] newItems = new int[count];
            for(int i=0;i<count;i++)
                newItems[i] = items[count-i-1];
            items = newItems;
        }
        public void insertAt(int item,int index){
            //insert at any position
            if (index < 0 || index >= count )
                throw new IllegalArgumentException();
       
            int[] newItems = new int[count*2];
                for(int k=0;k<=count;k++){
                    if(k<index)
                        newItems[k] = items[k];
                    else if(k==index)
                        newItems[k] = item;
                    else
                        newItems[k] = items[k-1];
                }    
                items = newItems;
                count++;
        }
        public static char[] toString(int[] arr) {
            return null;
        }
    
    }
    

