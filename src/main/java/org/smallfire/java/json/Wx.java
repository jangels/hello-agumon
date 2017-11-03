package org.smallfire.java.json;

/**
 * Created by Administrator on 2017/11/3.
 */
public class Wx {

    String  touser ;
    String  toutemplate_idser ;
    String  page ;
    String  form_id ;
    Data data ;

    String emphasis_keyword ;

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getToutemplate_idser() {
        return toutemplate_idser;
    }

    public void setToutemplate_idser(String toutemplate_idser) {
        this.toutemplate_idser = toutemplate_idser;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getForm_id() {
        return form_id;
    }

    public void setForm_id(String form_id) {
        this.form_id = form_id;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public void setEmphasis_keyword(String emphasis_keyword) {
        this.emphasis_keyword = emphasis_keyword;
    }
}
