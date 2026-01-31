package Roomroot;

import java.util.ArrayList;

/** Base of all actions. */
public class Action {
    /** ActionType */
    public enum Type {
        MOVE(0), ATTACKGROUP(1), ATTACK(2), DAMAGE(3), HEAL(4), RECHARGE(5), DMGMANA(6), EQUIP(7),
        SUBACTION(-1), BACK(-2), INV(-3),
        CHOOSE(-10), INVEQUIP(-10),
        INSTAKILL(-100);
        
        /** Comparitor: Which Function */
        public final int com;
        private Type(int com) {
            this.com = com;
        }

        //public toString() ?
    }

    public Type type;
    public Thing executer;
    public Thing target;
    public ArrayList<Monster> monsterGroup;
    public ArrayList<Action> subactions = new ArrayList<>();

    public String name;
    public int valToTarget, valToExecuter;

    public Action(Type type) {
        this.type = type;
        this.setupAction(type);
    }
    /** Configure an Action with a target, sometimes with for CHOOSE with Item */
    public Action(Type type, Thing target) {
        this.type = type;
        this.target = target;
        setupAction(type);
    }
    public Action(Type type, String name) {
        this.type = type;
        setupAction(type);
        this.name = name;
    }
    /** Indivisual Actions in an Item */
    public Action(String name, String description, Type type, int toTarget, int toExecuter) {
        this.type = type;
        this.name = name;
        this.valToTarget = toTarget;
        this.valToExecuter = toExecuter;
    }
    /** With an Item, Attack a monsterGroup */
    // public Action(Item item, Thing executer, ArrayList<Monster> monsterGroup) {
    //     this.type = Type.SUBACTION;

    //     if (item.actions.size() == 1) {
    //         this.name = "Use "+item+" ("+item.actions.get(0)+")";

    //         for (Monster m : monsterGroup) {
    //         this.subactions.add(new Action(item.actions.get(0), m, monsterGroup));
    //     }
    //     } else {
    //         this.name = "Use "+item;

    //         for (Action a : item.actions) {
    //             this.subactions.add(new Action(a, monsterGroup));   
    //         }
    //     }
    // }
    //TODO: make item actually damage monsters with subaction monster & subaction item actions
    /** With an Item Action, Target a monster in a monsterGroup */
    public Action(Action action, ArrayList<Monster> monsterGroup) {
        this.type = Type.SUBACTION;
        this.name = "Use  "+action.name;
        for (Monster m : monsterGroup) {
            this.subactions.add(new Action(action, m, monsterGroup));
        }
    }
    /** With an Item Action and a monster in a monsterGroup, Use the Item Action. */
    public Action(Action action, Monster monster, ArrayList<Monster> monsterGroup) {
        this.type = Type.ATTACK;
        this.name = "Use "+action.name+" on "+monster;
        this.valToTarget = action.valToTarget;
        this.valToExecuter = action.valToExecuter;
        this.monsterGroup = monsterGroup;
    }

    public Action(Type type, Thing target, Thing executer, ArrayList<Object> params) {
        this.type = type;
        this.target = target;
        this.executer = executer;
    }
    /** ATTACK a group of monsters DEPRICATED. */
    // public Action(ArrayList<Monster> monsters) {
    //     //if (Roomroot.status == Roomroot.stat.passive) {
    //         this.type = Action.SUBACTION;
    //         this.name = "Attack ("+monsters.size()+" "+monsters.get(0)+")";

    //         subactions = new ArrayList<Action>();
    //         for (Monster m : monsters) {
    //             subactions.add(new Action(m, monsters));
    //         }

    //     // } else {
    //     //     this.type = Action.ATTACK;
    //     //     this.monsters = monsters;
    //     //     this.name = "Attack ("+monsters.size()+" "+monsters.get(0)+")";
    //     // }
    // }

