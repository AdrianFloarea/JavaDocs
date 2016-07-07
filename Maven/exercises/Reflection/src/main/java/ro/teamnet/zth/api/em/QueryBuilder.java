package ro.teamnet.zth.api.em;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by user on 7/7/2016.
 */
public class QueryBuilder {
    private Object tableName;
    private List<ColumnInfo> queryColumns;
    private QueryType queryType;
    private List<Condition> conditions;

    public String getValueForQuery(Object value){
        if(value instanceof String){
            return "'"+(String)value+"'";
        }
        if(value instanceof Date){
            DateFormat dateFormat=new SimpleDateFormat("mm/dd/yyyy");
            return "TO_DATE('"+dateFormat.format((Date)value)+"','mm-dd-YYYY";
        }
        return value.toString(); // to be verified
    }

    public QueryBuilder addCondition(Condition condition){
        return this.addCondition(condition);
    }

    public QueryBuilder setTableName(Object tableName){
        return this.setTableName(tableName);
    }

    public QueryBuilder addQueryColumns(List<ColumnInfo> columnInfos){
        return this.addQueryColumns(columnInfos);
    }

    public QueryBuilder setQueryType(QueryType queryType){
        return this.setQueryType(queryType);
    }

    private StringBuilder createSelectQuery(){
        StringBuilder rez=new StringBuilder("SELECT ");
        for(ColumnInfo ci:queryColumns){
            rez.append(ci.getDbName()+", ");
        }
        rez.deleteCharAt(rez.length()-1);
        rez.deleteCharAt(rez.length()-2);
        rez.append(" from ");
        rez.append(tableName.toString());
        if(conditions.size()!=0){
            rez.append(" where ");
            for(Condition c:conditions){
                rez.append(c.getColumnName()+"="+c.getValue().toString()+", ");
            }
            rez.deleteCharAt(rez.length()-1);
            rez.deleteCharAt(rez.length()-2);
        }
        rez.append(";");
        return rez;
    }

    private StringBuilder createDeleteQuery(){
        StringBuilder rez=new StringBuilder("DELETE FROM ");
        rez.append(tableName.toString());
        if(conditions.size()!=0){
            rez.append(" where ");
            for(Condition c:conditions){
                rez.append(c.getColumnName()+"="+c.getValue().toString()+", ");
            }
            rez.deleteCharAt(rez.length()-1);
            rez.deleteCharAt(rez.length()-2);
        }
        rez.append(";");
        return rez;
    }

    private StringBuilder createInsertQuery(){
        StringBuilder rez=new StringBuilder("INSERT INTO ");
        rez.append(tableName.toString());
        rez.append(" VALUES(");
        for(ColumnInfo cf:queryColumns){
            rez.append(cf.getValue().toString()+", ");
        }
        rez.deleteCharAt(rez.length()-1);
        rez.deleteCharAt(rez.length()-2);
        rez.append(");");
        return rez;
    }

    private StringBuilder createUpdateQuery(){
        StringBuilder rez=new StringBuilder("UPDATE ");
        rez.append(tableName.toString()+" SET ");
        for(ColumnInfo cf:queryColumns){
            rez.append(cf.getDbName()+"="+cf.getValue().toString()+", ");
        }
        rez.deleteCharAt(rez.length()-1);
        rez.deleteCharAt(rez.length()-2);
        if(conditions.size()!=0){
            rez.append(" where ");
            for(Condition c:conditions){
                rez.append(c.getColumnName()+"="+c.getValue().toString()+", ");
            }
            rez.deleteCharAt(rez.length()-1);
            rez.deleteCharAt(rez.length()-2);
        }
        rez.append(";");
        return rez;
    }

    public String createQuery(){

        if(queryType==QueryType.SELECT){
            return createSelectQuery().toString();
        }
        if(queryType==QueryType.UPDATE){
            return createUpdateQuery().toString();
        }
        if(queryType==QueryType.INSERT){
            return createInsertQuery().toString();
        }
        if(queryType==queryType.DELETE){
            return createDeleteQuery().toString();
        }
        return null;
    }
}
