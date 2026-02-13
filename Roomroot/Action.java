package Roomroot;

import java.util.ArrayList;

/** Base of all actions. */
public class Action {
    /** ActionType. SUBACTION for everything you can choose, CHOOSE to go back */
    public enum Type {
        MOVE(0), ATTACKGROUP(1), ATTACK(2), DAMAGE(3), HEAL(4), RECHARGE(5), DMGMANA(6), EQUIP(7),
        SUBACTION(-1), BACK(-2), CHOOSE(-2),
        CUSTOM(-100);
        
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

    public String name;
    public String subactionMessage;
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
    /** Configure an Action with a name. */
    public Action(Type type, String name) {
        this.type = type; this.name = name;
    }
    public Action(Type type, String name, Thing target) {
        this.type=type; this.name=name; this.target=target;
    }
    /** ITEM Internal Actions */
    public Action(String name, String description, Type type, int toTarget, int toExecuter) {
        this.type = type;
        this.name = name;
        this.valToTarget = toTarget;
        this.valToExecuter = toExecuter;
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
    }
    public Action(Thing executer, Thing target, Action action, String name) {
        this.type = action.type;
        this.executer = executer;
        this.target = target;

        this.name = name;
        this.valToTarget = action.valToTarget;
        this.valToExecuter = action.valToExecuter;
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

    /** Execute instructions set by the Type. This function should not modify this Action in any way, unless it requires it. */
    public String execute(Player player) {
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
                return "You are now attacking the monsters!";
            case DAMAGE:
                Roomroot.debugLine("Damage Action from "+executer+" to "+target);
                if (target==null) {target = ((Entity)this.executer).getTarget();}
                ((Entity)target).damage(this.valToTarget);
                return this.executer+" dealt "+this.valToTarget+" damage to "+this.target;
            case HEAL:
                if (player instanceof Player) { // TODO: make this Target instead
                    player.hp.inc(this.valToTarget);
                    return "You healed "+this.valToTarget+" health.";
                }
            case RECHARGE:
                if (player instanceof Player) { // TODO: make this target instead
                    player.mp.inc(this.valToTarget);
                    return player+" restored "+this.valToTarget+" mana.";
                }
            // case INVEQUIP:
            //     for (Item i : player.inventory) {
            //         subactions.add(new Action(Type.EQUIP, i));
            //     }
            //     subactions.add(new Action(Type.BACK));
            //     return "Subactions Added.";
            case EQUIP:
                player.equip((Item) this.target);
                return "Equipped "+this.target+"!";
            default:
                return "null action: "+this;
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