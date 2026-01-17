package Roomroot;

import java.util.ArrayList;

/** Base of all actions. */
public class Action {
    public static final int MOVE=0, ATTACK=1, USE=2, DAMAGE=3, HEAL=4, HEALMANA=5, DAMAGEMANA=6, SUBACTION=-1, BACK=-2, INV=-3;

    public int type;
    public Thing executer;
    public Thing target;
    public ArrayList<Monster> monsterGroup;
    public ArrayList<Action> subactions;

    public String name;
    public int valToTarget, valToExecuter;

    public Action(int type) {
        this.type = type;

        setName();
    }

    
    public Action(int type, Thing target) {
        this.type = type;
        this.target = target;
    }
    /** Indivisual Actions in an Item */
    public Action(String name, String description, int type, int toTarget, int toExecuter) {
        this.type = type;
        this.name = name;
        this.valToTarget = toTarget;
        this.valToExecuter = toExecuter;
    }
    /** With an Item, Attack a monsterGroup */
    public Action(Item item, Thing executer, ArrayList<Monster> monsterGroup) {
        this.type = Action.SUBACTION;

        if (item.actions.size() == 1) {
            this.name = "Use "+item+" ("+item.actions.get(0)+")";

            for (Monster m : monsterGroup) {
            this.subactions.add(new Action(item.actions.get(0), m, monsterGroup));
        }
        } else {
            this.name = "Use "+item;

            for (Action a : item.actions) {
                this.subactions.add(new Action(a, monsterGroup));   
            }
        }

        
    }
    //TODO: make item actually damage monsters with subaction monster & subaction item actions
    /** With an Item Action, Target a monster in a monsterGroup */
    public Action(Action action, ArrayList<Monster> monsterGroup) {
        this.type = Action.SUBACTION;
        this.name = "Use  "+action.name;
        for (Monster m : monsterGroup) {
            this.subactions.add(new Action(action, m, monsterGroup));
        }
    }
    /** With an Item Action and a monster in a monsterGroup, Use the Item Action. */
    public Action(Action action, Monster monster, ArrayList<Monster> monsterGroup) {
        this.type = Action.USE;
        this.name = "Use "+action.name+" on "+monster;
        this.valToTarget = action.valToTarget;
        this.valToExecuter = action.valToExecuter;
        this.monsterGroup = monsterGroup;
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
            case INV:
                this.name = "View Inventory";
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
                    ((Monster)target).hp.dec(this.valToTarget);
                    return "dealt "+this.valToTarget+" damage to "+this.target;
                }
            case HEAL:
                if (executer instanceof Player) {
                    ((Player) executer).hp.inc(this.valToTarget);
                    return "You healed "+this.valToTarget+" health.";
                }
            case HEALMANA:
                if (executer instanceof Player) {
                    ((Player) executer).mp.inc(this.valToTarget);
                    return "You restored "+this.valToTarget+" mana.";
                }
            case INV:
                Roomroot.pl("---- Your Inventory ----");
                for (int i = 0; i < ((Player) executer).inventory.size(); i++) { //TODO: finish inventory view with subactions for each item
                    Item item = ((Player) executer).inventory.get(i);
                    Roomroot.pl((i+1)+". "+item);
                }
                return "Subaction Finished.";
            default:
                return "null";
        }
    }

    @Override
    public String toString() {
        return this.name;
    }
}