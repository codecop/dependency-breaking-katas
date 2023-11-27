package org.codecop.dependencies.c;

class Оплата_ {
    public Квитанция coldWarOperation(Деньги сумма) {
        
        Квитанция квитанция = new Квитанция();
        Деньги ндс = сумма.процент(42);
        квитанция.установитьСуммy(сумма);
        квитанция.установитьНалог(ндс);
        квитанция.установитьИтог(сумма.add(ндс));

        /*
         * This static method should not be called in testing.
         * What to do?
         */
        ХранилищеКвитанций.launchNukesDestroyTheWorld(квитанция);

        return квитанция;
    }
}
