package org.codecop.dependencies.d;

public class HiringAHiroForAQuest_ {

    public Gold costToRunThisQuest(Kingdom toKingdom, Quest quest) {
        Gold gold;

        /*
         * It is possible to ask the ExplorationGuild during tests, 
         * but it is very slow. What to do?
         */
        if (ExplorationGuild.ask().isInAdventurousLands(toKingdom)) {
            // base price for quest into adventure land, like Eldoria
            gold = new Gold(5);

        } else if (ExplorationGuild.ask().isInMagicRealm(toKingdom)) {
            // magic is more expensive of course, like Shadowmere Kingdom
            gold = new Gold(15);

            if (quest == Quest.DANGEROUS) {
                // more money please, e.g. Dragonspire Peaks
                gold = new Gold(40);
            }

        } else {
            // other kingdoms, e.g. Emberfall
            int daysByHorse = ExplorationGuild.ask().distanceTo(toKingdom);
            gold = new Gold(daysByHorse).times(10);
        }

        return gold;
    }

}
