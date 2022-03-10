package Practicum6_A;

import java.util.ArrayList;
import java.util.Locale;

public class Persoon {
    private String naam;
    private double budget;
    private ArrayList<Game> mijnGames = new ArrayList<>();

    public Persoon(String nm, double bud)
    {
        naam = nm; budget = bud;
    }

    public double getBudget()
    {
        String budgetString = String.format(Locale.US, "%.2f", budget);
        budget = Double.parseDouble(budgetString);
        return budget;
    }

    public boolean koop(Game g)
    {
        if (mijnGames.contains(g) == false && budget >= g.huidigeWaarde())
        {
            budget -= g.huidigeWaarde();
            mijnGames.add(g);
            return true;
        }
        return false;
    }

    public boolean verkoop(Game g, Persoon koper)
    {
        if (mijnGames.contains(g) && !koper.mijnGames.contains(g) && koper.budget > g.huidigeWaarde())
        {
            koper.budget -= g.huidigeWaarde();
            this.budget += g.huidigeWaarde();
            this.mijnGames.remove(g);
            koper.mijnGames.add(g);
            return true;
        }
        return false;
    }
    public String toString()
    {
        String budgetString = Double.toString(this.getBudget()).replace('.',',');
        if (budget%1==0) {
            budgetString += 0;
        }
        String result = naam + " heeft een budget van €" + budgetString + " en bezit de volgende games:";
        for (Game game : mijnGames)
        {
            result += "\n" + game.toString();
        }
        return result;
    }
}
