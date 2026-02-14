package Roomroot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/** Base of all actions. */
public class Action {
    /** ActionType. SUBACTION for everything you can choose, CHOOSE to go back */
    public enum Type {
        MOVE(0), ATTACKGROUP(1), ATTACK(2), DAMAGE(2), HEAL(2), RECHARGE(2), DMGMANA(2), EQUIP(7), USE(8),
        SUBACTION(-1), BACK(-2), CHOOSE(-2),
        CUSTOM(-100), ITEM(-10);
        
        /** Comparitor: Which Function */
        public final int com;
        private Type(int com) {
            this.com = com;
        }

        //public toString() ?
    }

    public final Type type;
    public Thing executer;
    public Thing target;
    public ArrayList<Monster> monsterGroup;
    public ArrayList<Action> subactions = new ArrayList<>();

    public String name, description;

    public String subactionMessage;
    public int valToTarget, valToExecuter;
    public int itemIndex=-1;
    public boolean bool;

    /** Vars store many, MANY actions in one. */
    public HashMap<String, Integer> vars = new HashMap<>();

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
    /** Configure an Action with a name. */
    public Action(Type type, String name) {
        this.type = type; this.name = name;
    }
    public Action(Type type, String name, Thing target) {
        this.type=type; this.name=name; this.target=target;
    }
    // Configure ITEM Actions ---------------------------------------------------------------
    public Action(String name, String description) {
        this.type = Type.ITEM;
        this.name = name;
        this.description = description;
    }
    /** ITEM Internal Actions */
    public Action(String name, String description, Type type, int toTarget, int toExecuter) {
        this.type = type;
        this.name = name;
        this.valToTarget = toTarget;
        this.valToExecuter = toExecuter;
    }
    public Action(String name, String description, Type type, int toTarget, int toExecuter, boolean useup) {
        this.type = type;
        this.name = name;
        this.valToTarget = toTarget;
        this.valToExecuter = toExecuter;
        this.bool = useup;
    }
    
    /** Simple Monster Damage Action */
    public Action(String name, int damage) {
        this.type = Type.DAMAGE;
        this.name = name;
        this.valToTarget = damage;
    }

    /** 
     * Executing an action from an executer to a target.
     * @param executer
     * @param target
     * @param action usually ITEM Internal or Simple Monster Damage
     * @apiNote Sets valToTarget, valToExecuter
    */
    public Action(Thing executer, Thing target, Action action) {
        this.type = action.type;
        this.executer = executer;
        this.target = target;

        this.name = action.name;
        this.valToTarget = action.valToTarget;
        this.valToExecuter = action.valToExecuter;
        this.bool = action.bool;
    }
    public Action(Thing executer, Thing target, Action action, String name) {
        this.type = action.type;
        this.executer = executer;
        this.target = target;

        this.name = name;
        this.valToTarget = action.valToTarget;
        this.valToExecuter = action.valToExecuter;
        this.bool = action.bool;
    }
    /** Execute an ITEM Action */
    // public Action(Thing executer, Thing target, Action action, int itemIndex) {
    //     this.type = action.type;
    //     this.executer = executer;
    //     this.target = target;

    //     this.name = action.name;
    //     this.valToTarget = action.valToTarget;
    //     this.valToExecuter = action.valToExecuter;
    //     this.bool = action.bool;
    //     this.itemIndex = itemIndex;
    // }
    /** Execute an Item Action */
    // public Action(Thing executer, Thing target, Action action, int itemIndex, String customName) {
    //     this.type = action.type;
    //     this.executer = executer;
    //     this.target = target;

    //     this.name = customName;
    //     this.valToTarget = action.valToTarget;
    //     this.valToExecuter = action.valToExecuter;
    //     this.bool = action.bool;
    //     this.itemIndex = itemIndex;
    // }
    /**
     * Execute an ITEM Action with an itemIndex.
     * @param executer
     * @param target
     * @param action
     * @param itemIndex
     */
    public Action(Thing executer, Thing target, Action action, int itemIndex) {
        this.type = action.type;
        this.executer=executer;
        this.target=target;

        this.name=action.name;
        this.vars=action.vars;
        this.itemIndex=itemIndex;
    }

    /** 
     * Target one monster and Aggro a monsterGroup
     */
    public Action(Monster monster, ArrayList<Monster> monsterGroup) {
        this.type = Type.ATTACKGROUP;
        
        this.name = "Attack "+monster+"";
        this.target = monster;
        this.monsterGroup = monsterGroup;
    }
    /**
     * Create a new SUBACTION Action with a list of subactions and a name.
     * Used for: MOVE
    */
    public Action(ArrayList<Action> subactions, String name) {
        this.type = Type.SUBACTION;
        this.name = name;
        this.subactions = subactions;
        this.subactions.add(new Action(Type.BACK));
    }
    public Action(ArrayList<Action> subactions, String name, String subactionMessage) {
        this.type = Type.SUBACTION;
        this.name = name;
        this.subactions = subactions;
        this.subactions.add(new Action(Type.BACK));
        this.subactionMessage = subactionMessage;
    }
    /** Create a new SUBACTION Action with a list of subactions and a name, Can also set if you can go back. */
    public Action(ArrayList<Action> subactions, String name, boolean canGoBack) {
        this.type = Type.SUBACTION;
        this.name = name;
        this.subactions = subactions;
        if (canGoBack) {
            this.subactions.add(new Action(Type.BACK));
        }
    }
    public Action(String name, Action... actions) {
        this.type = Type.SUBACTION;
        this.name = name;
        addSubactionsWithBack(actions);
    }



