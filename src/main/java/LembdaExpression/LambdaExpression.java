package LembdaExpression;



 interface HelloInterface  {
     int x = 9;
 void showHello(int z );
}

class HelloInterfaceImplementation implements HelloInterface{
        int x = 10;
        int y = 20;
    public void  showHello(int z) {
        System.out.println("y ==> "+ this.y);
         System.out.println("Hello Word ");
    }
}


public class LambdaExpression {
    public static void main(String[] args) {

     // a variable which  reference to the interface HelloInterface
       HelloInterface   obj;


       // 1 ====>  we create an obj from the class that implemented the interface HelloInterface
      // obj = new HelloInterfaceImplementation();



       //  2 ===>  another way to implement an interface is the on-spot-implementation
//        obj = new HelloInterface(){
//                int x = 10;
//               public  int y = 20;
//            public void  showHello(int z) {
//                System.out.println("y ==> "+ this.y);
//                System.out.println("Hello Word ");
//            }
//        };

        //  3 ===>  another way to implement an interface is the on-spot-implementation by with less syntax
        // it will be like an arrow function

        obj =  z  -> {
            int x = 10;
            int y = 20;

                System.out.println("y ==> "+ y);
                System.out.println("z ==> " + z);
                System.out.println("Hello Word ");

        };






        //// we call the method
        obj.showHello(5);
        System.out.println("x ===> "+ obj.x); // printing the original value obtained from the interface





    }
}
