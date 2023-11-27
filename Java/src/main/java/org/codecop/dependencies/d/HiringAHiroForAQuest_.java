package org.codecop.dependencies.d;

class HiringAHiroForAQuest_ {
    public Gold costToRunThisQuest(Kingdom kingdom, Quest quest) {
        /*
         * It is possible to ask the ExplorationGuild during tests, 
         * but we have to play for each call. What to do?
         */

        if (ExplorationGuild.ask().isInAdventurousLands(kingdom)) {

            // base price for quest into adventure land, like Eldoria
            return new Gold(5);

        } else if (ExplorationGuild.ask().isInMagicRealm(kingdom)) {
            
            // magic is more expensive of course, like Shadowmere Kingdom
            Gold gold = new Gold(15);

            if (quest == Quest.DANGEROUS) {
                // more money please, e.g. Dragonspire Peaks
                gold = new Gold(40);
            }
            return gold;

        } else {
            
            // other kingdoms, e.g. Emberfall
            int daysByHorse = ExplorationGuild.ask().distanceTo(kingdom);
            return new Gold(daysByHorse).times(10);
            
        }
    }
}
