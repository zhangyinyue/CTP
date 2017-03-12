package com.ctp.model.vo;

/**
 * Created by Administrator on 2017/3/12 0012.
 */
public class BookVO extends PageVO{
    private String id;
    private String name;
    private String[] ids;
    private String idsStr;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String[] getIds() {
        return ids;
    }

    public String getIdsStr() {
        return idsStr;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIds(String[] ids) {
        this.ids = ids;
    }

    public void setIdsStr(String idsStr) {
        this.idsStr = idsStr;
    }
}
