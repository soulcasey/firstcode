import java.util.Scanner;

public class DarkSoulsTester{
    
    public static void main(String[] args){
        
        Scanner reader = new Scanner(System.in);
        String as = "";
        DarkSouls Ashen = new DarkSouls(as);
        System.out.println("[DarkSouls] \nLogin to play");
        System.out.println("Username:");
        String id = reader.next();
        System.out.println("Login Successful!");
        System.out.println("\nPlease create your character.");
        String cl = "";
        while(cl.length()==0) {
            System.out.println("Choose your class:");
            System.out.println("[Class]     [Attack]    [Health]");
            System.out.println("Knight         10         400");
            System.out.println("Assassin       20         200");
            System.out.println("Sorcerer       40         100");
            switch(reader.next()) {
                case "Knight": cl = "Knight"; break;
                case "Assassin": cl = "Assassin"; break;
                case "Sorcerer": cl = "Sorcerer"; break;
                case "knight": cl = "Knight"; break;
                case "assassin": cl = "Assassin"; break;
                case "sorcerer": cl = "Sorcerer"; break;
            }
        }
        int hp = Ashen.ClassHp(cl);
        int mhp = Ashen.ClassHp(cl);
        int dmg = Ashen.ClassDmg(cl);
        String cv = "";
        while(cv.length()==0) {
            System.out.println("Choose your covenant:");
            System.out.println("[Covenant]        [Bonus]");
            System.out.println("Sunlight       Double Health");
            System.out.println("Darkmoon       Double Damage");
            System.out.println("Farron         Double Souls gained");
            switch(reader.next()) {
                case "Sunlight": cv = "Sunlight"; break;
                case "Darkmoon": cv = "Darkmoon"; break;
                case "Farron": cv = "Farron"; break;
                case "sunlight": cv = "Sunlight"; break;
                case "darkmoon": cv = "Darkmoon"; break;
                case "farron": cv = "Farron"; break;
            }
        }
        hp = hp*Ashen.CovBonus(cv,"hp");
        mhp = mhp*Ashen.CovBonus(cv,"hp");
        dmg = dmg*Ashen.CovBonus(cv,"dmg");
        int bsl = 1;
        bsl = bsl*Ashen.CovBonus(cv, "bsl");
        System.out.println("\nWelcome to the world of DarkSouls, " + id + ", the " + cl + " of " + cv + ".");
        System.out.println("Type the number to perform the action.");
        int lv = 1;
        int pt = 3;
        int ar = 1;
        int sl = 0;
        
        while(true){
        System.out.println(Ashen.Stats(id,lv,cl,cv,ar,sl,hp,mhp,dmg,pt));
        System.out.println("Choose your action:");
        System.out.println("1. Battle");
        System.out.println("2. Consume potion");
        System.out.println("3. Purchase potion");
        System.out.println("4. Level up");
        System.out.println("5. Travel");
        System.out.println("6. End game");
        
        switch(reader.nextInt()) {
            case 1:
                String enemy = Ashen.Enemy();
                int enemyhp = Ashen.EnemyStat(enemy,"hp",ar);
                int enemymhp= Ashen.EnemyStat(enemy,"hp",ar);
                int enemydmg = Ashen.EnemyStat(enemy,"dmg",ar);
                System.out.println("\nKill " + enemy + "!");
                
                while(enemyhp > 0 && hp > 0){
                    System.out.println(Ashen.Battle(id, enemy, hp, mhp, dmg, enemyhp, enemymhp, enemydmg));
                    System.out.println("Choose your action:");
                    System.out.println("1. Attack");
                    System.out.println("2. Parry");
                    System.out.println("3. Consume potion(" + pt + " owned)");
                    
                    switch(reader.nextInt()) {
                        case 1:
                            System.out.println(Ashen.Attack(id,enemy,dmg));
                            enemyhp = Ashen.TakeDamage(enemyhp,dmg);
                            System.out.println(Ashen.Attack(enemy,id,enemydmg));
                            hp = Ashen.TakeDamage(hp,enemydmg);
                            break;
                        case 2:
                            final int numbers2 = 2;
                            double r2 = Math.random();
                            int Random2 = (int)(r2 * numbers2);
                            if(Random2 == 0) {
                                System.out.println("Parry successful!\n" + enemy + " took " + dmg + " damage.");
                                enemyhp = enemyhp - dmg;
                            }
                            else if(Random2 == 1) {
                                System.out.println("Parry failed.\n" + id + " took " + enemydmg + " damage.");
                                hp = hp - enemydmg;
                            }
                            break;
                        case 3:
                            if(hp == mhp) {System.out.println("Your health is already full."); break;}
                            if(pt == 0) {System.out.println("You do not have any potion."); break;}
                            if(pt > 0) {
                                if(mhp - hp < 100) {
                                    System.out.println("Healed " + (mhp - hp) + " health");
                                    hp = mhp;
                                }
                                if(mhp - hp >= 100) {
                                    System.out.println("Healed 100 health");
                                    hp = hp + 100;
                                }
                                pt = pt - 1;
                                break;
                            }
                           
                
                        }
                    }
                if(enemyhp <= 0) enemyhp = 0;
                if(hp <= 0) hp = 0;
                System.out.println(Ashen.Battle(id, enemy, hp, mhp, dmg, enemyhp, enemymhp, enemydmg));
                if(enemyhp <= 0 && hp >0) {
                    System.out.println(enemy + " has been defeated!");
                    System.out.println("\nYou gained " + 100*ar*bsl + " Souls.");
                    sl = sl + 100*ar*bsl;
                    System.out.println("Press any key to go back to lobby.");
                    String a = reader.next();
                }
                if(hp <= 0) {
                    System.out.println("YOU DIED.");
                    System.out.println("Would you like to retart the game or exit?");
                    System.out.println("1. Restart");
                    System.out.println("2. Exit");
                    switch(reader.nextInt()) {
                        case 1:
                            System.out.println("Restarting game...\n");
                            main(args);
                        case 2:
                            System.out.println("Farewell...");
                            System.exit(0);
                    }
                }
                break;
            case 2:
                if(hp == mhp) System.out.println("Your health is already full.");
                if(pt == 0) System.out.println("You do not have any potion.");
                if(pt > 0) {
                    if(mhp - hp < 100) {
                        System.out.println("Healed " + (mhp - hp) + " health");
                        hp = mhp;
                    }
                    if(mhp - hp >= 100) {
                        System.out.println("Healed 100 health.");
                        hp = hp + 100;
                    }
                    pt = pt - 1;
                }
                break;
            case 3:
                System.out.println("How many would you like to buy? (500 Souls per potion)" );
                int buy = reader.nextInt();
                String b1 = "Purchase successful."
                + "\nPotions: " + pt + "\t-> " + pt+buy;
                System.out.println(Ashen.Money(sl,buy,500,b1));
                if(Ashen.Money(sl,buy,500,b1).equals(b1)) {
                    sl = sl - (buy * 500);
                    pt = pt + buy;
                }
                break;
            case 4:
                System.out.println("Would you like to level up to lvl " + (lv + 1) + "? (Required Souls: " + 1000*lv + ")");
                System.out.println("1. Level up");
                System.out.println("2. Cancel");
                switch(reader.nextInt()) {
                    case 1:
                        String b2 = "Level up successful." 
                        + "\nlvl " + lv + "\t\t-> lvl " + (lv + 1)
                        + "\nHp: " + hp + "/" + mhp + "\t-> " + "Hp: " + (hp+mhp) + "/" + mhp*2
                        + "\nDmg: " + dmg + "\t\t-> Dmg: " + dmg*2;
                        System.out.println(Ashen.Money(sl,lv,1000,b2));
                        if(Ashen.Money(sl,lv,1000,b2).equals(b2)) {
                            sl = sl - (1000*lv);
                            lv = lv + 1;
                            hp = hp + mhp;
                            mhp = mhp*2;
                            dmg = dmg*2;
                        }
                        break;

                    case 2:
                        System.out.println("Level up canceled.");
                        break;
                    }
                break;
            case 5:
                System.out.println("Are you sure you want to travel to a new area with stronger enemies? (Required Souls: " + 2000*ar + ")");
                System.out.println("1. Proceed");
                System.out.println("2. Cancel");
                switch(reader.nextInt()) {
                    case 1:
                        String b3 = "Travelling to Area " + ar + "...";
                        System.out.println(Ashen.Money(sl, ar, 2000, b3));
                        if(Ashen.Money(sl, ar, 2000, b3).equals(b3))
                        ar = ar + 1;
                        sl = sl - (ar*2000);
                        break;
                    case 2:
                        System.out.println("Travel canceled.");
                        break;
                }
                break;
            case 6:
                System.out.println("Farewell...");
                System.exit(0);
                
                
    }
}
}
}