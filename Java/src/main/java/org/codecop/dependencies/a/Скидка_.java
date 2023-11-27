package org.codecop.dependencies.a;

class Скидка_ {
    private final МаркетинговаяКампания маркетинговаяКампания;

    public Скидка_() {
        /*
         * This collaborator's methods cause problems in testing.
         * What to do?
         */
        this.маркетинговаяКампания = new МаркетинговаяКампания();
    }

    public Деньги скидкаДля(Деньги чистаяЦена) {
        
        if (маркетинговаяКампания.thisCallCausesProblemsInTesting()) {
            return чистаяЦена.уменьшитьНа(42);
        }
        
        if (чистаяЦена.moreThan(Деньги.ТЫСЯЧА)) {
            return чистаяЦена.уменьшитьНа(47);
        }
        
        if (чистаяЦена.moreThan(Деньги.СТО) && // 
                                маркетинговаяКампания.thisCallToo()) {
            return чистаяЦена.уменьшитьНа(11);
        }
        
        return чистаяЦена;
    }
}
