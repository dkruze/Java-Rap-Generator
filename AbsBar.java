public abstract class AbsBar {
    String template1;
    String template2;
    String template3;
    String template4;
    String template5;
    String noun1;
    String noun2;
    String verb1;
    String verb2;
    String adj1;
    String adj2;

    public AbsBar() {

    }

    public AbsBar(String _template1, String _template2, String _template3, String _template4, String _template5, String _noun1, String _noun2, String _verb1, String _verb2, String _adj1, String _adj2) {
        this.template1 = _template1;
        this.template2 = _template2;
        this.template3 = _template3;
        this.template4 = _template4;
        this.template5 = _template5;
        this.noun1 = _noun1;
        this.noun2 = _noun2;
        this.verb1 = _verb1;
        this.verb2 = _verb2;
        this.adj1 = _adj1;
        this.adj2 = _adj2;
    }

    public String getTemplate1() {
        return this.template1;
    }

    public void setTemplate1(String _template1) {
        this.template1 = _template1;
    }

    public String getTemplate2() {
        return this.template2;
    }

    public void setTemplate2(String _template2) {
        this.template2 = _template2;
    }

    public String getTemplate3() {
        return this.template3;
    }

    public void setTemplate3(String _template3) {
        this.template3 = _template3;
    }

    public String getTemplate4() {
        return this.template4;
    }

    public void setTemplate4(String _template4) {
        this.template4 = _template4;
    }

    public String getTemplate5() {
        return this.template5;
    }

    public void setTemplate5(String _template5) {
        this.template5 = _template5;
    }

    public String getNoun1() {
        return this.noun1;
    }

    public void setNoun1(String _noun1) {
        this.noun1 = _noun1;
    }

    public String getNoun2() {
        return this.noun2;
    }

    public void setNoun2(String _noun2) {
        this.noun2 = _noun2;
    }

    public String getVerb1() {
        return this.verb1;
    }

    public void setVerb1(String _verb1) {
        this.verb1 = _verb1;
    }

    public String getVerb2() {
        return this.verb2;
    }

    public void setVerb2(String _verb2) {
        this.verb2 = _verb2;
    }

    public String getAdj1() {
        return this.adj1;
    }

    public void setAdj1(String _adj1) {
        this.adj1 = _adj1;
    }

    public String getAdj2() {
        return this.adj2;
    }

    public void setAdj2(String _adj2) {
        this.adj2 = _adj2;
    }
}
