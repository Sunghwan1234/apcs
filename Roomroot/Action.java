package Roomroot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/** Base of all actions. */
@SuppressWarnings("unused")
public class Action {
    /** ActionType. SUBACTION for everything you can choose, CHOOSE to go back */
    public enum Type {
        MOVE(0), ATTACKGROUP(1), ATTACK(2), DAMAGE(2), EQUIP(7), USE(8),
        /** Choose between several actions. */
        SUBACTION(-1), BACK(-2),
        /** Execute but not continue. */
        CHOOSE(-3),
        /* ITEM to be removed */
        CUSTOM(100), ITEM(10);
        
        /** Comparitor. Negative = will not continue */
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
    /** Do not call or get anything from this item. */
    public Item item;

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
    /** Simple Name and Description of an Item */
    public Action(String name, String description) {
        this.type = Type.ITEM;
        this.name = name;
        this.description = description;
    }
    /** ITEM Internal Actions */
    // public Action(String name, String description, Type type, int toTarget, int toExecuter) {
    //     this.type = type;
    //     this.name = name;
    //     this.valToTarget = toTarget;
    //     this.valToExecuter = toExecuter;
    // }
    // public Action(String name, String description, Type type, int toTarget, int toExecuter, boolean useup) {
    //     this.type = type;
    //     this.name = name;
    //     this.valToTarget = toTarget;
    //     this.valToExecuter = toExecuter;
    //     this.consumeItem = useup;
    // }
    
    /** Simple Monster Damage Action. */
    public Action(String name, int damage) {
        this.type = Type.DAMAGE;
        this.name = name;
        this.v("hp" ,-damage);
    }

