package generic;

public class Main {
    public static class info{
        private int rank;
        info(int rank){
            this.rank=rank;
        }
    }
    public static class person{
        public Object info;
        person(Object info){
            this.info= info;
        }
    }
    public static void main(String[] args) {
        person man = new person("남자");
        info e1 = (info)man.info;
        System.out.println(e1.rank);
    }
}
