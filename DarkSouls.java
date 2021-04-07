public class DarkSouls{
    
    private String result;
    
    public DarkSouls(String rs)
    {
        result = rs;
    }
    
    public String toString()
    {
        return result;
    }
    
    public DarkSouls Stats(String a, int b, String c, String d, int e, int f, int g, int h, int i, int j)
    {
        String s = 
        "\n[Current Stat]\n" + a + " lvl " + b + "\n" 
        + c + " of " + d
        + "\nLocation: Area " + e
        + "\nSouls: " + f
        + "\nHealth: " + g + "/" + h
        + "\nDamage: " + i
        + "\nNumber of Potions: " + j + "\n";
        return new DarkSouls(s);
    }
    
    public int ClassHp(String a)
    {
        int hp = 0;
        if(a.equals("Knight"))  hp += 400;
        if(a.equals("Assassin")) hp += 200; 
        if(a.equals("Sorcerer")) hp += 100;
        return hp;
    }
    
    public int ClassDmg(String a)
    {
        int dmg = 0;
        if(a.equals("Knight"))  dmg += 10;
        if(a.equals("Assassin")) dmg += 20; 
        if(a.equals("Sorcerer")) dmg += 400;
        return dmg;
    }
    
    public String Money(int a, int b, int c, String d)
    {
        String m = "";
        if(a < b * c) m = "You do not have enough Souls.";
        else if (a >= b * c) m = d;
        return m;
    }
    
    public DarkSouls Battle(String a, String b, int c, int d, int e, int f, int g, int h)
    {   
        String bt = 
        "\n<" + a + " vs " + b + ">\n\n"
        + a + "'s Stat\n[Hp: " + c + "/" + d + "\tDmg: " + e + "]\n\n"
        + b + "'s Stat\n[Hp: " + f + "/" + g + "\tDmg: " + h + "]\n";
        return new DarkSouls(bt);
    }
    
    public int CovBonus(String a, String b)
    {
        int x = 1;
        if(a.equals("Sunlight") && b.equals("hp")) x = 2;
        if(a.equals("Darkmoon") && b.equals("dmg")) x = 2;
        if(a.equals("Farron") && b.equals("bsl")) x = 2;
        return x;
    }
    
    public String Enemy()
    {
        final int numbers = 4;
                double r = Math.random();
                int Random = (int)(r * numbers);
                String x = "";
                if (Random == 0)
                {
                    x = "The Abyss Watcher";
                }
                else if (Random == 1)
                {
                    x = "Yhorm the Giant";
                }
                else if (Random == 2)
                {
                    x = "Aldrich the Devourer of God";
                }
                else if (Random == 3)
                {
                    x = "Lothric the Younger Prince";
                }
        return x;
    }
    
    public int EnemyStat(String a, String b, int c)
    {
        int x = 0;
        if(a.equals("The Abyss Watcher")) {
            if(b.equals("hp")) x = 20*c;
            if(b.equals("dmg")) x = 40*c;
        }
        
        if(a.equals("Yhorm the Giant")) {
            if(b.equals("hp")) x = 150*c;
            if(b.equals("dmg")) x = 5*c;
        }
        
        if(a.equals("Aldrich the Devourer of God")) {
            if(b.equals("hp")) x = 60*c;
            if(b.equals("dmg")) x = 15*c;
        }
        
        if(a.equals("Lothric the Younger Prince")) {
            if(b.equals("hp")) x = 40*c;
            if(b.equals("dmg")) x = 20*c;
        }
        
        return x;
    }
    
    public String Attack(String a, String b, int c)
    {
        String x = a + " attacked! " + b + " took " + c + " damage.";
        return x;
    }
    
    public int TakeDamage(int a, int b)
    {
        int x = a - b;
        return x;
    }
    
    public int  ParryChance()
    {
        final int numbers = 2;
                double r = Math.random();
                int x = (int)(r * numbers);
        return x;
    }
}