    /** 
     * Configure an executing action from an executer to a target. Use .setName() to set the name.
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
        this.vars = action.vars;
    }
    // public Action(Thing executer, Thing target, Action action, String name) {
    //     this.type = action.type;
    //     this.executer = executer;
    //     this.target = target;
    //     this.name = name;
    //     this.valToTarget = action.valToTarget;
    //     this.valToExecuter = action.valToExecuter;
    //     this.consumeItem = action.consumeItem;
    // }
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
     * Execute an ITEM Action with an item (to remove).
     * @param executer
     * @param target
     * @param action
     * @param itemIndex
     */
    public Action(Thing executer, Thing target, Action action, Item item) {
        this.type = action.type;
        this.executer=executer;
        this.target=target;

        this.name=action.name;
        this.vars=action.vars;
        this.item = item;
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

    /**
     * Put a value into the vars HashMap.
     * The key automatically targets target.
     * Add 'exec' to target executer.
     * <p>Keys: hp mp consume
     */
    public Action v(String key, Integer value) {
        this.vars.put(key, value);
        Roomroot.debugLine("Put "+key+":"+value+" inside "+this+": "+vars.toString());
        return this;
    }
    /** 
     * Put a key with the value set as 1 into the vars HashMap.
     * The key automatically targets target.
     * Add 'exec' to target executer.
     * <p>Keys: hp mp consume
     */
    public Action v(String key) {
        this.vars.put(key, 1);
        return this;
    }
    public Action setName(String customName) {
        this.name=customName;
        return this;
    }
    public Action setDescription(String customDescription) {
        this.description = customDescription;
        return this;
    }

    /** Execute instructions set by the Type. This function should not modify this Action in any way, unless it requires it. */
    public String execute(Player player) {
        ArrayList<String> output = new ArrayList<>();
        switch (this.type) {
            case SUBACTION:
                return "Your Subactions for "+this+":\n";
            case CHOOSE: return "Standalone Choose Action; please fix!";
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
                if (target==null) {target = getExecuterEntity().getTarget();}
                if (name!=null) {output.add(executer+" used "+name);}
                output.add(executeVars(player));
                return Roomroot.toOneString(output);
            // case HEAL:
            //     //Roomroot.pl("bool "+bool+" item "+itemIndex);
            //     output.add(this.target+" healed "+this.valToTarget+" HP.");
            //     getTargetEntity().changeHP(this.valToTarget);
            //     return Roomroot.toOneString(output);
            // case RECHARGE:
            //     getTargetEntity().changeMP(this.valToTarget);
            //     return getTargetEntity()+" restored "+this.valToTarget+" mana.";
            case EQUIP:
                player.equip((Item) this.target);
                return "Equipped "+this.target+"!";
            case ITEM:
                return executer+" used "+name+"\n"+executeVars(player);
            default:
                return "null actions for "+this;
        }
    }
    // Public methods because it needs to be accessible by (){} outside
    public Entity getTargetEntity() {return ((Entity)this.target);}
    public Entity getExecuterEntity() {return ((Entity)this.executer);}

    /**
     * Execute all vars stored.
     * @param player
     * @return
     */
    public String executeVars(Player player) {
        ArrayList<String> output = new ArrayList<>();
        boolean consume = false;
        Roomroot.debugLine("Executing "+this.vars.toString());
        for (Map.Entry<String, Integer> entry : this.vars.entrySet()) {
            // the String (ex. hp.exec) will be split by the commas. the comma has a special regex.
            String[] keyArray = entry.getKey().split("\\."); Integer value = entry.getValue();
            String key = keyArray[0]; String keyParam = keyArray.length>1?keyArray[1]:"none";
            Entity valueTarget = getTargetEntity();
            if (keyParam.contains("exec")) {valueTarget = getExecuterEntity();}
            String oneOutput = "";
            switch (key) {
                case "hp": valueTarget.changeHP(value); 
                    if (value>0) { oneOutput+=valueTarget+" healed "+value+" HP";
                    } else {
                        oneOutput+=getExecuterEntity()+" dealt "+-value+" DMG to ";
                        oneOutput+=getExecuterEntity()==valueTarget?"self":valueTarget;
                    } break;
                case "mp": valueTarget.changeMP(value); 
                    if (value>0) {oneOutput+=valueTarget+" regenerated "+value+" MP";
                    } else {
                        if (getExecuterEntity()==valueTarget) {
                            oneOutput+=getExecuterEntity()+" consumed "+-value+" Mana";
                        } else {
                            oneOutput+=getExecuterEntity()+" dissipated "+-value+" Mana of ";
                            oneOutput+=getExecuterEntity()==valueTarget?"self":valueTarget;
                        }
                    } break;
                case "consume": consume=true; break;
                default: Roomroot.pl("UNKNOWN KEY: "+keyArray+" v: "+value); break;
            }
            if (!oneOutput.equals("")) {output.add(oneOutput+".");} // Add oneOutput to output
        }
        if (consume && item!=null) {
            output.add("You have used up the "+item+".");
            if (!player.inventory.remove(item)) {Roomroot.pl("ERROR :: item did not remove");}
        } if (consume && item==null) {
            Roomroot.pl("ERROR :: item is null but consume called");
        }
        return Roomroot.toOneString(output);
    }

    @Override
    public String toString() {
        if (Roomroot.debug) {
            return this.name+" ["+type.com+"]";
        }
        return this.name;
    }

    @Override
    public boolean equals(Object obj) {
        Action a = (Action) obj;
        return (
            this.type == a.type &&
            this.name == a.name &&
            this.description == a.description &&
            this.executer == a.executer &&
            this.target == a.target &&
            this.item.equals(a.item) &&
            this.vars.equals(a.vars)
        );
    }
    public boolean varEquals(Action a) {
        return (
            this.type == a.type &&
            this.name == a.name &&
            this.description == a.description &&
            this.item.equals(a.item) &&
            this.vars.equals(a.vars)
        );
    }
    /* public final Type type;
    public Thing executer;
    public Thing target;
    public ArrayList<Monster> monsterGroup;
    public ArrayList<Action> subactions = new ArrayList<>();

    public String name, description;

    public String subactionMessage;
    public int valToTarget, valToExecuter;
    public Item item;
    public boolean consumeItem; */
}