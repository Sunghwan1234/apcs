package Roomroot;

import java.util.ArrayList;

/** Base of all actions. */
public class Action {
    public static final int MOVE=0, ATTACK=1, USE=2, DAMAGE=3, HEAL=4, HEALMANA=5, DAMAGEMANA=6, SUBACTION=-1, BACK=-2;

    public int type;
    public Thing executer;
    public Thing target;
    public ArrayList<Monster> monsterGroup;
    public ArrayList<Action> subactions;

    public String name;
    public int toTarget, toExecuter;

    public Action(int type) {
        this.type = type;

        setName();
    }

    
    public Action(int type, Thing target) {
        this.type = type;
        this.target = target;
    }
    /** Item Damaging Action */
    public Action(String name, String description, int type, int toTarget, int toExecuter) {
        this.type = type;
        this.name = name;
        this.toTarget = toTarget;
        this.toExecuter = toExecuter;
    }
    /** Item Attack Action */
    public Action(Item item, Thing executer, ArrayList<Monster> monsterGroup) {
        this.type = Action.SUBACTION;
        this.monsterGroup = monsterGroup;
        this.executer = executer;
        this.name = "Use "+item;

        for (Action a : item.actions) {
            this.subactions.add(new Action(a, monsterGroup))
        }
    }
    //TODO: make item actually damage monsters with subaction monster & subaction item actions

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
        if (Roomroot.status == Roomroot.stat.combat) {
            this.type = Action.SUBACTION;
            this.name = "Attack "+monster+""; // TODO: Finish subaction

            subactions = new ArrayList<Action>();
            subactions.add(new Action(monster, monsterGroup));
        } else {
            this.type = Action.ATTACK;
            this.target = monster;
            this.name = "Attack "+monster+"";
            this.monsterGroup = monsterGroup;
        }
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
            case DAMAGE:
                if (executer instanceof Player) {
                    ((Monster)target).hp.dec(this.toTarget);
                    return "dealt "+this.toTarget+" damage to "+this.target;
                }
            case HEAL:
                if (executer instanceof Player) {
                    ((Player) executer).hp.inc(this.toTarget);
                    return "You healed "+this.toTarget+" health.";
                }
            case HEALMANA:
                if (executer instanceof Player) {
                    ((Player) executer).mp.inc(this.toTarget);
                    return "You restored "+this.toTarget+" mana.";
                }
            default:
                return "null";
        }
    }

    @Override
    public String toString() {
        return this.name;
    }
}