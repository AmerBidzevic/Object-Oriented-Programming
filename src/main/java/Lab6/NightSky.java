package Lab6;

import java.util.Random;

public class NightSky {
    private double density;
    private int width;
    private int height;
    private Random random;
    private int starsInLastPrint;

    public NightSky(double density){
        this.density = density;
        this.width = 20;
        this.height = 10;
    }


    public NightSky(int width, int height){
        this.width = width;
        this.height = height;
        this.density = 0.1;
        this.random = new Random();
    }

    public NightSky(double density, int width, int height ){
        this.density = density;
        this.width = width;
        this.height = height;
        this.random = new Random();
    }

    public void printLine(){
        int starsInThisLine  = 0;
        for(int i = 0; i < width; i++){
            if(random.nextDouble() < density){
                System.out.print("*");
                starsInLastPrint++;
            }else{
                System.out.print(" ");
            }
        }
        System.out.println();
        starsInLastPrint+= starsInThisLine;

    }

    public void print(){
        starsInLastPrint = 0;
        for(int i = 0; i < this.height; i++){
                printLine();
                System.out.println();

        }
    }

    public int starsInLastPrint (){
        return starsInLastPrint;
    }
    public static void main(String[] args){
//        NightSky nightSky = new NightSky(0.1, 40, 10);
//        nightSky.printLine();

//        NightSky nightSky = new NightSky(8, 4);
//        nightSky.print();

        NightSky nightSky = new NightSky(8, 4);
        nightSky.print();
        System.out.println("Number of stars: " + nightSky.starsInLastPrint());
        System.out.println("");
        nightSky.print();
        System.out.println("Number of stars: " + nightSky.starsInLastPrint());
    }
}

