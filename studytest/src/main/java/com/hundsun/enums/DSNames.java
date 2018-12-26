package com.hundsun.enums;

/**
 * @Description:
 * @Author wuyun
 * @date 2018/7/24 14:47
 *
 */
public enum DSNames {

    fsdpldb( "t_pl_", "api_");

    private String[] tablePrefixs;

    DSNames(String... tablePrefixs){
        this.tablePrefixs = tablePrefixs;
    }

    public String getTablePrefixsByString(){
        String tPrefixs="";
        StringBuffer _sb=new StringBuffer();
        if(tablePrefixs!=null) {
            for (int i = 0; i < tablePrefixs.length; i++) {
                _sb.append(tablePrefixs[i]).append(",");
            }
            tPrefixs=_sb.toString();
            if(tPrefixs.endsWith(",")){
                tPrefixs=tPrefixs.substring(0,tPrefixs.length()-1);
            }
        }
        return tPrefixs;
    }
}
