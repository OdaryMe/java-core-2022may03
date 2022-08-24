package ru.geekbrains.java2.homeworks.hw1;

public abstract class Unit implements RunJumpable{
    private String type;
    private String name;
    private int maxRunDistance;
    private int maxJumpHeight;


    public Unit(String type, String name, int maxRun, int maxJump) {
       // this();
        this.type = type;
        this.name = name;
        this.maxRunDistance = maxRun;
        this.maxJumpHeight = maxJump;
    }

    @Override
    public void jump() {
    }

    public boolean jump(int barrier){
        if(barrier <= maxJumpHeight){
            System.out.printf("%s %s overcame a barrier %d sm high.\n", type, name, barrier);
            return true;
        }else System.out.printf("%s %s could not overcome a barrier %d sm high. That %s's out of the marathon!\n",
                type, name, barrier, type);
        return false;
    }


    @Override
    public void run() {

    }

    public boolean run(int distance){
        if(distance <= maxRunDistance){
            System.out.printf("%s %s ran a distance %d m.\n", type, name, distance);
            return true;
        }else System.out.printf("%s %s could not overcome a distance %d m. That %s's out of the marathon!\n",
                type, name, distance, type);
        return false;
    }

    public boolean overcome(Obstacle obstacle) {
        switch (obstacle.getType()) {
            case RUNTRACK :
              return run(obstacle.overcomeParameter);
            case WALL :
               return jump(obstacle.overcomeParameter);
        }
        return false;
    }



//    public boolean overcome(Obstacle obstacle) {
//        switch (obstacle.getType()){
//            case RUNTRACK :
//                return run(obstacle.getOvercome);
//
//            case WALL :
//                return jump(obstacle.getLength());
//        }
//        return false;
//    }

}
