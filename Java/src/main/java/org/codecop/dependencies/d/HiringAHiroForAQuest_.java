package org.codecop.dependencies.d;

public class HiringAHiroForAQuest_ {

    public Gold costToRunThisQuest(Kingdom toKingdom, Quest quest) {
        /*
         * It is possible to ask the ExplorationGuild during tests, 
         * but we have to play for each call. What to do?
         */

        if (ExplorationGuild.ask().isInAdventurousLands(toKingdom)) {

            // base price for quest into adventure land, like Eldoria
            return new Gold(5);

        } else if (ExplorationGuild.ask().isInMagicRealm(toKingdom)) {
            
            // magic is more expensive of course, like Shadowmere Kingdom
            Gold gold = new Gold(15);

            if (quest == Quest.DANGEROUS) {
                // more money please, e.g. Dragonspire Peaks
                gold = new Gold(40);
            }
            return gold;

        } else {
            
            // other kingdoms, e.g. Emberfall
            int daysByHorse = ExplorationGuild.ask().distanceTo(toKingdom);
            return new Gold(daysByHorse).times(10);
            
        }
    }
}
