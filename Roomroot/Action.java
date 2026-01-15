package Roomroot;

import java.util.ArrayList;

/** Base of all actions. */
public class Action {
    public static final int MOVE=0, ATTACK=1, USE=2, SUBACTION=-1, BACK=-2;

    public int type;
    public Thing executer;
    public Thing target;
    public ArrayList<Monster> monsterGroup;
    public ArrayList<Action> subactions;

    public String name;

    public Action(int type) {
        this.type = type;

        setName();
    }

    /** Item Attack Action */
    public Action(int type, Thing target) {
        this.type = type;
        this.target = target;
    }

    public Action(int type, Thing target, Thing executer, ArrayList<Object> params) {
        this.type = type;
        this.target = target;
        this.executer = executer;
    }
    /** ATTACK a group of monsters */
    public Action(ArrayList<Monster> monsters) {
        //if (Roomroot.status == Roomroot.stat.passive) {
            this.type = Action.SUBACTION;
            this.name = "Attack ("+monsters.size()+" "+monsters.get(0)+")";

            subactions = new ArrayList<Action>();
            for (Monster m : monsters) {
                subactions.add(new Action(m, monsters));
            }

        // } else {
        //     this.type = Action.ATTACK;
        //     this.monsters = monsters;
        //     this.name = "Attack ("+monsters.size()+" "+monsters.get(0)+")";
        // }
    }
    /** ATTACK one Monster within a MonsterGroup */
    public Action(Monster monster, ArrayList<Monster> monsterGroup) {
        this.type = Action.ATTACK;
        this.target = monster;
        this.name = "Attack "+monster+"";
        this.monsterGroup = monsterGroup;
    }
    /** SUBACTIONS */
    public Action(ArrayList<Action> subactions, String name) {
        this.type = Action.SUBACTION;
        this.name = name;
        this.subactions = subactions;
        this.subactions.add(new Action(Action.BACK));
    }
    /** SUBACTION */
    public Action(ArrayList<Action> subactions, String name, boolean canGoBack) {
        this.type = Action.SUBACTION;
        this.subactions = subactions;

        if (canGoBack) {
            this.subactions.add(new Action(Action.BACK));
        }
    }
    /** MOVE */
    public Action(Location loc) {
        this.type = Action.MOVE;
        this.target = loc;

        setName();
    }

    private void setName() {
        switch (this.type) {
            case MOVE:
                this.name = "Move to "+((Location)this.target);
                break;
            case BACK:
                this.name = "Back";
                break;
            case ATTACK: this.name = "Attack";
                break;
            case -100:
                this.name = "Suicide";
                break;
            default:
                this.name = "Unknown Action";
                break;
        }
    }

    public String execute(Entity executer) {
        switch (this.type) {
            case MOVE:
                if (executer instanceof Player) {
                    ((Player) executer).loc = (Location)this.target;
                    return "You moved to "+((Location)this.target)+".";
                }
            case -100:
                if (executer instanceof Player) {
                    ((Player) executer).hp.inc(-134340);
                    return "You have committed suicide.";
                }
            case ATTACK:
                Roomroot.status = Roomroot.stat.combat;
                executer.setTarget((Entity) this.target);
                for (Monster m : this.monsterGroup) {
                    m.setTarget((Player) executer);
                }
                Monster.aggroGroup = this.monsterGroup;
                return "You are now attacking the monsters!";
            default:
                return "null";
        }
    }

    @Override
    public String toString() {
        return this.name;
    }
}