package assignment5;

public class Main {


    public static void main(String[] args){
        Long startTime = System.currentTimeMillis();


        double Maxim=-10000,minimum=10000;

        for(int x=-999;x<1000;x++){
            for(int y=-999;y<1000;y++){


                double temp =  ((Math.sqrt(x^2+y^2)))/(x*Math.sin(x+y)+y*Math.cos(x+y));
                if(temp > Maxim)
                    Maxim = temp;
                if(temp<minimum)
                    minimum = temp;


            }
        }
        System.out.println("minimum is : "+minimum+
                           "\nMaxim   is : "+Maxim);

        System.out.println("Runtime is : "+(System.currentTimeMillis()-startTime)+" ms");

    }
}
