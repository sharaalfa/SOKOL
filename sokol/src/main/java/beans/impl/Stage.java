package beans.impl;

public class Stage {
    private Stage(){

    }

    private static class StageHolder{
        public static Stage stage = new Stage();
    }

    public static Stage getInstance(){
        return StageHolder.stage;
    }
}