    /** MOVE to a Location */
    public Action(Location loc) {
        this.type = Type.MOVE;
        this.target = loc;
        setupAction(type);
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
            case EQUIP:
                this.name = "Equip "+this.target;
                break;
            case USE:
                this.name = "Use "+this.target;
                break;
            default:
                this.name = "Unknown Action ("+this.type+")";
                break;
        }
    }

    private void addSubactionsWithBack(Action... subactions) {
        for (Action a : subactions) {
            this.subactions.add(a);
        }
        this.subactions.add(new Action(Type.BACK));
    }

    /** Put a value into the vars HashMap */
    public Action v(String key, Integer value) {
        vars.put(key, value);
        return this;
    }
    public Action setName(String customName) {
        this.name=customName;
        return this;
    }

    /** Execute instructions set by the Type. This function should not modify this Action in any way, unless it requires it. */
    public String execute(Player player) {
        ArrayList<String> output = new ArrayList<>();
        switch (this.type) {
            case SUBACTION:
                return "Your Subactions for "+this+":\n";
            case MOVE:
                player.loc = (Location)this.target;
                return "You moved to "+((Location)this.target)+".";
            case ATTACKGROUP:
                Roomroot.status = Roomroot.Status.combat;
                player.setTarget((Entity)this.target);
                player.targets = this.monsterGroup;
                for (Monster m : player.targets) {
                    m.setTarget((Entity) player);
                }
                //Monster.aggroGroup = this.monsterGroup;
                return "You are now attacking "+player.getTarget()+"!";
            case DAMAGE:
                Roomroot.debugLine("Damage Action from "+executer+" to "+target);
                if (target==null) {target = executerEntity().getTarget();}
                Entity targetEntity = (Entity) target;

                output.add(this.executer+" dealt "+this.valToTarget+" damage to "+this.target);
                targetEntity.getHP().dec(this.valToTarget);
                
                if (!targetEntity.isAlive()) {
                    output.add(targetEntity.atDeath());

                    if (this.executer.toString()==player.toString()) {
                        for (Monster m : player.targets) {
                            if (m.isAlive()) {
                                player.setTarget(m);
                                output.add("New target: "+m);
                            }
                        }
                    }
                }
                return Roomroot.toOneString(output);
            case HEAL:
                //Roomroot.pl("bool "+bool+" item "+itemIndex);
                output.add(this.target+" healed "+this.valToTarget+" HP.");
                targetEntity().getHP().inc(this.valToTarget);
                return Roomroot.toOneString(output);
            case RECHARGE:
                targetEntity().getMP().inc(this.valToTarget);
                return targetEntity()+" restored "+this.valToTarget+" mana.";
            case EQUIP:
                player.equip(player.inventory.indexOf(this.target));
                return "Equipped "+this.target+"!";
            case ITEM: // TODO: Test to see if it works
                boolean consume = false;
                for (Map.Entry<String, Integer> entry : vars.entrySet()) {
                    String[] s = entry.getKey().split("."); Integer i = entry.getValue();
                    String value = s[0]; String v1 = s.length>1?s[1]:"none";
                    Entity valTarget = targetEntity();
                    if (v1.contains("exec"))
                    switch (value) {
                        case "hp": valTarget.getHP().c(i); 
                            if (i>0) {
                                output.add(valTarget+" healed "+i+" HP.");
                            } else {
                                output.add(executerEntity()+" dealt "+i+" DMG to "+valTarget);
                            } break;
                        case "mp": valTarget.getMP().c(i); 
                            if (i>0) {
                                output.add(valTarget+" regenerated "+i+" MP.");
                            } else {
                                output.add(executerEntity()+" dissipated "+i+" MANA of "+valTarget);
                            } break;
                        case "consume": consume=true; break;
                        default: Roomroot.pl("UNKNOWN KEY: "+s+" v: "+i); break;
                    }
                }
                if (consume) {
                    output.add("You have used up a "+player.inventory.get(itemIndex));
                    player.inventory.remove(itemIndex);
                }
                return Roomroot.toOneString(output);
            default:
                return "null actions for "+this;
        }
    }
    public Entity targetEntity() {return ((Entity)this.target);}
    public Entity executerEntity() {return ((Entity)this.executer);}

    @Override
    public String toString() {
        if (Roomroot.debug) {
            return this.name+" ["+type.com+"]";
        }
        return this.name;
    }
}