    // TODO: Finish this
    /** ATTACK one Monster within a MonsterGroup */
    public Action(Monster monster, ArrayList<Monster> monsterGroup) {
        if (Roomroot.status == Roomroot.stat.passive) {
            this.type = Type.ATTACKGROUP; 
        } else {
            this.type = Type.ATTACK;
        }
        this.name = "Attack "+monster+"";
        this.target = monster;
        this.monsterGroup = monsterGroup;
    }
    /**Create a new SUBACTION Action with a list of subactions and a name.
     * Used for: MOVE
    */
    public Action(ArrayList<Action> subactions, String name) {
        this.type = Type.SUBACTION;
        this.name = name;
        this.subactions = subactions;
        this.subactions.add(new Action(Type.BACK));
    }
    /** Create a new SUBACTION Action with a list of subactions and a name, Can also set if you can go back. */
    public Action(ArrayList<Action> subactions, String name, boolean canGoBack) {
        this.type = Type.SUBACTION;
        this.subactions = subactions;

        if (canGoBack) {
            this.subactions.add(new Action(Type.BACK));
        }
    }
    /** MOVE to a Location */
    public Action(Location loc) {
        this.type = Type.MOVE;
        this.target = loc;
        setupAction(type);
    }

    public static Action attackGroup(ArrayList<Monster> monsterGroup) {
        ArrayList<Action> subactions = new ArrayList<>();
        for (Monster m : monsterGroup) {
            if (m.isAlive()) {
                subactions.add(new Action(m, monsterGroup));
            }
        }
        return new Action(subactions, "Attack ("+monsterGroup.size()+" "+monsterGroup.get(0)+")");
    }

    /** Setup an Action's names & subactions using this one function. Remember to still set this.type */
    private void setupAction(Type type) {
        switch (type) {
            case MOVE:
                this.name = "Move to "+((Location)this.target);
                break;
            case BACK:
                this.name = "Back";
                break;
            case ATTACKGROUP: this.name = "Attack";
                break;
            case INV:
                this.name = "View Inventory";
                addSubactionsWithBack(new Action(Type.INVEQUIP));
                //this.subactions.add(new Action(Action.HEAL, "Quick Heal"));
                break;
            case INVEQUIP:
                this.name = "Equip Weapon";
                // The subactions for this action is inside the func execute()
                break;
            case EQUIP:
                this.name = "Equip "+this.target;
                break;
            case INSTAKILL:
                this.name = "Suicide";
                break;
            default:
                this.name = "Unknown Action";
                break;
        }
    }

    public void addSubactionsWithBack(Action... subactions) {
        for (Action a : subactions) {
            this.subactions.add(a);
        }
        this.subactions.add(new Action(Type.BACK));
    }

    public String execute(Entity executer) {
        Player player = (Player) executer;
        
        switch (this.type) {
            case MOVE:
                player.loc = (Location)this.target;
                return "You moved to "+((Location)this.target)+".";
                
            case INSTAKILL:
                player.hp.inc(-134340);
                return "You have committed suicide.";
            case ATTACKGROUP:
                Roomroot.status = Roomroot.stat.combat;
                executer.setTarget((Entity) this.target);
                for (Monster m : this.monsterGroup) {
                    m.setTarget((Entity) executer);
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
                    player.hp.inc(this.valToTarget);
                    return "You healed "+this.valToTarget+" health.";
                }
            case RECHARGE:
                if (executer instanceof Player) {
                    player.mp.inc(this.valToTarget);
                    return executer+" restored "+this.valToTarget+" mana.";
                }
            case INV:
                Roomroot.pl("---- Your Inventory ----");
                for (int i = 0; i < player.inventory.size(); i++) {
                    Item item = player.inventory.get(i);
                    String line = "("+(i+1)+")\t "+item;
                    if (item.description!=null) {
                        line+=" : "+item.description;
                    }
                    Roomroot.p(line);
                }
                Roomroot.pl("\n------------------------");
                return "Subaction Finished.";
            case INVEQUIP:
                for (Item i : player.inventory) {
                    subactions.add(new Action(Type.EQUIP, i));
                }
                subactions.add(new Action(Type.BACK));
                return "Subactions Added.";
            case EQUIP:
                player.equip((Item) this.target);
                return "Equipped "+this.target+"!";
            default:
                return "null";
        }
    }

    @Override
    public String toString() {
        if (Roomroot.debug) {
            return this.name+" [AT."+type+"]";
        }
        return this.name;
    }
}