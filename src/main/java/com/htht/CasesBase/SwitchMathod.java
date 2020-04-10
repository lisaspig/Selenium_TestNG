package com.htht.CasesBase;

public enum SwitchMathod {
    KEY_URL("url"),
    KEY_SEND( "sendkey"),
    KEY_CLICK( "click"),
    KEY_SELECT( "select"),
    KEY_DESELECT( "deselect"),
    KEY_SELECT_ALL( "select_all"),
    KEY_DESELECT_ALL( "deselect_all"),
    KEY_ACTION_CLICK( "action_click"),
    KEY_ACTION_SEND( "action_send"),
    KEY_JS( "js"),
    KEY_JS_ELE( "js_ele"),
    KEY_IFRAME("iframe"),
    KEY_IFRAME_OUT("iframe_out"),
    KEY_ASSERT( "assert");
    private String keyword;

    SwitchMathod(String keyword) {
        this.keyword = keyword;
    }
    public String getKeyword() {
        return keyword;
    }
    public void setKeyword(String keyword) {
        this.keyword =keyword;
    }
}
