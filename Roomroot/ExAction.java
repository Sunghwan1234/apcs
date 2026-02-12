package Roomroot;

public abstract class ExAction {
    public Thing executer;
    public Thing target;

    public ExAction() {}
    public ExAction(Thing executer) {
        this.executer=executer;
    }
    public ExAction(Thing executer, Thing target) {
        this.target=target;
    }

    


    public abstract void execute();
    public abstract void execute(Thing target);
    public abstract void execute(Thing target, Thing executer);
}
