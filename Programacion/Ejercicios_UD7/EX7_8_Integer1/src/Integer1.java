public class Integer1 {
    private int value;
    private String s;
    public Integer1(int value){
        this.value = value;
    }

    public Integer1(String s){
        this.s = s;
    }

    public byte ByteValue(){
        return Byte.parseByte(s);
    }
    public static int  compare(int x, int y){
        if(x > y){
            return 1;
        }else if(x < y){
            return -1;
        }else{
            return 0;
        }
    }

    public int compareTo(Integer1 OtroInteger){
        if(this.value > OtroInteger.value){
            return 1;
        }else if(this.value < OtroInteger.value){
            return -1;
        }else{
            return 0;
        }
    }

    public double doubleValue(){
        return Double.parseDouble(s);
    }

    public boolean equals(Object obj){
        if(obj instanceof Integer1){
            Integer1 otro = (Integer1) obj;
            return this.value == otro.value;
        }else{
            return false;
        }
    }

    public float floatValue(){
        return Float.parseFloat(s);
    }

    public int intValue(){
        return Integer.parseInt(s);
    }

    public long longValue(){
        return Long.parseLong(s);
    }

    public static int max(int x, int y){
        if(x > y){
            return x;
        }else {
            return y;
        }
    }

    public static int min(int x, int y){
        if(x < y){
            return x;
        }else {
            return y;
        }
    }

    public static int parseInt(String s){
        return Integer.parseInt(s);
    }

    public short shortValue(){
        return Short.parseShort(s);
    }

    public static int sum(int x, int y){
        return x + y;
    }

    public String toString(){
        return String.valueOf(value);
    }

    public static String toString(int i){
        return String.valueOf(i);
    }

    public static Integer1 valueOf(int i){
        return new Integer1(i);
    }

    public static Integer1 valueOf(String s){
        return new Integer1(s);
    }


}
