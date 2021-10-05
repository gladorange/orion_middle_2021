public class Main {

    public static void main(String[] args) {
        int sum;
        int firstInteger =  (int) (Math.random()*6) + 1 ;
        int secondInteger = (int) (Math.random()*6) + 1 ;

        if(firstInteger > secondInteger){
            System.out.printf("Число %s больше %s \n", firstInteger, secondInteger);
        }else if(firstInteger < secondInteger){
            System.out.printf("Число %s меньше %s \n", firstInteger, secondInteger);
        }

        sum = firstInteger + secondInteger;

        System.out.printf("%s + %s = %s", firstInteger, secondInteger, sum);
    }
}
